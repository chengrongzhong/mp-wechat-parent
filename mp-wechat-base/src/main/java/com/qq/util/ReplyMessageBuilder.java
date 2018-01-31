package com.qq.util;

import com.qq.bean.xmlmessage.XMLNewsMessage;
import com.qq.bean.xmlmessage.XMLTextMessage;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 回复QQ公众号消息
 * Created by sdyang on 2016/3/28.
 */
public class ReplyMessageBuilder {

    /**
     * 回复文本信息
     * @param toUserName
     * @param fromUserName
     * @param content
     * @return
     */
    public static XMLTextMessage buildTextMessage(String toUserName, String fromUserName,String content){
        XMLTextMessage message = new XMLTextMessage(toUserName,fromUserName,content);
        return message;
    }

    /**
     * 回复图文消息
     * @param toUserName
     * @param fromUserName
     * @param articles
     * @return
     */
    public static XMLNewsMessage buildNewsMessage(String toUserName, String fromUserName,
                                                  List<XMLNewsMessage.Article> articles){
        XMLNewsMessage message = new XMLNewsMessage(toUserName,fromUserName,articles);
        return message;
    }


}
