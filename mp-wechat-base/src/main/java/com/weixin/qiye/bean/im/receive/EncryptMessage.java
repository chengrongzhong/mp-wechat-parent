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
@XmlRootElement(name="xml")
public class EncryptMessage {
    @XmlElement(name="Encrypt")
    @XmlJavaTypeAdapter(value = AdaptorCDATA.class)
    private String Encrypt;
    @XmlElement(name="ToUserName")
    @XmlJavaTypeAdapter(value = AdaptorCDATA.class)
    private String ToUserName;
    @XmlElement(name="AgentType")
    @XmlJavaTypeAdapter(value = AdaptorCDATA.class)
    private String AgentType;

    public String getEncrypt() {
        return Encrypt;
    }

    public void setEncrypt(String encrypt) {
        Encrypt = encrypt;
    }

    public String getToUserName() {
        return ToUserName;
    }

    public void setToUserName(String toUserName) {
        ToUserName = toUserName;
    }

    public String getAgentType() {
        return AgentType;
    }

    public void setAgentType(String agentType) {
        AgentType = agentType;
    }
}
