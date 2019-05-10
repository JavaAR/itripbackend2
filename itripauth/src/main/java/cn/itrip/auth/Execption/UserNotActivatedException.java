package cn.itrip.auth.Execption;

/**
 * 用户登录未激活异常
 */
public class UserNotActivatedException extends Exception {
    public UserNotActivatedException(String message) {
        super(message);
    }
}
