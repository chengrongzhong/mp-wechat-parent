package com.weixin.common.bean;

/**
 * 微信请求状态数据
 * @author LiYi
 *
 */
public class BaseResult {

	private String errcode;
	private String errmsg;

	public BaseResult(){
	}

	public BaseResult(String code,String msg){
		this.errcode =  code;
		this.errmsg = msg;
	}

	public String getErrcode() {
		return errcode;
	}

	public void setErrcode(String errcode) {
		this.errcode = errcode;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	public BaseResult newResult(String code,String msg){
		return new BaseResult(code,msg);
	}

	public boolean isSuccess(){
		if (null==errmsg){
			return true;
		}
		return "0".equals(errcode);

	}

	public static BaseResult newOk(){
		return new BaseResult("0","ok");
	}
}
