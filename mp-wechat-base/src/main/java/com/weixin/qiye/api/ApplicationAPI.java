package com.weixin.qiye.api;

import com.weixin.common.bean.BaseResult;
import com.weixin.common.client.LocalHttpClient;
import com.weixin.mp.util.JsonUtil;
import com.weixin.qiye.bean.address.JobResult;
import com.weixin.qiye.bean.app.AppReq;
import com.weixin.qiye.bean.app.AppResult;
import com.weixin.qiye.bean.app.AppsResult;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;

import java.nio.charset.Charset;

/**
 * 企业号应用管理
 * Created by fang on 2015/12/31.
 */
public class ApplicationAPI extends BaseAPI {

    /**
     获取企业号应用

     接口说明

     该API用于获取企业号某个应用的基本信息，包括头像、昵称、帐号类型、认证类型、可见范围等信息

     请求说明

     Https请求方式: GET

     https://qyapi.weixin.qq.com/cgi-bin/agent/get?access_token=ACCESS_TOKEN&agentid=AGENTID
     */
    public static AppResult getAgent(String access_token, String agentid) {
       HttpUriRequest httpUriRequest = RequestBuilder.get()
             .setUri(BASE_URI + "/cgi-bin/agent/get")
             .addParameter("access_token", access_token)
             .addParameter("agentid", agentid)
             .build();
       return LocalHttpClient.executeJsonResult(httpUriRequest, AppResult.class);
    }


    /**
     设置企业号应用

     接口说明

     该API用于设置企业应用的选项设置信息，如：地理位置上报等。第三方服务商不能调用该接口设置授权的主页型应用。

     请求说明

     Https请求方式: POST

     https://qyapi.weixin.qq.com/cgi-bin/agent/set?access_token=ACCESS_TOKEN
     */
    public static BaseResult setAgent(String access_token, AppReq app) {
        String json = JsonUtil.toJSONString(app);
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setUri(BASE_URI + "/cgi-bin/agent/set")
                .addParameter("access_token", access_token)
                .setEntity(new StringEntity(json, Charset.forName("utf-8")))
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest, BaseResult.class);
    }


    /**

     获取应用概况列表

     接口说明

     该API 用于获取secret所在管理组内的应用概况，会返回管理组内应用的id及名称、头像等信息

     请求说明

     Https请求方式: GET

     https://qyapi.weixin.qq.com/cgi-bin/agent/list?access_token=ACCESS_TOKEN
     */
    public static AppsResult listAgent(String access_token) {
        HttpUriRequest httpUriRequest = RequestBuilder.get()
                .setUri(BASE_URI + "/cgi-bin/agent/list")
                .addParameter("access_token", access_token)
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest, AppsResult.class);
    }


}
