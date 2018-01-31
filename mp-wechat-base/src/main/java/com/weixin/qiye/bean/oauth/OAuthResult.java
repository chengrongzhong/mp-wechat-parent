package com.weixin.qiye.bean.oauth;

import com.weixin.common.bean.BaseResult;

/**
 * Created by fang on 2016/1/8.
 */
public class OAuthResult extends BaseResult {
    private String UserId;
    private String DeviceId;
    private String OpenId;

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getDeviceId() {
        return DeviceId;
    }

    public void setDeviceId(String deviceId) {
        DeviceId = deviceId;
    }

    public String getOpenId() {
        return OpenId;
    }

    public void setOpenId(String openId) {
        OpenId = openId;
    }
}
