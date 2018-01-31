package com.weixin.mp;

import com.weixin.mp.bean.EventMessage;

import java.util.Map;

/**
 * Created by fang on 2014/10/26.
 */
//@Component
public class WeixinEventFactory {
    private void setBaseValue(EventMessage msg,Map<String,String> map){
        msg.setCreateTime(Integer.parseInt(map.get("CreateTime")));
        msg.setFromUserName(map.get("FromUserName"));
        msg.setMsgType(map.get("MsgType"));
        msg.setToUserName(map.get("ToUserName"));
        msg.setEvent(map.get("Event"));
    }

    private EventMessage setValue(EventMessage msg,Map<String,String> map){
        setBaseValue(msg, map);
        msg.setEventKey(map.get("EventKey"));
        msg.setLatitude(map.get("Latitude"));
        msg.setLongitude(map.get("Longitude"));
        msg.setPrecision(map.get("Precision"));

        msg.setEventKey(map.get("EventKey"));
        msg.setTicket(map.get("Ticket"));

        msg.setEventKey(map.get("EventKey"));

        msg.setEventKey(map.get("EventKey"));
        msg.setLatitude(map.get("Latitude"));
        msg.setLongitude(map.get("Longitude"));
        msg.setPrecision(map.get("Precision"));
        msg.setTicket(map.get("Ticket"));
        return msg;
    }

    public EventMessage newEvent(Map<String,String> map){
        return setValue(new EventMessage(),map);
    }

    public boolean isEvent(EventMessage msg){
        String type = msg.getMsgType();
        return Constants.EVENT_MESSAGE_TYPE_EVENT.equals(type);
    }

    public boolean isMessage(EventMessage msg){
        String type = msg.getMsgType();
        return !Constants.EVENT_MESSAGE_TYPE_EVENT.equals(type);
    }

//    public boolean isEvent(Map<String,String> map){
//        String type = map.get("MsgType");
//        return Constants.EVENT_MESSAGE_TYPE_EVENT.equals(type);
//    }
//
//    public boolean isMessage(Map<String,String> map){
//        String type = map.get("MsgType");
//        return !Constants.EVENT_MESSAGE_TYPE_EVENT.equals(type);
//    }
}
