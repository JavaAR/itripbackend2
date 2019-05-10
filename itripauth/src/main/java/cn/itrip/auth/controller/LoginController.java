package cn.itrip.auth.controller;

import cn.itrip.auth.Execption.ReplaceTokenExceprion;
import cn.itrip.auth.Execption.UserNotActivatedException;
import cn.itrip.auth.Service.TokenService;
import cn.itrip.auth.Service.UserService;
import cn.itrip.beans.dto.Dto;
import cn.itrip.beans.pojo.ItripUser;
import cn.itrip.beans.vo.ItripTokenVO;
import cn.itrip.common.DtoUtil;
import cn.itrip.common.EmptyUtils;
import cn.itrip.common.ErrorCode;
import cn.itrip.common.MD5;
import io.swagger.annotations.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;

/**
 * （自注册用户）普通用户登录注销控制层
 */
@Api(value = "自用户登录注销")
@Controller
@RequestMapping("api")
public class LoginController {
    @Resource
    private TokenService tokenService;
    @Resource
    private UserService userService;

    /**
     * 自注册登录
     * @param name 用户名
     * @param password 密码
     * @param request 请求头
     * @return
     */
    @ApiOperation(value = "自注册用户登录",
                  notes = "可能返回的错误码：30002:用户名密码错误，30003:用户明或密码为空，30004:用户未激活，30000:服务器异常",
                  httpMethod = "POST",
                  produces ="application/json",
                  protocols = "http")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "name",value = "用户名",required = true,dataType = "String"),
            @ApiImplicitParam(paramType = "query",name = "password",value = "密码",required = true,dataType = "String"),
            @ApiImplicitParam(paramType = "header",name = "user-agent",value = "用户登录设备类型",required = true,dataType = "String")
    })
    @ResponseBody
    @RequestMapping(value = "/dologin", method = RequestMethod.POST, produces = "application/json")
    public Dto doLogin(@RequestParam String name, @RequestParam String password, HttpServletRequest request) {
        //1.判断用户名密码是否为空
        try {
            if (EmptyUtils.isNotEmpty(name) && EmptyUtils.isNotEmpty(password)) {
                //2.去数据库查询该用户是否存在
                ItripUser itripUser = userService.doLogin(name, MD5.getMd5(password,32));
                if (itripUser != null) {
                    //3.生成token(根据登录客户端平台（手机/pc） 用户信息)
                   String token = tokenService.generateToken(request.getHeader("user-agent"),itripUser);
                   //4.组织返回前端的数据
                    ItripTokenVO itripTokenVO = new ItripTokenVO();
                    itripTokenVO.setToken(token);
                    //设置起始时间
                    itripTokenVO.setGenTime(Calendar.getInstance().getTimeInMillis());
                    //设置过期时间
                    itripTokenVO.setExpTime(Calendar.getInstance().getTimeInMillis()+tokenService.TOKEN_TIMEOUT*1000);
                    //5.返回数据
                    return DtoUtil.returnDataSuccess(itripTokenVO);
                } else {
                    return DtoUtil.returnFail("用户名密码错误", ErrorCode.AUTH_AUTHENTICATION_FAILED);
                }
            } else {
                return DtoUtil.returnFail("用户名密码不能为空", ErrorCode.AUTH_PARAMETER_ERROR);
            }
        }catch (UserNotActivatedException e){
            e.printStackTrace();
            return DtoUtil.returnFail(e.getMessage(),ErrorCode.AUTH_ACTIVATE_FAILED);

        } catch (Exception e) {
            e.printStackTrace();
            return DtoUtil.returnFail("服务器繁忙,请重试",ErrorCode.AUTH_UNKNOWN);
        }
    }

    /**
     * 自注册用户退出登录
     * @param request
     * @return
     * 1.点击退出
     * 2.携带token信息前往服务器
     * 3.服务器验证token是否有效
     * 4.如果有效删除token(redis)
     * 5.提示注销成功
     */
    @ApiOperation(value = "用户注销",
                  notes = "将用户的token从redis中删除，返回的状态码可能有 30006:退出失败/token不存在，30000:系统错误",
                  httpMethod = "GET",
                  produces ="application/json",
                  protocols = "http")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header",name = "token",value = "用户的token",required = true,dataType = "String")
    })
    @ResponseBody
    @RequestMapping(value = "/logout",method =RequestMethod.GET,produces = "application/json")
    public  Dto doLoginOut(HttpServletRequest request){
        try {
            String token = request.getHeader("token");
            boolean flag = tokenService.verificationToken(token);
            if (!flag){
                return DtoUtil.returnFail("退出失败",ErrorCode.AUTH_TOKEN_INVALID);
            }
            return DtoUtil.returnSuccess("退出成功");
        } catch (ReplaceTokenExceprion exceprion) {
            exceprion.printStackTrace();
            return DtoUtil.returnFail(exceprion.getMessage(),ErrorCode.AUTH_TOKEN_INVALID);
        }catch (Exception e){
            e.printStackTrace();
            return DtoUtil.returnFail("服务器忙，请重试",ErrorCode.AUTH_UNKNOWN);
        }
    }
}
