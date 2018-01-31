package com.weixin.qiye.message.send;

import java.util.Map;

/**
 * Created by fang on 2016/1/8.
 */
public abstract class Message {
    private String touser;
    private String toparty;
    private String totag;
    private String msgtype;
    private int agentid;
    private String safe;

    public Message(String msgtype) {
        this.msgtype = msgtype;
    }

    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public String getToparty() {
        return toparty;
    }

    public void setToparty(String toparty) {
        this.toparty = toparty;
    }

    public String getTotag() {
        return totag;
    }

    public void setTotag(String totag) {
        this.totag = totag;
    }

    public String getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }

    public int getAgentid() {
        return agentid;
    }

    public void setAgentid(int agentid) {
        this.agentid = agentid;
    }

    public String getSafe() {
        return safe;
    }

    public void setSafe(String safe) {
        this.safe = safe;
    }
}
