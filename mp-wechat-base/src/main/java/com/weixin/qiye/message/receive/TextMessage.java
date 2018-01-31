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
@XmlRootElement(name="xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class TextMessage extends Message {
    @XmlElement(name="Content")
    @XmlJavaTypeAdapter(value = AdaptorCDATA.class)
    private String Content;
    public TextMessage() {
        super("text");
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
