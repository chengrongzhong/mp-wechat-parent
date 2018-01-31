package com.weixin.mp;

import com.weixin.mp.bean.EventMessage;
import org.springframework.stereotype.Component;
import com.weixin.mp.bean.xmlmessage.*;

import java.util.List;

/**
 * Builder 用于构建复杂对象的一个工具类,便于灵活构建对象
 * Created by fang on 2014/11/16.
 */
@Component
public class ReplyBuilder {
    private void setReply(XMLMessage reply,String toUserName, String fromUserName){
        reply.setToUserName(toUserName);
        reply.setFromUserName(fromUserName);
        reply.setCreateTime(System.currentTimeMillis());
    }
    public XMLImageMessage builderImageReply(String toUserName, String fromUserName, String mediaId){
        XMLImageMessage reply = new XMLImageMessage();
        setReply(reply, toUserName, fromUserName);
        reply.setMsgType(Constants.REPLY_TYPE_IMAGE);
        reply.setMediaId(mediaId);
        return reply;
    }

    public XMLMusicMessage builderMusicReply(
            String toUserName, String fromUserName,String title,
            String description,String musicUrl,String hQMusicUrl,String thumbMediaId){
        XMLMusicMessage reply = new XMLMusicMessage();
        setReply(reply, toUserName, fromUserName);
        reply.setMsgType(Constants.REPLY_TYPE_MUSIC);
        reply.setTitle(title);
        reply.setDescription(description);
        reply.setMusicUrl(musicUrl);
        reply.sethQMusicUrl(hQMusicUrl);
        reply.setThumbMediaId(thumbMediaId);
        return reply;
    }

    public XMLNewsMessage builderNewsReply(String toUserName, String fromUserName, List<XMLNewsMessage.Article> list){
        XMLNewsMessage reply = new XMLNewsMessage();
        setReply(reply, toUserName, fromUserName);
        reply.setMsgType(Constants.REPLY_TYPE_NEWS);
        reply.setArticles(list);
        return reply;
    }

    public XMLTextMessage builderTextReply(String toUserName, String fromUserName, String content){
        XMLTextMessage reply = new XMLTextMessage();
        setReply(reply, toUserName, fromUserName);
        reply.setMsgType(Constants.REPLY_TYPE_TEXT);
        reply.setContent(content);
        return reply;
    }

    public XMLVideoMessage builderVideoReply(String toUserName, String fromUserName,String mediaId,String title,String description){
        XMLVideoMessage reply = new XMLVideoMessage();
        setReply(reply,toUserName,fromUserName);
        reply.setMsgType(Constants.REPLY_TYPE_VIDEO);
        reply.setMediaId(mediaId);
        reply.setTitle(title);
        reply.setDescription(description);
        return reply;
    }

    public XMLVoiceMessage builderVoiceReply(String toUserName, String fromUserName,String mediaId){
        XMLVoiceMessage reply = new XMLVoiceMessage();
        setReply(reply, toUserName, fromUserName);
        reply.setMsgType(Constants.REPLY_TYPE_VOICE);
        reply.setMediaId(mediaId);
        return reply;
    }

    public XMLEmptyMessage newEmptyReply() {
        return new XMLEmptyMessage();
    }
    public XMLEmptyMessage builderEmptyReply(String toUserName, String fromUserName) {
        XMLEmptyMessage reply = new XMLEmptyMessage();
        setReply(reply, toUserName, fromUserName);
        return reply;
    }


    public XMLMessage newEmptyReply(EventMessage event){
        XMLEmptyMessage reply = new XMLEmptyMessage();
        setReply(reply, event.getFromUserName(), event.getToUserName());
        return reply;
    }

}
