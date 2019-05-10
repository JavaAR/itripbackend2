package cn.itrip.beans.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 返回前端-Token相关VO
 */
@ApiModel(value="ItripTokenVO",description="用户认证凭据信息")
public class ItripTokenVO implements Serializable {
	/**
	 * 用户认证凭据
	 */
	@ApiModelProperty("用户认证凭据")
	private String token;
	/**
	 * 过期时间
	 */
	@ApiModelProperty("过期时间，单位：毫秒")
	private long expTime;
	/**
	 * 生成时间
	 */
	@ApiModelProperty("生成时间，单位：毫秒")
	private long genTime;
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public long getExpTime() {
		return expTime;
	}
	public void setExpTime(long expTime) {
		this.expTime = expTime;
	}
	public long getGenTime() {
		return genTime;
	}
	public void setGenTime(long genTime) {
		this.genTime = genTime;
	}
	
	public ItripTokenVO() {
		super();
	}
	public ItripTokenVO(String token, long expTime, long genTime) {
		super();
		this.token = token;
		this.expTime = expTime;
		this.genTime = genTime;
	}
	
	
}
