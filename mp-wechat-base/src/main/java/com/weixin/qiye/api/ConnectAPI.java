package com.weixin.qiye.api;

import com.weixin.common.bean.Token;
import com.weixin.common.client.LocalHttpClient;
import com.weixin.qiye.bean.connect.ServerIpResult;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;

/**
 * 建立连接
 * Created by fang on 2015/12/31.
 */
public class ConnectAPI extends BaseAPI {
    //获取AccessToken
    //Https请求方式: GET
    //https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=id&corpsecret=secrect
    public static Token getToken(String cropid,String cropsecret){
        HttpUriRequest httpUriRequest = RequestBuilder.get()
                .setUri(BASE_URI + "/cgi-bin/gettoken")
                .addParameter("corpid", cropid)
                .addParameter("corpsecret", cropsecret)
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest,Token.class);
    }

    //获取微信服务器的ip段
    //Https请求方式: GET
    //https://qyapi.weixin.qq.com/cgi-bin/getcallbackip?access_token=ACCESS_TOKEN
    public static ServerIpResult getCallbackIP(String token){
        HttpUriRequest httpUriRequest = RequestBuilder.get()
                .setUri(BASE_URI + "/cgi-bin/getcallbackip")
                .addParameter("access_token", token)
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest,ServerIpResult.class);
    }

}
