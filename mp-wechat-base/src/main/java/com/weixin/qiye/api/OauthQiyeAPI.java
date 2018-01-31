package com.weixin.qiye.api;

import com.weixin.common.client.LocalHttpClient;
import com.weixin.qiye.bean.third.LoginUrlResult;
import com.weixin.qiye.bean.third.ProviderToken;
import com.weixin.qiye.bean.third.SysInfoResult;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;

import java.nio.charset.Charset;

/**
 * 企业号登录授权
 * Created by fang on 2015/12/31.
 */
public class OauthQiyeAPI extends BaseAPI {
    /**
     获取应用提供商凭证

     接口调用请求说明

     https请求方式: POST

     https://qyapi.weixin.qq.com/cgi-bin/service/get_provider_token
     */
    public static  ProviderToken getProviderToken(String cropid,String provider_secret){
        String json = "{\"cropid\":\""+cropid+"\",\"provider_secret\":\""+provider_secret+"\"}";
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setUri(BASE_URI + "/cgi-bin/service/get_provider_token")
                .setEntity(new StringEntity(json, Charset.forName("utf-8")))
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest, ProviderToken.class);
    }

    /**
     获取企业号管理员登录信息

     接口调用请求说明

     https请求方式: POST

     https://qyapi.weixin.qq.com/cgi-bin/service/get_login_info?provider_access_token=PROVIDER_ACCESS_TOKEN
      */
    public static  SysInfoResult getLoginInfo(String provider_access_token ,String auth_code){
        String json = "{\"auth_code\":\""+auth_code+"\"}";
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setUri(BASE_URI + "/cgi-bin/service/get_login_info")
                .addParameter("suite_access_token", provider_access_token)
                .setEntity(new StringEntity(json, Charset.forName("utf-8")))
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest, SysInfoResult.class);
    }

    /**
     获取登录企业号官网的url

     接口调用请求说明

     https请求方式: POST

     https://qyapi.weixin.qq.com/cgi-bin/service/get_login_url?provider_access_token=PROVIDER_ACCESS_TOKEN
     */
    public static  LoginUrlResult getLoginUrl(String provider_access_token,String login_ticket,String target,int agentid){
        String json = "{\"login_ticket\":\"" + login_ticket + "\",\"target\":\"" + target + "\",\"agentid\":" + agentid + "}";
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setUri(BASE_URI + "/cgi-bin/service/get_login_url")
                .addParameter("suite_access_token", provider_access_token)
                .setEntity(new StringEntity(json, Charset.forName("utf-8")))
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest, LoginUrlResult.class);
    }

}
