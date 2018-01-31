package com.weixin.qiye.bean.app;

import com.weixin.common.bean.BaseResult;
import com.weixin.qiye.bean.address.Tag;

import java.util.List;

/**
 * http://qydev.weixin.qq.com/wiki/index.php?title=%E8%AE%BE%E7%BD%AE%E4%BC%81%E4%B8%9A%E5%8F%B7%E5%BA%94%E7%94%A8
 * Created by fang on 2016/1/6.
 */
public class AppResult extends BaseResult {

    private String logo_mediaid;
    private String home_url;

    private String agentid;
    private String name;
    private String sequare_logo_url;
    private String round_logo_url;
    private String description;
    private List<AppUser> allow_userinfos;
    private String allow_partys;
    private List<Tag> allow_tags;
    private String close;
    private String redirect_domain;
    private int report_location_flag;
    private int isreportuser;
    private int isreportenter;
    private int type;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<AppUser> getAllow_userinfos() {
        return allow_userinfos;
    }

    public void setAllow_userinfos(List<AppUser> allow_userinfos) {
        this.allow_userinfos = allow_userinfos;
    }

    public String getAllow_partys() {
        return allow_partys;
    }

    public void setAllow_partys(String allow_partys) {
        this.allow_partys = allow_partys;
    }

    public List<Tag> getAllow_tags() {
        return allow_tags;
    }

    public void setAllow_tags(List<Tag> allow_tags) {
        this.allow_tags = allow_tags;
    }

    public String getClose() {
        return close;
    }

    public void setClose(String close) {
        this.close = close;
    }

    public String getRedirect_domain() {
        return redirect_domain;
    }

    public void setRedirect_domain(String redirect_domain) {
        this.redirect_domain = redirect_domain;
    }

    public int getReport_location_flag() {
        return report_location_flag;
    }

    public void setReport_location_flag(int report_location_flag) {
        this.report_location_flag = report_location_flag;
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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
