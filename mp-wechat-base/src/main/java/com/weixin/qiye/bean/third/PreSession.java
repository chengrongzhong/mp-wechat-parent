package com.weixin.qiye.bean.third;

import java.util.List;

/**
 * Created by fang on 2016/1/11.
 */
public class PreSession {
    private String pre_auth_code;
    private SessionInfo session_info;

    public String getPre_auth_code() {
        return pre_auth_code;
    }

    public void setPre_auth_code(String pre_auth_code) {
        this.pre_auth_code = pre_auth_code;
    }

    public SessionInfo getSession_info() {
        return session_info;
    }

    public void setSession_info(SessionInfo session_info) {
        this.session_info = session_info;
    }

    public static SessionInfo newSessionInfo(int[] ids){
        return new SessionInfo(ids);
    }

    public static class SessionInfo{
        private int[] appid;

        public SessionInfo() {

        }
        public SessionInfo(int[] ids) {
            this.appid = ids;
        }

        public int[] getAppid() {
            return appid;
        }

        public void setAppid(int[] appid) {
            this.appid = appid;
        }
    }
}
