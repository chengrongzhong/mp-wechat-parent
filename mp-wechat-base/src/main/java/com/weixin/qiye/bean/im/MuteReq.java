package com.weixin.qiye.bean.im;

import java.util.List;

/**
 * Created by fang on 2016/1/11.
 */
public class MuteReq {
    private List<MuteUser> user_mute_list;

    public List<MuteUser> getUser_mute_list() {
        return user_mute_list;
    }

    public void setUser_mute_list(List<MuteUser> user_mute_list) {
        this.user_mute_list = user_mute_list;
    }

    public static class MuteUser{
        private String userid;
        private int status;

        public String getUserid() {
            return userid;
        }

        public void setUserid(String userid) {
            this.userid = userid;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }
    }
}
