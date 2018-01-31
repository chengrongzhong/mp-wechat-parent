package com.weixin.qiye.message.receive;

import com.weixin.mp.bean.AdaptorCDATA;
import com.weixin.mp.util.XMLConverUtil;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Created by fang on 2016/1/7.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="xml")
public class Message {
    @XmlElement(name="ToUserName")
    @XmlJavaTypeAdapter(value = AdaptorCDATA.class)
    private String ToUserName; 		//开发者微信号
    @XmlElement(name="FromUserName")
    @XmlJavaTypeAdapter(value = AdaptorCDATA.class)
    private String FromUserName;	//发送方帐号（一个OpenID）
    @XmlElement(name="CreateTime")
    private Integer CreateTime;		//消息创建时间 （整型）
    @XmlElement(name="MsgType")
    @XmlJavaTypeAdapter(value = AdaptorCDATA.class)
    private String MsgType;			//消息类型，event
    @XmlElement(name="MsgId")
    private Long MsgId;
    @XmlElement(name="AgentID")
    private Integer AgentID;

    public Message(String msgType) {
        MsgType = msgType;
    }

    public String getToUserName() {
        return ToUserName;
    }

    public void setToUserName(String toUserName) {
        ToUserName = toUserName;
    }

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

    public Long getMsgId() {
        return MsgId;
    }

    public void setMsgId(Long msgId) {
        MsgId = msgId;
    }

    public Integer getAgentID() {
        return AgentID;
    }

    public void setAgentID(Integer agentID) {
        AgentID = agentID;
    }
}
