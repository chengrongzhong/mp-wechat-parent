package com.weixin.qiye.bean.im;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * Created by fang on 2016/1/11.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Receiver {
    @XmlElement(name="Type")
    private String type;
    @XmlElement(name="Id")
    private String id;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
