package com.weixin.qiye.message.send;

/**
 * 发送时使用永久图文素材
 * 注：mpnews消息与news消息类似，不同的是图文消息内容存储在微信后台，并且支持保密选项。每个应用每天最多可以发送100次。
 * Created by fang on 2016/1/8.
 */
public class MaterialMessage extends Message {
    private Mpnews mpnews;
    public MaterialMessage() {
        super("mpnews");
    }

    public Mpnews getMpnews() {
        return mpnews;
    }

    public void setMpnews(Mpnews mpnews) {
        this.mpnews = mpnews;
    }

    public static Mpnews newMpnews(String media_id) {
        return new Mpnews(media_id);
    }

    private static class Mpnews{
        private String media_id;

        public Mpnews(){

        }
        public Mpnews(String media_id) {
            this.media_id = media_id;
        }

        public String getMedia_id() {
            return media_id;
        }

        public void setMedia_id(String media_id) {
            this.media_id = media_id;
        }
    }
}
