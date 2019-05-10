package cn.itrip.auth.Service;

/**
 * 短信发送接口 
 * @author hduser
 *
 */
public interface SmsService {
	/**
	 * 通过通过云通信发送短信验证码
	 * @param to 发送的手机号
	 * @param templateId 短信模板id
	 * @param datas 替换短信模板的数据
	 */
	void sendMessageByYtx(String to, String templateId, String[] datas);

}
