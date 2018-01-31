package com.weixin.qiye.bean.third;

/**
 * Created by fang on 2016/1/11.
 */
public class SuiteToken {
    private String pre_auth_code;
    private String suite_access_token;
    private int expires_in;

    public String getPre_auth_code() {
        return pre_auth_code;
    }

    public void setPre_auth_code(String pre_auth_code) {
        this.pre_auth_code = pre_auth_code;
    }

    public String getSuite_access_token() {
        return suite_access_token;
    }

    public void setSuite_access_token(String suite_access_token) {
        this.suite_access_token = suite_access_token;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }
}
