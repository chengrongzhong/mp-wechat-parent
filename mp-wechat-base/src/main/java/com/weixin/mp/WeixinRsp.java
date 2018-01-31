package com.weixin.mp;

/**
 * Created by fang on 2014/11/16.
 */
public class WeixinRsp {
    private String errcode;
    private String errmsg;

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public String getErrcode() {
        return errcode;
    }

    public void setErrcode(String errcode) {
        this.errcode = errcode;
    }
    public boolean isSuccess(){
    	return "0".equals(errcode);
    }
}
