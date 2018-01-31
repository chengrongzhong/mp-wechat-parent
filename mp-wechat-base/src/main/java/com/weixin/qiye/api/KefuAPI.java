package com.weixin.qiye.api;

import com.weixin.common.bean.BaseResult;
import com.weixin.common.client.LocalHttpClient;
import com.weixin.mp.util.JsonUtil;
import com.weixin.qiye.bean.im.ChatMessage;
import com.weixin.qiye.bean.kefu.KefuResult;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;

import java.nio.charset.Charset;

/**
 * 企业客服服务
 * Created by fang on 2015/12/31.
 */
public class KefuAPI extends BaseAPI {
    /**
     发送客服消息

     接口说明

     支持文本、图片、文件消息。sender和receiver有且只有一个类型为kf。当sender为客服时，表示客服从其它IM工具回复客户，并同步消息到客服的微信上

     请求说明

     Https请求方式: POST

     https://qyapi.weixin.qq.com/cgi-bin/kf/send?access_token=ACCESS_TOKEN
     */
    public static  BaseResult sendMessage(String access_token,ChatMessage msg){
        String json = JsonUtil.toJSONString(msg);
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setUri(BASE_URI + "/cgi-bin/kf/send")
                .addParameter("access_token", access_token)
                .setEntity(new StringEntity(json, Charset.forName("utf-8")))
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest, BaseResult.class);
    }

    /**
     获取客服列表

     请求说明

     Https请求方式: GET

     https://qyapi.weixin.qq.com/cgi-bin/kf/list?access_token=ACCESS_TOKEN&type=TYPE
     */
    public static  KefuResult listKefu(String access_token,int type){
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setUri(BASE_URI + "/cgi-bin/kf/list")
                .addParameter("access_token", access_token)
                .addParameter("type", String.valueOf(type))
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest, KefuResult.class);
    }
}
