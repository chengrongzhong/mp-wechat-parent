package com.weixin.qiye.bean.third;

/**
 * Created by fang on 2016/1/11.
 */
public class ProviderToken {
    private String provider_access_token;
    private int expires_in;

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }

    public String getProvider_access_token() {
        return provider_access_token;
    }

    public void setProvider_access_token(String provider_access_token) {
        this.provider_access_token = provider_access_token;
    }
}
