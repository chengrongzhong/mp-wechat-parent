package com.weixin.qiye.bean.third;

import com.alibaba.fastjson.JSON;
import com.weixin.mp.util.JsonUtil;

/**
 * Created by fang on 2016/1/11.
 */
public class AuthResult {
    private AuthCorpInfo auth_corp_info;
    private AuthInfo auth_info;

    public AuthCorpInfo getAuth_corp_info() {
        return auth_corp_info;
    }

    public void setAuth_corp_info(AuthCorpInfo auth_corp_info) {
        this.auth_corp_info = auth_corp_info;
    }

    public AuthInfo getAuth_info() {
        return auth_info;
    }

    public void setAuth_info(AuthInfo auth_info) {
        this.auth_info = auth_info;
    }
}
