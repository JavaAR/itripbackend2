package cn.itrip.auth.controller;

import cn.itrip.auth.Execption.ReplaceTokenExceprion;
import cn.itrip.auth.Service.TokenService;
import cn.itrip.beans.dto.Dto;
import cn.itrip.beans.vo.ItripTokenVO;
import cn.itrip.common.DtoUtil;
import cn.itrip.common.ErrorCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;

/**
 * token控制层
 */
@Api(value = "用户token控制层")
@Controller
@RequestMapping("api")
public class TokenController {
    @Resource
    private TokenService tokenService;

    /**
     * 置换用户token
     * @param request 请求头信息
     * @return 置换后的token对象
     */
    @ApiOperation(value = "置换用户的token",notes = "置换用户的token,token的置换时间为一小时之后,可能返回的错误码30006:token保护时间未到/旧token已经失效",
                   httpMethod = "POST",
                   produces = "application/json",
                   protocols = "http")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header",name = "user-agent",value = "用户登陆设备类型",required = true,dataType = "String"),
            @ApiImplicitParam(paramType = "header",name = "token",value = "用户的token",required = true,dataType = "String")
    })
    @ResponseBody
    @RequestMapping(value = "/retoken",method = RequestMethod.POST,produces = "application/json")
    public Dto doRetoken(HttpServletRequest request){
        try {
            //1.获取前端传来的token和客户端登录类型
            String header = request.getHeader("user-agent");
            System.out.println(header);
            String token = request.getHeader("token");
            //2.生成新的token
            String newToken = tokenService.replaceToken(token, header);
            //3.设置返回给前端的数据
            ItripTokenVO itripTokenVO = new ItripTokenVO();
              //设置新的token
            itripTokenVO.setToken(newToken);
              //设置token生成时间
            itripTokenVO.setGenTime(Calendar.getInstance().getTimeInMillis());
              //设置token过期时间
            itripTokenVO.setExpTime(Calendar.getInstance().getTimeInMillis()+TokenService.TOKEN_TIMEOUT*1000);
             //返回给前端
            return DtoUtil.returnDataSuccess(itripTokenVO);
        }catch (ReplaceTokenExceprion e){
            e.printStackTrace();
            return DtoUtil.returnFail(e.getMessage(),ErrorCode.AUTH_TOKEN_INVALID);
        }catch (Exception e) {
            e.printStackTrace();
            return DtoUtil.returnFail("服务器异常！", ErrorCode.AUTH_UNKNOWN);
        }
    }
}
