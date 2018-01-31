package com.weixin.qiye.bean.app;

import com.weixin.common.bean.BaseResult;
import com.weixin.qiye.bean.address.Tag;

import java.util.List;

/**
 * http://qydev.weixin.qq.com/wiki/index.php?title=%E8%AE%BE%E7%BD%AE%E4%BC%81%E4%B8%9A%E5%8F%B7%E5%BA%94%E7%94%A8
 * Created by fang on 2016/1/6.
 */
public class AppReq {
    private String agentid;
    private String name;
    private int report_location_flag;
    private String logo_mediaid;
    private String home_url;
    private String description;
    private String redirect_domain;
    private int isreportuser;
    private int isreportenter;
    private String sequare_logo_url;
    private String round_logo_url;

    public String getSequare_logo_url() {
        return sequare_logo_url;
    }

    public void setSequare_logo_url(String sequare_logo_url) {
        this.sequare_logo_url = sequare_logo_url;
    }

    public String getRound_logo_url() {
        return round_logo_url;
    }

    public void setRound_logo_url(String round_logo_url) {
        this.round_logo_url = round_logo_url;
    }

    public String getAgentid() {
        return agentid;
    }

    public void setAgentid(String agentid) {
        this.agentid = agentid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getReport_location_flag() {
        return report_location_flag;
    }

    public void setReport_location_flag(int report_location_flag) {
        this.report_location_flag = report_location_flag;
    }

    public String getLogo_mediaid() {
        return logo_mediaid;
    }

    public void setLogo_mediaid(String logo_mediaid) {
        this.logo_mediaid = logo_mediaid;
    }

    public String getHome_url() {
        return home_url;
    }

    public void setHome_url(String home_url) {
        this.home_url = home_url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRedirect_domain() {
        return redirect_domain;
    }

    public void setRedirect_domain(String redirect_domain) {
        this.redirect_domain = redirect_domain;
    }

    public int getIsreportuser() {
        return isreportuser;
    }

    public void setIsreportuser(int isreportuser) {
        this.isreportuser = isreportuser;
    }

    public int getIsreportenter() {
        return isreportenter;
    }

    public void setIsreportenter(int isreportenter) {
        this.isreportenter = isreportenter;
    }
}
