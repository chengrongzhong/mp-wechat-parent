package com.weixin.qiye.bean.im.receive;

import com.weixin.mp.bean.AdaptorCDATA;
import com.weixin.mp.util.XMLConverUtil;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.List;

/**
 * http://qydev.weixin.qq.com/wiki/index.php?title=%E4%BC%81%E4%B8%9A%E4%BC%9A%E8%AF%9D%E5%9B%9E%E8%B0%83
 * Created by fang on 2016/1/11.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="xml")
public class DecryptMessage {
    @XmlElement(name="AgentType")
    @XmlJavaTypeAdapter(value = AdaptorCDATA.class)
    private String AgentType;
    @XmlElement(name="ToUserName")
    private String ToUserName;
    @XmlElement(name="ItemCount")
    private int ItemCount;
    @XmlElement(name="PackageId")
    private long PackageId;
    //@XmlAnyElement(lax=true)
    //@XmlElement(name="Item")
    @XmlElements(value={ @XmlElement(name = "Item", type = CallbackMessage.class)})
    private List<Message> Item;

    public String getAgentType() {
        return AgentType;
    }

    public void setAgentType(String agentType) {
        AgentType = agentType;
    }

    public String getToUserName() {
        return ToUserName;
    }

    public void setToUserName(String toUserName) {
        ToUserName = toUserName;
    }

    public int getItemCount() {
        return ItemCount;
    }

    public void setItemCount(int itemCount) {
        ItemCount = itemCount;
    }

    public long getPackageId() {
        return PackageId;
    }

    public void setPackageId(long packageId) {
        PackageId = packageId;
    }
}
