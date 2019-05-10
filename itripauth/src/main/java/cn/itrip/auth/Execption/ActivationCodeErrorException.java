package cn.itrip.auth.Execption;

/**
 * 激活码错误异常
 */
public class ActivationCodeErrorException extends Exception {

    public ActivationCodeErrorException(String message) {
        super(message);
    }
}
