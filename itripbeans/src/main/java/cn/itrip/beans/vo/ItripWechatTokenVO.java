package cn.itrip.beans.vo;

/**
 * 整合本地会话与微信会话
 * @author hduser
 *
 */
public class ItripWechatTokenVO extends ItripTokenVO {

	private String accessToken;
	private String expiresIn;
	private String refreshToken;
	private String openid;
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public String getExpiresIn() {
		return expiresIn;
	}
	public void setExpiresIn(String expiresIn) {
		this.expiresIn = expiresIn;
	}
	public String getRefreshToken() {
		return refreshToken;
	}
	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public ItripWechatTokenVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ItripWechatTokenVO(String token, long expTime, long genTime) {
		super(token, expTime, genTime);
		// TODO Auto-generated constructor stub
	}
	
	
}
