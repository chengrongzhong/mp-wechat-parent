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
public class VoiceMessage extends Message {
    @XmlElement(name="Format")
    @XmlJavaTypeAdapter(value = AdaptorCDATA.class)
    private String Format;

    @XmlElement(name="MediaId")
    @XmlJavaTypeAdapter(value = AdaptorCDATA.class)
    private String MediaId;
    public VoiceMessage() {
        super("voice");
    }

    public String getFormat() {
        return Format;
    }

    public void setFormat(String format) {
        Format = format;
    }

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }
}
