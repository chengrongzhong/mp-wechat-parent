package com.weixin.qiye.bean.kefu;

import com.weixin.common.bean.BaseResult;

import java.util.List;

/**
 * Created by fang on 2016/1/12.
 */
public class KefuResult extends BaseResult {
    private KefuInfo internal;
    private KefuInfo external;

    public KefuInfo getInternal() {
        return internal;
    }

    public void setInternal(KefuInfo internal) {
        this.internal = internal;
    }

    public KefuInfo getExternal() {
        return external;
    }

    public void setExternal(KefuInfo external) {
        this.external = external;
    }

    public static class KefuInfo{
        private List<String> user;
        private List<Integer> party;
        private List<Integer> tag;

        public List<String> getUser() {
            return user;
        }

        public void setUser(List<String> user) {
            this.user = user;
        }

        public List<Integer> getParty() {
            return party;
        }

        public void setParty(List<Integer> party) {
            this.party = party;
        }

        public List<Integer> getTag() {
            return tag;
        }

        public void setTag(List<Integer> tag) {
            this.tag = tag;
        }
    }
}
