package com.weixin.qiye.bean.app;

import com.weixin.common.bean.BaseResult;

import java.util.List;

/**
 * Created by fang on 2016/1/6.
 */
public class AppsResult extends BaseResult {
    private List<AppReq> agentlist;

    public List<AppReq> getAgentlist() {
        return agentlist;
    }

    public void setAgentlist(List<AppReq> agentlist) {
        this.agentlist = agentlist;
    }
}
