package com.weixin.qiye.bean.im;

import com.weixin.mp.bean.AdapterArray;
import com.weixin.mp.bean.AdaptorCDATA;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.List;

/**
 * Created by fang on 2016/1/11.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class ChatInfo {
    @XmlElement(name="ChatId")
    private String chatid;
    @XmlElement(name="Name")
    private String name;
    @XmlElement(name="Owner")
    private String owner;
    @XmlElement(name="UserList")
    @XmlJavaTypeAdapter(value=AdapterArray.class)
    private List<String> userlist;
    @XmlElement(name="AddUserList")
    @XmlJavaTypeAdapter(value=AdapterArray.class)
    private List<String> add_user_list;
    @XmlElement(name="DelUserList")
    @XmlJavaTypeAdapter(value=AdapterArray.class)
    private List<String> del_user_list;

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

    public String getChatid() {
        return chatid;
    }

    public void setChatid(String chatid) {
        this.chatid = chatid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public List<String> getUserlist() {
        return userlist;
    }

    public void setUserlist(List<String> userlist) {
        this.userlist = userlist;
    }
}
