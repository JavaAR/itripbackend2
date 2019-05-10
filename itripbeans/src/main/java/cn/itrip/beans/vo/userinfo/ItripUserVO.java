package cn.itrip.beans.vo.userinfo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * 接收客户端表单中的用户注册信息VO
 *
 * @author hduser
 *
 */
@ApiModel(value = "ItripUserVO", description = "用户注册信息")
public class ItripUserVO {

	@ApiModelProperty("[必填] 注册用户名称")
	private String userCode;
	@ApiModelProperty("[必填] 密码")
	private String userPassword;
	/*
	@ApiModelProperty("[非必填] 用户类型：0自注册、1微信、2QQ、3微博")
	private Integer userType;
	@ApiModelProperty("[非必填] 平台ID")
	private Long flatID;
	*/
	@ApiModelProperty("[非必填] 昵称")
	private String userName="";
	/*
	@ApiModelProperty("[非必填] 微信号")
	private String weChat;
	@ApiModelProperty("[非必填] QQ号")
	private String QQ;
	@ApiModelProperty("[非必填] 微博号")
	private String weibo;
	@ApiModelProperty("[非必填] 百度号")
	private String baidu;
	*/

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	/*
	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public Long getFlatID() {
		return flatID;
	}

	public void setFlatID(Long flatID) {
		this.flatID = flatID;
	}
*/
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
/*
	public String getWeChat() {
		return weChat;
	}

	public void setWeChat(String weChat) {
		this.weChat = weChat;
	}

	public String getQQ() {
		return QQ;
	}

	public void setQQ(String qQ) {
		QQ = qQ;
	}

	public String getWeibo() {
		return weibo;
	}

	public void setWeibo(String weibo) {
		this.weibo = weibo;
	}

	public String getBaidu() {
		return baidu;
	}

	public void setBaidu(String baidu) {
		this.baidu = baidu;
	}
*/
}
