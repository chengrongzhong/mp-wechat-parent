package com.weixin.qiye.bean.address;

import com.weixin.common.bean.BaseResult;

import java.util.List;

/**
 * Created by fang on 2015/12/31.
 */
public class TagResult extends BaseResult {
    private String tagid;
    private List<Tag> taglist;

    public List<Tag> getTaglist() {
        return taglist;
    }

    public void setTaglist(List<Tag> taglist) {
        this.taglist = taglist;
    }

    public String getTagid() {
        return tagid;
    }

    public void setTagid(String tagid) {
        this.tagid = tagid;
    }
}
