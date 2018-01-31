package com.weixin.qiye.bean.third;

import com.weixin.common.bean.BaseResult;

/**
 * Created by fang on 2016/1/11.
 */
public class LoginUrlResult extends BaseResult {
    private String login_url;
    private int expires_in;

    public String getLogin_url() {
        return login_url;
    }

    public void setLogin_url(String login_url) {
        this.login_url = login_url;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }
}
