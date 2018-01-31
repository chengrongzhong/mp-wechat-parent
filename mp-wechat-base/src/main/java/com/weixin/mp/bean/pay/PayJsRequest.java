package com.weixin.mp.bean.pay;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 支付 JS 请求
 * @author LiYi
 *
 */
public class PayJsRequest {

	private String appId;

	private String timeStamp;

	private String nonceStr;

	@JSONField(name="package")
	private String pkg;

	private String signType;

	private String paySign;

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getNonceStr() {
		return nonceStr;
	}

	public void setNonceStr(String nonceStr) {
		this.nonceStr = nonceStr;
	}

	public String getPackage() {
		return pkg;
	}

	public void setPackage(String pkg) {
		this.pkg = pkg;
	}

	public String getSignType() {
		return signType;
	}

	public void setSignType(String signType) {
		this.signType = signType;
	}

	public String getPaySign() {
		return paySign;
	}

	public void setPaySign(String paySign) {
		this.paySign = paySign;
	}

}
