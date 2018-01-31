package com.weixin.qiye.api;

import com.weixin.common.bean.BaseResult;
import com.weixin.common.client.LocalHttpClient;
import com.weixin.mp.util.JsonUtil;
import com.weixin.qiye.bean.im.*;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;

import java.nio.charset.Charset;

/**
 * 企业IM通讯的对接接口
 * 企业会话服务
 * Created by fang on 2015/12/31.
 */
public class ImAPI extends BaseAPI {
    /**
     创建会话

     请求说明

     Https请求方式: POST

     https://qyapi.weixin.qq.com/cgi-bin/chat/create?access_token=ACCESS_TOKEN
     */
    public static  BaseResult createChat(String access_token,ChatInfo req){
        String json = JsonUtil.toJSONString(req);
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setUri(BASE_URI + "/cgi-bin/chat/create")
                .addParameter("access_token", access_token)
                .setEntity(new StringEntity(json, Charset.forName("utf-8")))
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest, BaseResult.class);
    }

    /**
     获取会话

     请求说明

     Https请求方式: GET

     https://qyapi.weixin.qq.com/cgi-bin/chat/get?access_token=ACCESS_TOKEN&chatid=CHATID
      */
    public static  ChatInfoResult getChat(String access_token,String chatid){
        HttpUriRequest httpUriRequest = RequestBuilder.get()
                .setUri(BASE_URI + "/cgi-bin/chat/get")
                .addParameter("access_token", access_token)
                .addParameter("chatid", chatid)
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest, ChatInfoResult.class);
    }
    /**
     修改会话信息

     请求说明

     Https请求方式: POST

     https://qyapi.weixin.qq.com/cgi-bin/chat/update?access_token=ACCESS_TOKEN
      */
    public static  BaseResult updateChat(String access_token,ChatInfo info){
        String json = JsonUtil.toJSONString(info);
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setUri(BASE_URI + "/cgi-bin/chat/get")
                .addParameter("access_token", access_token)
                .setEntity(new StringEntity(json, Charset.forName("utf-8")))
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest, BaseResult.class);
    }
    /**
     退出会话

     请求说明

     Https请求方式: POST

     https://qyapi.weixin.qq.com/cgi-bin/chat/quit?access_token=ACCESS_TOKEN
     */
    public static  BaseResult quitChat(String access_token,String chatid,String userid){
        String json = "{\"chatid\":\""+chatid+"\",\"op_user\":\""+userid+"\"}";;
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setUri(BASE_URI + "/cgi-bin/chat/quit")
                .addParameter("access_token", access_token)
                .setEntity(new StringEntity(json, Charset.forName("utf-8")))
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest, BaseResult.class);
    }

    /**
     清除会话未读状态

     请求说明

     Https请求方式: POST

     https://qyapi.weixin.qq.com/cgi-bin/chat/clearnotify?access_token=ACCESS_TOKEN
     */
    public static  BaseResult clearNotify(String access_token,String userid,String type,String id){
        String json = "{\"op_user\":\""+userid+"\",\"chat\":{\"type\":\""+type+"\",\"id\": \""+id+"\"}}";
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setUri(BASE_URI + "/cgi-bin/chat/clearnotify")
                .addParameter("access_token", access_token)
                .setEntity(new StringEntity(json, Charset.forName("utf-8")))
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest, BaseResult.class);
    }

    /**
     发消息

     接口说明

     消息支持文本、图片、文件，在发送时需要区分群聊和单聊。如果接收人不存在，则发送失败。在企业IM端发送的消息，在同步到发送者的微信上时，不会有提醒。
     可以通过文本消息下发表情（下载微信表情转换表）

     请求说明

     Https请求方式: POST

     https://qyapi.weixin.qq.com/cgi-bin/chat/send?access_token=ACCESS_TOKEN
     */
    public static  BaseResult sendMessage(String access_token,ChatMessage msg){
        String json = JsonUtil.toJSONString(msg);
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setUri(BASE_URI + "/cgi-bin/chat/send")
                .addParameter("access_token", access_token)
                .setEntity(new StringEntity(json, Charset.forName("utf-8")))
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest, BaseResult.class);
    }

    /**
     设置成员新消息免打扰

     接口说明

     该接口可设置成员接收到的消息是否提醒。主要场景是用于对接企业im的在线状态，如成员处于在线状态时，可以设置该成员的消息免打扰。当成员离线时，关闭免打扰状态，对微信端进行提醒。

     请求说明

     Https请求方式: POST

     https://qyapi.weixin.qq.com/cgi-bin/chat/setmute?access_token=ACCESS_TOKEN
     */
    public static  MuteResult setMute(String access_token,MuteReq req){
        String json = JsonUtil.toJSONString(req);
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setUri(BASE_URI + "/cgi-bin/chat/setmute")
                .addParameter("access_token", access_token)
                .setEntity(new StringEntity(json, Charset.forName("utf-8")))
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest, MuteResult.class);
    }

}