package com.weixin.mp.bean.xmlmessage;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created by fang on 2014/10/26.
 */
@Component
public class WeixinReplyFactory {
//    private XMLTextMessage setValue(XMLTextMessage msg,Map<String,String> map){
//        msg.setCreateTime(Integer.parseInt(map.get("CreateTime")));
//        msg.setFromUserName(map.get("FromUserName"));
//        msg.setMsgId(Integer.parseInt(map.get("MsgId")));
//        msg.setMsgType(map.get("MsgType"));
//        msg.setToUserName(map.get("ToUserName"));
//
//        msg.setContent(map.get("Content"));
//        return msg;
//    }
//
//    private XMLVoiceMessage setValue(XMLVoiceMessage msg,Map<String,String> map){
//        msg.setCreateTime(Integer.parseInt(map.get("CreateTime")));
//        msg.setFromUserName(map.get("FromUserName"));
//        msg.setMsgId(Integer.parseInt(map.get("MsgId")));
//        msg.setMsgType(map.get("MsgType"));
//        msg.setToUserName(map.get("ToUserName"));
//
//        msg.setMediaId(map.get("MediaId"));
//
//        return msg;
//    }
//    private XMLVideoMessage setValue(XMLVideoMessage msg,Map<String,String> map){
//        msg.setCreateTime(Integer.parseInt(map.get("CreateTime")));
//        msg.setFromUserName(map.get("FromUserName"));
//        msg.setMsgId(Integer.parseInt(map.get("MsgId")));
//        msg.setMsgType(map.get("MsgType"));
//        msg.setToUserName(map.get("ToUserName"));
//
//        msg.setMediaId(map.get("MediaId"));
//        msg.setTitle(map.get("Title"));
//        msg.setDescription(map.get("Description"));
//        return msg;
//    }
//    private XMLImageMessage setValue(XMLImageMessage msg,Map<String,String> map){
//        msg.setCreateTime(Integer.parseInt(map.get("CreateTime")));
//        msg.setFromUserName(map.get("FromUserName"));
//        msg.setMsgId(Integer.parseInt(map.get("MsgId")));
//        msg.setMsgType(map.get("MsgType"));
//        msg.setToUserName(map.get("ToUserName"));
//
//        msg.setMediaId(map.get("MediaId"));
//        return msg;
//    }
//    private XMLLinkMessage setValue(XMLLinkMessage msg,Map<String,String> map){
//        msg.setCreateTime(Integer.parseInt(map.get("CreateTime")));
//        msg.setFromUserName(map.get("FromUserName"));
//        msg.setMsgId(Integer.parseInt(map.get("MsgId")));
//        msg.setMsgType(map.get("MsgType"));
//        msg.setToUserName(map.get("ToUserName"));
//
//        msg.setTitle(map.get("Title"));
//        msg.setDescription(map.get("Description"));
//        msg.setUrl(map.get("Url"));
//        return msg;
//    }
//    private XMLLocationMessage setValue(XMLLocationMessage msg,Map<String,String> map){
//        msg.setCreateTime(Integer.parseInt(map.get("CreateTime")));
//        msg.setFromUserName(map.get("FromUserName"));
//        msg.setMsgId(Integer.parseInt(map.get("MsgId")));
//        msg.setMsgType(map.get("MsgType"));
//        msg.setToUserName(map.get("ToUserName"));
//
//        msg.setLocation_X(map.get("Location_X"));
//        msg.setLocation_Y(map.get("Location_Y"));
//        msg.setScale(map.get("Scale"));
//        msg.setLabel(map.get("Label"));
//        return msg;
//    }
//    private EventMessage setValue(EventMessage msg,Map<String,String> map){
//        msg.setCreateTime(Long.parseLong(map.get("CreateTime")));
//        msg.setFromUserName(map.get("FromUserName"));
//        msg.setMsgType(map.get("MsgType"));
//        msg.setToUserName(map.get("ToUserName"));
//
//        msg.setEvent(map.get("Event"));
//        msg.setEventKey(map.get("EventKey"));
//        return msg;
//    }
//    public WeixinMessage newMessage(Map<String,String> map){
//        WeixinMessage msg = new WeixinMessage();
//        msg.setCreateTime(Long.parseLong(map.get("CreateTime")));
//        msg.setFromUserName(map.get("FromUserName"));
//        msg.setMsgId(Long.parseLong(map.get("MsgId")));
//        msg.setMsgType(map.get("MsgType"));
//        msg.setToUserName(map.get("ToUserName"));
//
//        msg.setEvent(map.get("Event"));
//        msg.setEventKey(map.get("EventKey"));
//        msg.setContent(map.get("Content"));
//        msg.setPicUrl(map.get("PicUrl"));
//        msg.setMediaId(map.get("MediaId"));
//        msg.setTitle(map.get("Title"));
//        msg.setDescription(map.get("Description"));
//        msg.setUrl(map.get("Url"));
//        msg.setLocation_X(map.get("Location_X"));
//        msg.setLocation_Y(map.get("Location_Y"));
//        msg.setScale(map.get("Scale"));
//        msg.setLabel(map.get("Label"));
//        msg.setThumbMediaId(map.get("ThumbMediaId"));
//        msg.setFormat(map.get("Format"));
//        msg.setRecognition(map.get("Recognition"));
//        return msg;
//    }

//    public BaseMessage newTextMessage(Map<String,String> map){
//        BaseMessage msg = null;
//        String type = map.get("MsgType");
//        if (Constants.RECEIVE_TYPE_IMAGE.equals(type)){
//            msg = setValue(new XMLImageMessage(),map);
//        }else if (Constants.RECEIVE_TYPE_LINK.equals(type)){
//            msg = setValue(new XMLLinkMessage(),map);
//        }else if (Constants.RECEIVE_TYPE_LOCATION.equals(type)){
//            msg = setValue(new XMLLocationMessage(),map);
//        }else if (Constants.RECEIVE_TYPE_TEXT.equals(type)){
//            msg = setValue(new XMLTextMessage(),map);
//        }else if (Constants.RECEIVE_TYPE_VIDEO.equals(type)){
//            msg = setValue(new XMLVideoMessage(),map);
//        }else if (Constants.RECEIVE_TYPE_VOICE.equals(type)){
//            msg = setValue(new XMLVoiceMessage(),map);
//        }
//        return msg;
//    }

    public XMLTextMessage newTextMessage(String toUserName, String fromUserName,String content){
        return new XMLTextMessage(toUserName,fromUserName,content);
    }

    public XMLImageMessage newImageMessage(String toUserName, String fromUserName,String mediaId){
        return new XMLImageMessage(toUserName,fromUserName,mediaId);
    }
    public XMLMusicMessage newMusicMessage(String toUserName, String fromUserName,
                                           String title,String description,String musicUrl,String hQMusicUrl,String thumbMediaId){
        return new XMLMusicMessage(toUserName,fromUserName,title,description,musicUrl,hQMusicUrl,thumbMediaId);
    }
    public XMLNewsMessage newNewsMessage(String toUserName, String fromUserName,
                                         List<XMLNewsMessage.Article> articles){
        return new XMLNewsMessage(toUserName,fromUserName,articles);
    }
    public XMLVideoMessage newVideoMessage(String toUserName, String fromUserName,String mediaId,String title,String description){
        return new XMLVideoMessage(toUserName,fromUserName,mediaId,title,description);
    }
    public XMLVoiceMessage newVoiceMessage(String toUserName, String fromUserName,String mediaId){
        return new XMLVoiceMessage(toUserName,fromUserName,mediaId);
    }
}
