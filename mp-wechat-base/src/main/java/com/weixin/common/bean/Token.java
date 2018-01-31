package com.weixin.common.bean;

public class Token extends BaseResult {

	// 接口访问凭证
	private String access_token;
	// 凭证有效期，单位：秒
	private int expires_in;

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String accessToken) {
		access_token = accessToken;
	}

	public int getExpires_in() {
		return expires_in;
	}

	public void setExpires_in(int expiresIn) {
		expires_in = expiresIn;
	}

}
