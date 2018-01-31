package com.weixin.qiye.bean.third;

/**
 * Created by fang on 2016/1/11.
 */
public class AuthCorpInfo {
    private String corpid;

    private String corp_name;

    private String corp_type;

    private String corp_round_logo_url;

    private String corp_square_logo_url;

    private int corp_user_max;

    private int corp_agent_max;

    private String corp_wxqrcode;

    public void setCorpid(String corpid){
        this.corpid = corpid;
    }
    public String getCorpid(){
        return this.corpid;
    }
    public void setCorp_name(String corp_name){
        this.corp_name = corp_name;
    }
    public String getCorp_name(){
        return this.corp_name;
    }
    public void setCorp_type(String corp_type){
        this.corp_type = corp_type;
    }
    public String getCorp_type(){
        return this.corp_type;
    }
    public void setCorp_round_logo_url(String corp_round_logo_url){
        this.corp_round_logo_url = corp_round_logo_url;
    }
    public String getCorp_round_logo_url(){
        return this.corp_round_logo_url;
    }
    public void setCorp_square_logo_url(String corp_square_logo_url){
        this.corp_square_logo_url = corp_square_logo_url;
    }
    public String getCorp_square_logo_url(){
        return this.corp_square_logo_url;
    }
    public void setCorp_user_max(int corp_user_max){
        this.corp_user_max = corp_user_max;
    }
    public int getCorp_user_max(){
        return this.corp_user_max;
    }
    public void setCorp_agent_max(int corp_agent_max){
        this.corp_agent_max = corp_agent_max;
    }
    public int getCorp_agent_max(){
        return this.corp_agent_max;
    }
    public void setCorp_wxqrcode(String corp_wxqrcode){
        this.corp_wxqrcode = corp_wxqrcode;
    }
    public String getCorp_wxqrcode(){
        return this.corp_wxqrcode;
    }

}