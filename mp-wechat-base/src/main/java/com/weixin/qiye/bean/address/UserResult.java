package com.weixin.qiye.bean.address;

import com.weixin.common.bean.BaseResult;

/**
 * Created by fang on 2015/12/31.
 */
public class UserResult extends BaseResult {
    private String userid;
    private String type;
    private String jobid;

    public String getJobid() {
        return jobid;
    }

    public void setJobid(String jobid) {
        this.jobid = jobid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
}
