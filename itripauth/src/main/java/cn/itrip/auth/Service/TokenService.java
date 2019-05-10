package cn.itrip.auth.Service;

import cn.itrip.auth.Execption.ReplaceTokenExceprion;
import cn.itrip.beans.pojo.ItripUser;

import java.io.IOException;

/**
 * 用户token业务层
 */
public interface TokenService {
    /**
     * 设置token过期时间
     */
     int TOKEN_TIMEOUT = 2*60*60;
    /**
     * 设置token重置保护时间
     */
    int TOKEN_PORTECT_TIME=60*60;
    /**
     * 设置旧token置换后延长时间 两分钟
     *单位秒
     */
    int OLDTOKEN_PROLONG_TIME=2*60;

    /**
     * 用户登录生成token
     * @param header
     * @param itripUser
     * @return
     */
    String generateToken(String header, ItripUser itripUser) throws IOException, Exception;

    /**
     * 置换token
     * @param oldToken
     * @param userAgent
     * @return
     */
    String replaceToken(String oldToken,String userAgent) throws Exception;

    /**
     * 验证token 用于用户退出
     * @param token
     * @return
     */
    boolean verificationToken(String token) throws ReplaceTokenExceprion;
}
