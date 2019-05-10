package cn.itrip.auth.controller;

import cn.itrip.auth.Service.TokenService;
import cn.itrip.auth.Service.UserService;
import cn.itrip.beans.dto.Dto;
import cn.itrip.beans.pojo.ItripUser;
import cn.itrip.common.DtoUtil;
import cn.itrip.common.UrlUtils;
import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

/**
 * 微博登陆/注销控制层
 */
@Api(value = "微博登录注销控制层")
@Controller
@RequestMapping("/vendors")
public class weboLoginController {
    @Resource
    private UserService userService;
    @Resource
    private TokenService tokenService;

    /**
     * https://api.weibo.com/oauth2/authorize?client_id=YOUR_CLIENT_ID&response_type=code&redirect_uri=YOUR_REGISTERED_REDIRECT_URI
     * 用户授权页面
     *
     */
    @RequestMapping(value = "/sina/login",method = RequestMethod.GET)
    public void doweboLogin(HttpServletResponse response){
        //获取用户授权之后，获取对应的code
        try {
            String Url = "https://api.weibo.com/oauth2/authorize?client_id=2459121216&response_type=code&redirect_uri=http://www.ar.itrip.com/auth/vendors/sina/callback";
            response.sendRedirect(Url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*  StringBuilder builder = new StringBuilder("https://api.weibo.com/oauth2/authorize?");
        builder.append("client_id="+"2459121216");
        builder.append("$response_type=code");
        builder.append("&redirect_uri="+"http://www.ar.itrip.com/auth/vendors/sina/callback");
        UrlUtils.loadURL(builder.toString());*/
    }

    /**
     * https://api.weibo.com/oauth2/access_token?client_id=YOUR_CLIENT_ID&client_secret=YOUR_CLIENT_SECRET&grant_type=authorization_code&redirect_uri=YOUR_REGISTERED_REDIRECT_URI&code=CODE
     * 微博回调的code
     * 获取token
     * @param code
     */
    @RequestMapping(value ="/sina/callback")
    public void weboCallBack(@RequestParam(value = "code") String code, HttpServletResponse response, HttpServletRequest request){
        //根据上个方法返回的code获取token
        try {
            request.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=utf-8");
            String url = "https://api.weibo.com/oauth2/access_token?client_id=2459121216&client_secret=5b3226e8d50c36f78a659ba8b3bd5986&grant_type=authorization_code&redirect_uri=http://www.ar.itrip.com/auth/vendors/sina/callback&code="+code;
            String backParems =  UrlUtils.loadURLByPost(url);
       /* StringBuilder builder = new StringBuilder("https://api.weibo.com/oauth2/access_token?");
        builder.append("client_id="+"2459121216");
        builder.append("&client_secret="+"5b3226e8d50c36f78a659ba8b3bd5986");
        builder.append("&grant_type=authorization_code");
        builder.append("&redirect_uri=http://www.ar.itrip.com/auth/vendors/sina/callback");
        builder.append("&code="+code);
        String backParems = UrlUtils.loadURL(builder.toString());*/
            Map<String,Object> tokenJsonMap = JSON.parseObject(backParems, Map.class);
            //获取返回的token
            String access_token = (String) tokenJsonMap.get("access_token");
            String uid = (String) tokenJsonMap.get("uid");
              //查询用户access_token的授权相关信息
            String userInfo = UrlUtils.loadURL("https://api.weibo.com/2/users/show.json?"+"access_token="+access_token+"&uid="+uid);
            Map<String,Object> userInfoJsonMap = JSON.parseObject(userInfo, Map.class);
           //获取用户昵称screen_name
           String weboname = (String) userInfoJsonMap.get("screen_name");
            //验证数据库是否存在本用户
            ItripUser dbUser = userService.findByUsername(uid);
            if(dbUser==null){
                 dbUser = new ItripUser();
                //创建时间
                dbUser.setCreationDate(new Date());
                //将微博的uid作为数据库的userCode
                dbUser.setUserCode(uid);
                //用户类型
                dbUser.setUserType(3);
                //用户平台类型
                dbUser.setFlatID(Long.parseLong(uid));
                //用户昵称
                dbUser.setUserName(weboname);
                //是否激活
                dbUser.setActivated(1);
                userService.itriptCreateUser(dbUser);
            }
            //生成token并保存
            String token = tokenService.generateToken(request.getHeader("user-agent"), dbUser);
            //返回前端处理
            StringBuilder builder =  new StringBuilder();
            builder.append("http://www.ar.itrip.com/#/login");
            builder.append("?user_type=1&token="+token);
            builder.append("&access_token="+access_token);
            builder.append("&expires_in="+tokenJsonMap.get("expires_in").toString());
            builder.append("&openid="+uid );
            response.sendRedirect(builder.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 微博用户登录获取用户信息
     * @param accessToken
     * @param openid
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/sina/user/info",method = RequestMethod.GET,produces = "application/json")
    public Dto doGetWeiBoLoginUserInfo(@RequestParam String accessToken,
                                       @RequestParam String openid){
    String userInfo = UrlUtils.loadURL("https://api.weibo.com/2/users/show.json?"+"access_token="+accessToken+"&uid="+openid);
    Map<String,Object> userInfoJsonMap = JSON.parseObject(userInfo, Map.class);
        String nickname  = (String) userInfoJsonMap.get("screen_name");
        userInfoJsonMap.put("nickname",nickname);
        return DtoUtil.returnDataSuccess(userInfoJsonMap);
    }



}
