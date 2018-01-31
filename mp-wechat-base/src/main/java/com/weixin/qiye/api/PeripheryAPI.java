package com.weixin.qiye.api;

import com.weixin.common.client.LocalHttpClient;
import com.weixin.qiye.bean.shake.ShakeResult;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;

import java.nio.charset.Charset;

/**
 * 企业号摇一摇周边
 * Created by fang on 2015/12/31.
 */
public class PeripheryAPI extends BaseAPI {
    /**
     获取设备及用户信息


     接口说明

     该API 用于获取设备信息，包括UUID、major、minor，以及距离、openID等信息。

     请求说明

     Https请求方式: POST

     https://qyapi.weixin.qq.com/cgi-bin/shakearound/getshakeinfo?access_token=ACCESS_TOKEN
     */
    public static  ShakeResult shakeInfo(String access_token,String ticket){
        String json = "{\"ticket\":\""+ticket+"\"}";
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setUri(BASE_URI + "/cgi-bin/shakearound/getshakeinfo")
                .addParameter("access_token", access_token)
                .setEntity(new StringEntity(json, Charset.forName("utf-8")))
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest, ShakeResult.class);
    }
}
