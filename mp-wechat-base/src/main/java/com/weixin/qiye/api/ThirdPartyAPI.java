package com.weixin.qiye.api;

import com.weixin.common.bean.BaseResult;
import com.weixin.common.bean.Token;
import com.weixin.common.client.LocalHttpClient;
import com.weixin.mp.util.JsonUtil;
import com.weixin.qiye.bean.third.AuthResult;
import com.weixin.qiye.bean.third.PreSession;
import com.weixin.qiye.bean.third.SuiteToken;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;

import java.nio.charset.Charset;

/**
 * 第三方应用授权
 * Created by fang on 2015/12/31.
 */
public class ThirdPartyAPI extends BaseAPI {

    /**
     获取应用套件令牌

     该API用于获取应用套件令牌（suite_access_token）。

     注1：由于应用提供商可能托管了大量的企业号，其安全问题造成的影响会更加严重，故API中除了合法来源IP校验之外，还额外增加了1项安全策略：

     获取suite_access_token时，还额外需要suite_ticket参数（请永远使用最新接收到的suite_ticket）。suite_ticket由企业号后台定时推送给应用套件，并每十分钟更新。

     注2：通过本接口获取的accesstoken不会自动续期，每次获取都会自动更新。


     接口调用请求说明

     https请求方式: POST

     https://qyapi.weixin.qq.com/cgi-bin/service/get_suite_token
     */
    public static  SuiteToken getToken(String suite_id, String suite_secret, String suite_ticket) {
        String json = "{\"suite_id\":\"" + suite_id + "\",\"suite_secret\":\"" + suite_secret + "\",\"suite_ticket\":\"" + suite_ticket + "\"}";
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setUri(BASE_URI + "/cgi-bin/service/get_suite_token")
                .setEntity(new StringEntity(json, Charset.forName("utf-8")))
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest, SuiteToken.class);
    }

    /**
     获取预授权码

     该API用于获取预授权码。预授权码用于企业号授权时的应用提供商安全验证。

     接口调用请求说明

     https请求方式: POST

     https://qyapi.weixin.qq.com/cgi-bin/service/get_pre_auth_code?suite_access_token=SUITE_ACCESS_TOKEN
     */
    public static  SuiteToken getPreCode(String suite_access_token, String suite_id) {
        String json = "{\"suite_id\":\"" + suite_id + "\"}";
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setUri(BASE_URI + "/cgi-bin/service/get_pre_auth_code")
                .setEntity(new StringEntity(json, Charset.forName("utf-8")))
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest, SuiteToken.class);
    }


    /**
     设置授权配置

     如果需要对某次授权进行配置，则调用本接口，目前仅可以设置哪些应用可以授权，不调用则默认允许所有应用进行授权。

     接口调用请求说明

     https请求方式: POST

     https://qyapi.weixin.qq.com/cgi-bin/service/set_session_info?suite_access_token=SUITE_ACCESS_TOKEN
     */
    public static  BaseResult getPreCode(String suite_access_token, PreSession info) {
        String json = JsonUtil.toJSONString(info);
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setUri(BASE_URI + "/cgi-bin/service/set_session_info")
                .addParameter("suite_access_token", suite_access_token)
                .setEntity(new StringEntity(json, Charset.forName("utf-8")))
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest, BaseResult.class);
    }

    /**
     获取企业号的永久授权码

     该API用于使用临时授权码换取授权方的永久授权码，并换取授权信息、企业access_token。

     注：临时授权码使用一次后即失效

     接口调用请求说明

     https请求方式: POST

     https://qyapi.weixin.qq.com/cgi-bin/service/get_permanent_code?suite_access_token=SUITE_ACCESS_TOKEN
     */
    public static  BaseResult getPermanentCode(String suite_access_token, String suite_id,String auth_code) {
        String json = "{\"suite_id\":\""+suite_id+"\",\"auth_code\":\""+auth_code+"\"}";
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setUri(BASE_URI + "/cgi-bin/service/set_session_info")
                .addParameter("suite_access_token",suite_access_token)
                .setEntity(new StringEntity(json, Charset.forName("utf-8")))
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest, BaseResult.class);
    }
    /**
     获取企业号的授权信息

     该API用于通过永久授权码换取企业号的授权信息。 永久code的获取，是通过临时授权码使用get_permanent_code 接口获取到的permanent_code。

     接口调用请求说明

     https请求方式: POST

     https://qyapi.weixin.qq.com/cgi-bin/service/get_auth_info?suite_access_token=SUITE_ACCESS_TOKEN
     */
    public static  AuthResult getAuthCode(String suite_id,String auth_corpid ,String permanent_code) {
        String json = "{\"suite_id\":\""+suite_id+"\",\"auth_corpid\":\""+auth_corpid+"\",\"permanent_code\":\""+permanent_code+"\"}";
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setUri(BASE_URI + "/cgi-bin/service/get_auth_info")
                .setEntity(new StringEntity(json, Charset.forName("utf-8")))
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest, AuthResult.class);
    }

    /**
     获取企业号access_token

     应用提供商在取得企业号的永久授权码并完成对企业号应用的设置之后，便可以开始通过调用企业接口（详见企业接口文档）来运营这些应用。其中，调用企业接口所需的access_token获取方法如下。

     接口调用请求说明

     https请求方式: POST

     https://qyapi.weixin.qq.com/cgi-bin/service/get_corp_token?suite_access_token=SUITE_ACCESS_TOKEN
     */
    public static  Token getAccessToken(String suite_id,String auth_corpid ,String permanent_code) {
        String json = "{\"suite_id\":\""+suite_id+"\",\"auth_corpid\":\""+auth_corpid+"\",\"permanent_code\":\""+permanent_code+"\"}";
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setUri(BASE_URI + "/cgi-bin/service/get_corp_token")
                .setEntity(new StringEntity(json, Charset.forName("utf-8")))
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest, Token.class);
    }
}
