package com.weixin.qiye.bean.im;

/**
 * Created by fang on 2016/1/11.
 */
public class ChatMessage {
    private Receiver receiver;
    private String sender;
    private String msgtype;

    public ChatMessage(String msgtype) {
        this.msgtype = msgtype;
    }

    public Receiver getReceiver() {
        return receiver;
    }

    public void setReceiver(Receiver receiver) {
        this.receiver = receiver;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }
}
