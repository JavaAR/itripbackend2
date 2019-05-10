package cn.itrip.auth.Service;


import cn.itrip.auth.Execption.ActivationCodeErrorException;
import cn.itrip.auth.Execption.UserNotActivatedException;
import cn.itrip.beans.pojo.ItripUser;
import cn.itrip.common.MD5;
import cn.itrip.common.RedisAPI;
import cn.itrip.common.VerifyPhoneOrEmail;
import cn.itrip.dao.user.ItripUserMapper;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

/**
 * 用户管理接口的实现
 * @author hduser
 *
 */
@Service("useService")
public class UserServiceImpl implements UserService {

	private Logger logger=Logger.getLogger(UserServiceImpl.class);
    @Resource
    private ItripUserMapper itripUserMapper;
    @Resource
    private RedisAPI redisAPI;
    @Resource
    private SmsService smsService;
    @Resource
	private EmailService emailService;
	//过期时间（分钟）
	private Integer expire=1;

	/**
	 * 根据用户编码获取用户
	 * @param userCode
	 * @return boolean
	 * @throws Exception
	 */
	@Override
	public boolean getUserByUserCode(String userCode) throws Exception {
		HashMap<String, Object> map = new HashMap<>();
		map.put("userCode",userCode);
		List<ItripUser> list = itripUserMapper.getItripUserListByMap(map);
        if(list==null || list.size()==0){
         return true;
		}
		return false;
	}

    /**
     * 创建手机账号/邮箱帐号
     */
    @Transactional
    @Override
	public void itriptxCreateUser(ItripUser user) throws Exception {
    	//判断用户账号是手机号还是邮箱账号
		if(VerifyPhoneOrEmail.validPhone(user.getUserCode())){
		//手机号注册
		// 发送短信验证码
		//生成6为随机数
		int randonCode = (int)(Math.random()*(1000000-100000))+100000;
		String phoneAuthCode = Integer.toString(randonCode);
		smsService.sendMessageByYtx(user.getUserCode(),"1",new String[]{phoneAuthCode,expire.toString()});
		//缓存验证码
		redisAPI.set("userCode"+user.getUserCode(),expire*120,phoneAuthCode);
		//保存用户信息
		itripUserMapper.insertItripUser(user);
		}else if(VerifyPhoneOrEmail.validEmail(user.getUserCode())){
		//邮箱注册
		//生成32为随机数
		String EmialAuthCode = MD5.getMd5(Calendar.getInstance().getTimeInMillis()+""+user.getUserCode(),32);
		//发送邮箱验证码
		emailService.sendEmailSimple(user.getUserCode(),EmialAuthCode);
		//将数据保存到redis中
		redisAPI.set("userCode"+user.getUserCode(),expire*600,EmialAuthCode);
		//保存用户信息
		itripUserMapper.insertItripUser(user);
		}

		/*//发送短信验证码
		//生成6为随机数
		int randonCode = (int)(Math.random()*(1000000-100000))+100000;
		String authCode = Integer.toString(randonCode);
		smsService.sendMessageByYtx(user.getUserCode(),"1",new String[]{authCode,expire.toString()});
		//缓存验证码
		redisAPI.set("userCode"+user.getUserCode(),expire*60,authCode);
		//保存用户信息
		itripUserMapper.insertItripUser(user);*/
	}
    /**
     * 修改密码
     * @param userId
     * @param newPassword
     * @throws Exception
     */
    public void changePassword(Long userId, String newPassword) throws Exception {
        ItripUser user =itripUserMapper.getItripUserById(userId);
        user.setUserPassword(newPassword);
        itripUserMapper.updateItripUser(user);
    }

    /**
     * 根据用户名查找用户
     * @param username
     * @return bean
     * @throws Exception
     */
    public ItripUser findByUsername(String username) throws Exception {
        Map<String, Object> param=new HashMap();
        param.put("userCode", username);
		List<ItripUser> list= itripUserMapper.getItripUserListByMap(param);
		if(list.size()>0)
			return list.get(0);
		else
			return null;
    }

	/**
	 * 用户激活操作
	 * @param user 用户注册邮箱/手机号
	 * @param code 激活码/验证码
	 * @return
	 * @throws Exception
	 */
	@Transactional
	@Override
	public boolean activate(String user, String code) throws Exception {
		//1.查询用户编码在Redis中是否存在
		if (redisAPI.exist("userCode"+user)){
			//2.检查key对应的value是否正确
			if (redisAPI.get("userCode"+user).equals(code)){
			//3.查询相互数据库用户
				ItripUser itripUser =this.findByUsername(user);
				if (itripUser!=null){
					//4 .修改数据字段信息
					itripUser.setFlatID(itripUser.getId());
					itripUser.setActivated(1);
					itripUserMapper.updateItripUser(itripUser);
					return true;
				}
			}else{
				throw new ActivationCodeErrorException("激活码错误");
			}
		}
		return false;
	}

	/**
	 * 自注册用户登录方法实现
	 * @param name
	 * @param password
	 * @return
	 */
	@Override
	public ItripUser doLogin(String name, String password) throws Exception {
     //1.根据用户名查询用户
		ItripUser user = this.findByUsername(name);
		//2.用户名和密码正确
		if (user!=null && user.getUserPassword().equals(password)){
			//3.用户处于已激活状态
			if(user.getActivated()==1){
               return user;
			}else{
				throw new UserNotActivatedException("用户还未激活，请先去激活");
			}
		}
		return null;
	}

	public Set<String> findRoles(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<String> findPermissions(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 第三方登录创建用户
	 * @param dbUser
	 */
	@Override
	public void itriptCreateUser(ItripUser dbUser) throws Exception {
			itripUserMapper.insertItripUser(dbUser);
	}

	public void updateUser(ItripUser user) throws Exception {
		itripUserMapper.updateItripUser(user);
	}

	public void deleteUser(Long userId) throws Exception {
		itripUserMapper.deleteItripUserById(userId);
	}

	public ItripUser findOne(Long userId) throws Exception {
		return itripUserMapper.getItripUserById(userId);
	}

	public List<ItripUser> findAll() throws Exception {
		return itripUserMapper.getItripUserListByMap(null);
	}


}
