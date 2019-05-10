package cn.itrip.auth.Service;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 邮件接口实现类
 */
@Service("emailService")
public class EmailServiceImpl implements EmailService {
    @Resource
    private MailSender mailSender;
    @Resource
    private SimpleMailMessage simpleMailMessage;

    /**
     * 发送邮件方法
     * @param to 发送给谁
     * @param context 激活码
     */
    @Override
    public void sendEmailSimple(String to, String context) {
        simpleMailMessage.setTo(to);
        simpleMailMessage.setText("邮箱注册:"+to+";激活码:"+context);
        mailSender.send(simpleMailMessage);
    }
}
