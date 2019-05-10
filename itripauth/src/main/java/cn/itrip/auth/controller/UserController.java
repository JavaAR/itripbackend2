package cn.itrip.auth.controller;

import cn.itrip.auth.Execption.ActivationCodeErrorException;
import cn.itrip.auth.Service.UserService;
import cn.itrip.beans.dto.Dto;
import cn.itrip.beans.pojo.ItripUser;
import cn.itrip.beans.vo.userinfo.ItripUserVO;
import cn.itrip.common.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

/**
 *用户控制层
 */
@Api(value = "用户注册激活控制层")
@Controller
@RequestMapping("api")
public class UserController {
    @Resource
    private UserService userService;
    /**
     * 邮箱注册
     * @param itripUserVO
     * @return
     */
    @ApiOperation(value = "用户邮箱注册",
                  notes = "可能返回的错误码 30007:用户名密码格式不正确，30001:该用户已经注册，30000:服务器异常 注册成功用户为未激活状态，将会给用户邮箱发送32位验证码有效期为十分钟",
                  httpMethod = "POST",
                  protocols = "http",
                  produces ="application/json")
    @ResponseBody
    @RequestMapping(value = "/doregister", method = RequestMethod.POST,produces ="application/json")
    public Dto doRegisterByEmail(@RequestBody ItripUserVO itripUserVO){
         return doRegisterbyphone(itripUserVO);
    }
    /**
     * 用户注册方法(手机或邮箱)
     * @param itripUserVO
     * @return
     */
    @ApiOperation(value = "用户手机注册",
                  notes = "可能返回的错误码 30007:用户名密码格式不正确，30001:该用户已经注册，30000:服务器异常 注册成功用户为未激活状态，将会给用户手机发送6为验证码有效期为两分钟",
                  httpMethod = "POST",
                  protocols = "http",
                  produces = "application/json")
    @ResponseBody
    @RequestMapping(value ="registerbyphone",method = RequestMethod.POST,produces ="application/json")
    public Dto doRegisterbyphone(@RequestBody ItripUserVO itripUserVO){
        //1.判断手机/邮箱 格式是否正确  判断密码是否为空
        try {
            if((VerifyPhoneOrEmail.validPhone(itripUserVO.getUserCode()) || VerifyPhoneOrEmail.validEmail(itripUserVO.getUserCode()))
                         && EmptyUtils.isNotEmpty(itripUserVO.getUserPassword())){
                //2.查询数据库 判断手机号/邮箱是否注册
                boolean flag = userService.getUserByUserCode(itripUserVO.getUserCode());
                if (flag){
                    //设置字段
                    ItripUser itripUser = new ItripUser();
                    itripUser.setUserCode(itripUserVO.getUserCode());
                    itripUser.setUserPassword(MD5.getMd5(itripUserVO.getUserPassword(),32));
                    itripUser.setUserName(itripUserVO.getUserName());
                    itripUser.setUserType(0);//表示自注册
                    itripUser.setActivated(0);//表示未激活
                    itripUser.setCreationDate(new Date());
                    userService.itriptxCreateUser(itripUser);
                    return DtoUtil.returnSuccess();
                }else{
                    return DtoUtil.returnFail("该用户已经注册，请直接登录",ErrorCode.AUTH_USER_ALREADY_EXISTS);
                }
            }else {
                return DtoUtil.returnFail("请输入正确的用户信息", ErrorCode.AUTH_ILLEGAL_USERCODE);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return DtoUtil.returnFail("注册失败",ErrorCode.AUTH_UNKNOWN);
        }
    }

    /**
     * 校验邮箱注册用户名是否存在
     * @param name
     * @return
     */
    @ApiOperation(value = "邮箱注册校验",
                  notes = "可能返回的错误码30007:邮箱格式不正确，30001:邮箱已经注册，30000:服务器异常",
                  produces = "application/json",
                  httpMethod = "GET",
                  protocols = "HTTP")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "name",value = "用户填写的邮箱",required = true,dataType = "String")
    })
    @ResponseBody
    @RequestMapping(value = "/ckusr",method = RequestMethod.GET,produces = "application/json")
    public Dto chcketUserEmailIsExits(@RequestParam String name){
        try {
            if (!VerifyPhoneOrEmail.validEmail(name)){
                return DtoUtil.returnFail("邮箱格式不正确",ErrorCode.AUTH_ILLEGAL_USERCODE);
            }else{
                if (userService.getUserByUserCode(name)){
                   return DtoUtil.returnSuccess("可以使用的用户名");
                }else{
                    return DtoUtil.returnFail("该邮箱已经注册",ErrorCode.AUTH_USER_ALREADY_EXISTS);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return DtoUtil.returnFail("服务器异常",ErrorCode.AUTH_UNKNOWN);
        }
    }

    /**
     * 激活用户方法手机激活
     * @param user
     * @param code
     * @return
     */
    @ApiOperation(value ="手机激活",
            notes = "可能返回的错误码30007:用户输入的激活信息有误，30004:用户输入的激活码不正确/激活失败/服务器异常",
            httpMethod = "PUT",
            protocols = "HTTP",
            produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "user",value = "用户手机",required = true,dataType = "String"),
            @ApiImplicitParam(paramType = "query",name = "code",value = "激活码",required = true,dataType = "String")
    })
    @ResponseBody
    @RequestMapping(value = "/validatephone",method = RequestMethod.PUT,produces = "application/json")
    public Dto doUserActivateByPhone(@RequestParam String user,@RequestParam String code){
        return doUserActivate(user,code);
    }


    /**
     * 激活用户方法/邮箱/手机
     * @param user
     * @param code
     * @return
     */
    @ApiOperation(value ="邮箱激活",
                  notes = "可能返回的错误码30007:用户输入的激活信息有误，30004:用户输入的激活码不正确/激活失败/服务器异常",
                  httpMethod = "PUT",
                  protocols = "HTTP",
                  produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "user",value = "用户邮箱",required = true,dataType = "String"),
            @ApiImplicitParam(paramType = "query",name = "code",value = "激活码",required = true,dataType = "String")
    })
    @ResponseBody
    @RequestMapping(value = "/activate",method = RequestMethod.PUT,produces = "application/json")
    public Dto doUserActivate(@RequestParam String user,@RequestParam String code){
        try {
            //1.判断用户的手机/邮箱格式是否正确
            if ((VerifyPhoneOrEmail.validPhone(user)||VerifyPhoneOrEmail.validEmail(user))&&EmptyUtils.isNotEmpty(code)){
                boolean flag = userService.activate(user, code);
                if(flag){
                    return DtoUtil.returnSuccess();
                }else{
                    return DtoUtil.returnFail("激活失败，请重试",ErrorCode.AUTH_ACTIVATE_FAILED);
                }
            }else{
                return DtoUtil.returnFail("请输入正确的激活信息",ErrorCode.AUTH_ILLEGAL_USERCODE);
            }
        }catch (ActivationCodeErrorException e){
            e.printStackTrace();
            return DtoUtil.returnFail(e.getMessage(),ErrorCode.AUTH_ACTIVATE_FAILED);
        }catch (Exception e) {
            e.printStackTrace();
            return DtoUtil.returnFail("服务器忙，请重试",ErrorCode.AUTH_ACTIVATE_FAILED);
        }
    }
}