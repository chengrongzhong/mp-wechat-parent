package com.weixin.qiye.bean.address;

import java.util.List;

/**
 * Created by fang on 2015/12/31.
 */
public class TagUserReq {

    private String tagid;//标签ID

    private String[] userlist;//企业成员ID列表，注意：userlist、partylist不能同时为空，单次请求长度不超过1000

    private String[] partylist;//企业部门ID列表，注意：userlist、partylist不能同时为空，单次请求长度不超过100

    public String getTagid() {
        return tagid;
    }

    public void setTagid(String tagid) {
        this.tagid = tagid;
    }

    public String[] getUserlist() {
        return userlist;
    }

    public void setUserlist(String[] userlist) {
        this.userlist = userlist;
    }

    public String[] getPartylist() {
        return partylist;
    }

    public void setPartylist(String[] partylist) {
        this.partylist = partylist;
    }
}
