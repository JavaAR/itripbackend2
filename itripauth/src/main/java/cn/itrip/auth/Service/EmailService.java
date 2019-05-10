package cn.itrip.auth.Service;

/**
 * 邮件接口
 */
public interface EmailService {
    /**
     * 发送邮件方法
     * @param to
     * @param context
     */
    void sendEmailSimple(String to,String context);


}
