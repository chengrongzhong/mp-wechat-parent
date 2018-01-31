package com.weixin.qiye.bean.third;

import com.weixin.qiye.bean.third.AgentInfo;
import com.weixin.qiye.bean.third.AuthCorpInfo;
import com.weixin.qiye.bean.third.AuthInfo;
import com.weixin.qiye.bean.third.AuthUserInfo;

import java.util.List;

/**
 * Created by fang on 2016/1/11.
 */
public class SysInfoResult {
    private boolean is_sys;
    private boolean is_inner;
    private AuthUserInfo user_info;
    private AuthCorpInfo corp_info;
    private List<AgentInfo> agent;
    private AuthInfo auth_info;

    public boolean is_sys() {
        return is_sys;
    }

    public void setIs_sys(boolean is_sys) {
        this.is_sys = is_sys;
    }

    public boolean is_inner() {
        return is_inner;
    }

    public void setIs_inner(boolean is_inner) {
        this.is_inner = is_inner;
    }

    public AuthUserInfo getUser_info() {
        return user_info;
    }

    public void setUser_info(AuthUserInfo user_info) {
        this.user_info = user_info;
    }

    public AuthCorpInfo getCorp_info() {
        return corp_info;
    }

    public void setCorp_info(AuthCorpInfo corp_info) {
        this.corp_info = corp_info;
    }

    public List<AgentInfo> getAgent() {
        return agent;
    }

    public void setAgent(List<AgentInfo> agent) {
        this.agent = agent;
    }

    public AuthInfo getAuth_info() {
        return auth_info;
    }

    public void setAuth_info(AuthInfo auth_info) {
        this.auth_info = auth_info;
    }

    public static class LoginInfo{
        private String login_ticket;
        private String expires_in;

        public String getLogin_ticket() {
            return login_ticket;
        }

        public void setLogin_ticket(String login_ticket) {
            this.login_ticket = login_ticket;
        }

        public String getExpires_in() {
            return expires_in;
        }

        public void setExpires_in(String expires_in) {
            this.expires_in = expires_in;
        }
    }

}
