package com.weixin.qiye.bean.im;

import com.weixin.common.bean.BaseResult;

import java.util.List;

/**
 * Created by fang on 2016/1/11.
 */
public class MuteResult extends BaseResult {
    private List<String> invaliduser;

    public List<String> getInvaliduser() {
        return invaliduser;
    }

    public void setInvaliduser(List<String> invaliduser) {
        this.invaliduser = invaliduser;
    }
}
