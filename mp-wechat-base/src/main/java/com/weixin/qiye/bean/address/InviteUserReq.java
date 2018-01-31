package com.weixin.qiye.bean.address;

/**
 * Created by fang on 2015/12/31.
 */
public class InviteUserReq {
    private String touser;
    private String toparty;
    private String totag;
    private String media_id;
    private CallbackInfo callback;

    public String getMedia_id() {
        return media_id;
    }

    public void setMedia_id(String media_id) {
        this.media_id = media_id;
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

    public CallbackInfo getCallback() {
        return callback;
    }

    public void setCallback(CallbackInfo callback) {
        this.callback = callback;
    }

    private class CallbackInfo{
        private String url;
        private String token;
        private String encodingaeskey;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getEncodingaeskey() {
            return encodingaeskey;
        }

        public void setEncodingaeskey(String encodingaeskey) {
            this.encodingaeskey = encodingaeskey;
        }
    }
}
