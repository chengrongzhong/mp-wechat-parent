package com.weixin.qiye.bean.address;

import com.weixin.common.bean.BaseResult;
import com.weixin.qiye.bean.address.MemberUser;

import java.util.List;

/**
 * Created by fang on 2015/12/31.
 */
public class MemberUsers extends BaseResult{
    private List<MemberUser> userlist;
    private String[] partylist;

    public String[] getPartylist() {
        return partylist;
    }

    public void setPartylist(String[] partylist) {
        this.partylist = partylist;
    }

    public List<MemberUser> getUserlist() {
        return userlist;
    }

    public void setUserlist(List<MemberUser> userlist) {
        this.userlist = userlist;
    }
}
