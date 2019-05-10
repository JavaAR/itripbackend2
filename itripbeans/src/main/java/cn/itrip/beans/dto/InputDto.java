package cn.itrip.beans.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * 数据传输对象（输入对象）
 */
public class InputDto {

	@ApiModelProperty(value="单一参数传入")
	private String paramString;
	@ApiModelProperty(value="多个参数传入")
	private String[] paramStrings;
	public String getParamString() {
		return paramString;
	}
	public void setParamString(String paramString) {
		this.paramString = paramString;
	}
	public String[] getParamStrings() {
		return paramStrings;
	}
	public void setParamStrings(String[] paramStrings) {
		this.paramStrings = paramStrings;
	}
	
	
	
}
