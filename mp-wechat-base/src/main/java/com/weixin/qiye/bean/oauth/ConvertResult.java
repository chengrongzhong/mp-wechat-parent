package com.weixin.qiye.bean.oauth;

import com.weixin.common.bean.BaseResult;

/**
 * Created by fang on 2016/1/8.
 */
public class ConvertResult extends BaseResult{
    private String openid;
    private String appid;
    private String userid;

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }
}
