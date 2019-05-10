package cn.itrip.auth.Service;

import cn.itrip.beans.pojo.ItripUser;

import java.util.List;
import java.util.Set;

/**
 * 用户管理接口
 * @author hduser
 *
 */
public interface UserService {
	/**
	 * 根据用户编码获取用户
	 * @param userCode
	 * @return
	 */
	boolean getUserByUserCode(String userCode) throws Exception;
	/**
	 * 使用手机/邮箱创建用户账号
	 * @param user
	 * @throws Exception
	 */
	public void itriptxCreateUser(ItripUser user) throws Exception;

	/**
	 * 邮箱/手机号激活
	 * @param user 用户注册油箱/手机号
	 * @param code 激活码/注册码
	 * @return
	 * @throws Exception
	 */
	public boolean activate(String user, String code) throws Exception;

	/**
	 * 普通用户登录方法
	 * @param name
	 * @param password
	 * @return
	 */
	ItripUser doLogin(String name, String password) throws Exception;

	public void updateUser(ItripUser user) throws Exception;
	public void deleteUser(Long userId) throws Exception;
	public void changePassword(Long userId, String newPassword) throws Exception;
	ItripUser findOne(Long userId) throws Exception;
	List<ItripUser> findAll() throws Exception;
	public ItripUser findByUsername(String username) throws Exception;
	public Set<String> findRoles(String username);
	public Set<String> findPermissions(String username);

    void itriptCreateUser(ItripUser dbUser) throws Exception;
}
