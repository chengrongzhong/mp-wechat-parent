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
public class LocationMessage extends Message {
    @XmlElement(name="Location_X")
    private Double Location_X;

    @XmlElement(name="Location_Y")
    private Double Location_Y;

    @XmlElement(name="Scale")
    private Integer Scale;

    @XmlElement(name="Label")
    @XmlJavaTypeAdapter(value = AdaptorCDATA.class)
    private String Label;

    @XmlElement(name="MediaId")
    @XmlJavaTypeAdapter(value = AdaptorCDATA.class)
    private String MediaId;
    public LocationMessage() {
        super("location");
    }

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

    public Double getLocation_X() {
        return Location_X;
    }

    public void setLocation_X(Double location_X) {
        Location_X = location_X;
    }

    public Double getLocation_Y() {
        return Location_Y;
    }

    public void setLocation_Y(Double location_Y) {
        Location_Y = location_Y;
    }

    public Integer getScale() {
        return Scale;
    }

    public void setScale(Integer scale) {
        Scale = scale;
    }

    public String getLabel() {
        return Label;
    }

    public void setLabel(String label) {
        Label = label;
    }
}
