package com.weixin.mp;

/**
 * Created by fang on 2014/10/26.
 */
public class Constants {

///////////////////////////接收消息/////////////////////////////////
    //返回消息类型：文本
    public static final String RECEIVE_TYPE_TEXT="text";

    //返回消息类型：图片消息
    public static final String RECEIVE_TYPE_IMAGE="image";

    //返回消息类型：语音消息
    public static final String RECEIVE_TYPE_VOICE="voice";

    //返回消息类型：视频消息
    public static final String RECEIVE_TYPE_VIDEO="video";
    public static final String RECEIVE_TYPE_SHORT_VIDEO="shortvideo";

    //返回消息类型：地理位置消息
    public static final String RECEIVE_TYPE_LOCATION="location";

    //返回消息类型：连接消息
    public static final String RECEIVE_TYPE_LINK="link";

////////////////////////////接收事件推送////////////////////////////////
    /**
     * 请求消息类型：推送
     */
    public static final String EVENT_MESSAGE_TYPE_EVENT = "event";
    /**
     * 事件类型：subscribe(订阅)
     */
    public static final String EVENT_TYPE_SUBSCRIBE = "subscribe";

    /**
     * 事件类型：unsubscribe(取消订阅)
     */
    public static final String EVENT_TYPE_UNSUBSCRIBE = "unsubscribe";

    /**
     * 事件类型：用户已关注时的事件推送
     */
    public static final String EVENT_TYPE_SCAN = "SCAN";

    /**
     * 事件类型：点击菜单拉取消息时的事件推送
     */
    public static final String EVENT_TYPE_CLICK = "CLICK";

    /**
     * 事件类型：点击菜单跳转链接时的事件推送
     */
    public static final String EVENT_TYPE_VIEW = "VIEW";

    public static final String EVENT_TYPE_LOCATION="LOCATION";
    /**
     * 模版推送完成的事件
     */
    public static final String EVENT_TYPE_TEMPLATESENDJOBFINISH = "TEMPLATESENDJOBFINISH";

    ///////////////////////////发送被动响应消息/////////////////////////////////

    //请求消息类型：文本
    public static final String REPLY_TYPE_TEXT ="text";

    /**
     * 请求消息类型：图片
     */
    public static final String REPLY_TYPE_IMAGE = "image";

    /**
     * 请求消息类型：语音
     */
    public static final String REPLY_TYPE_VOICE = "voice";

    /**
     * 请求消息类型：视频
     */
    public static final String REPLY_TYPE_VIDEO = "video";

    /**
     * 请求消息类型：音乐
     */
    public static final String REPLY_TYPE_MUSIC = "music";

    /**
     * 请求消息类型：图文
     */
    public static final String REPLY_TYPE_NEWS = "news";

}
