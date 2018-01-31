package com.weixin.qiye.message.receive;

import com.weixin.mp.bean.AdaptorCDATA;

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
public class ShortVideoMessage extends Message {
    @XmlElement(name="ThumbMediaId")
    @XmlJavaTypeAdapter(value = AdaptorCDATA.class)
    private String ThumbMediaId;

    @XmlElement(name="MediaId")
    @XmlJavaTypeAdapter(value = AdaptorCDATA.class)
    private String MediaId;

    public ShortVideoMessage() {
        super("shortvideo");
    }

    public String getThumbMediaId() {
        return ThumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        ThumbMediaId = thumbMediaId;
    }

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }
}
