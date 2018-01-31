package com.weixin.qiye.bean.im.receive;

import com.weixin.mp.bean.AdaptorCDATA;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Created by fang on 2016/1/11.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class Message {
    @XmlElement(name="FromUserName")
    @XmlJavaTypeAdapter(value = AdaptorCDATA.class)
    private String FromUserName;	//发送方帐号（一个OpenID）

    @XmlElement(name="CreateTime")
    private Integer CreateTime;		//消息创建时间 （整型）

    @XmlElement(name="MsgType")
    @XmlJavaTypeAdapter(value = AdaptorCDATA.class)
    private String MsgType;

    @XmlElement(name="Event")
    @XmlJavaTypeAdapter(value = AdaptorCDATA.class)
    private String Event;

    public String getFromUserName() {
        return FromUserName;
    }

    public void setFromUserName(String fromUserName) {
        FromUserName = fromUserName;
    }

    public Integer getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(Integer createTime) {
        CreateTime = createTime;
    }

    public String getMsgType() {
        return MsgType;
    }

    public void setMsgType(String msgType) {
        MsgType = msgType;
    }

    public String getEvent() {
        return Event;
    }

    public void setEvent(String event) {
        Event = event;
    }
}
