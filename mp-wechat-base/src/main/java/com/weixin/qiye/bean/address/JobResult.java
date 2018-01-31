package com.weixin.qiye.bean.address;

import com.weixin.common.bean.BaseResult;

/**
 * Created by fang on 2015/12/31.
 */
public class JobResult extends BaseResult {
    private String status;
    private String type;
    private int total;
    private int percentage;
    private int remaintime;
    private String result;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public int getRemaintime() {
        return remaintime;
    }

    public void setRemaintime(int remaintime) {
        this.remaintime = remaintime;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
