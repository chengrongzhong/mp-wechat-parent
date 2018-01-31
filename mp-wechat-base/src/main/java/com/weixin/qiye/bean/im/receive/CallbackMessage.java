package com.weixin.qiye.bean.im.receive;

import com.weixin.mp.bean.AdapterArray;
import com.weixin.mp.bean.AdaptorCDATA;
import com.weixin.mp.util.XMLConverUtil;
import com.weixin.qiye.bean.im.ChatInfo;
import com.weixin.qiye.bean.im.Receiver;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by fang on 2016/1/11.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="Item")
public class CallbackMessage extends Message {
    @XmlElement(name="ChatInfo")
    ChatInfo chatInfo;

    @XmlElement(name="ChatId")
    private String chatid;
    @XmlElement(name="AddUserList")
    @XmlJavaTypeAdapter(value=AdapterArray.class)
    private List<String> add_user_list;
    @XmlElement(name="DelUserList")
    @XmlJavaTypeAdapter(value=AdapterArray.class)
    private List<String> del_user_list;

    @XmlElement(name="MsgId")
    private String MsgId;
    @XmlElement(name="MediaId")
    private String MediaId;
    @XmlElement(name="PicUrl")
    private String PicUrl;

    @XmlElement(name="Content")
    private String Content;

    @XmlElement(name="Receiver")
    private Receiver receiver;

    public String getChatid() {
        return chatid;
    }

    public void setChatid(String chatid) {
        this.chatid = chatid;
    }

    public List<String> getAdd_user_list() {
        return add_user_list;
    }

    public void setAdd_user_list(List<String> add_user_list) {
        this.add_user_list = add_user_list;
    }

    public List<String> getDel_user_list() {
        return del_user_list;
    }

    public void setDel_user_list(List<String> del_user_list) {
        this.del_user_list = del_user_list;
    }

    public String getMsgId() {
        return MsgId;
    }

    public void setMsgId(String msgId) {
        MsgId = msgId;
    }

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

    public String getPicUrl() {
        return PicUrl;
    }

    public void setPicUrl(String picUrl) {
        PicUrl = picUrl;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public Receiver getReceiver() {
        return receiver;
    }

    public void setReceiver(Receiver receiver) {
        this.receiver = receiver;
    }

    public ChatInfo getChatInfo() {
        return chatInfo;
    }

    public void setChatInfo(ChatInfo chatInfo) {
        this.chatInfo = chatInfo;
    }
}
