package com.weixin.mp.util;

import com.weixin.mp.Constants;
import com.weixin.mp.bean.EventMessage;

/**
 * Created by fang on 2016/1/15.
 */
public class EventUtils {
    public static boolean isEvent(EventMessage msg){
        String type = msg.getMsgType();
        return Constants.EVENT_MESSAGE_TYPE_EVENT.equals(type);
    }
}
