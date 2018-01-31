package com.weixin.qiye.bean.third;

import java.util.List;

/**
 * Created by fang on 2016/1/11.
 */
public class AgentInfo {
    private int agentid;

    private String name;

    private String square_logo_url;

    private String round_logo_url;

    private int appid;

    private List<String> api_group ;

    private int auth_type;

    public int getAuth_type() {
        return auth_type;
    }

    public void setAuth_type(int auth_type) {
        this.auth_type = auth_type;
    }

    public void setAgentid(int agentid){
        this.agentid = agentid;
    }
    public int getAgentid(){
        return this.agentid;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setSquare_logo_url(String square_logo_url){
        this.square_logo_url = square_logo_url;
    }
    public String getSquare_logo_url(){
        return this.square_logo_url;
    }
    public void setRound_logo_url(String round_logo_url){
        this.round_logo_url = round_logo_url;
    }
    public String getRound_logo_url(){
        return this.round_logo_url;
    }
    public void setAppid(int appid){
        this.appid = appid;
    }
    public int getAppid(){
        return this.appid;
    }
    public void setApi_group(List<String> api_group){
        this.api_group = api_group;
    }
    public List<String> getApi_group(){
        return this.api_group;
    }

}