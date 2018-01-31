package com.weixin.qiye.bean.third;

import com.weixin.mp.util.JsonUtil;

import java.util.List;

/**
 * Created by fang on 2016/1/11.
 */
public class Permanent {
    private String access_token;

    private int expires_in;

    private String permanent_code;

    private AuthCorpInfo auth_corp_info;

    private AuthInfo auth_info;

    private AuthUserInfo auth_user_info;

    public void setAccess_token(String access_token){
        this.access_token = access_token;
    }
    public String getAccess_token(){
        return this.access_token;
    }
    public void setExpires_in(int expires_in){
        this.expires_in = expires_in;
    }
    public int getExpires_in(){
        return this.expires_in;
    }
    public void setPermanent_code(String permanent_code){
        this.permanent_code = permanent_code;
    }
    public String getPermanent_code(){
        return this.permanent_code;
    }
    public void setAuth_corp_info(AuthCorpInfo auth_corp_info){
        this.auth_corp_info = auth_corp_info;
    }
    public AuthCorpInfo getAuth_corp_info(){
        return this.auth_corp_info;
    }
    public void setAuth_info(AuthInfo auth_info){
        this.auth_info = auth_info;
    }
    public AuthInfo getAuth_info(){
        return this.auth_info;
    }
    public void setAuth_user_info(AuthUserInfo auth_user_info){
        this.auth_user_info = auth_user_info;
    }
    public AuthUserInfo getAuth_user_info(){
        return this.auth_user_info;
    }
}
