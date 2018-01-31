package com.weixin.qiye.bean.address;

import com.weixin.common.bean.BaseResult;
import com.weixin.qiye.bean.address.DeptReq;

import java.util.List;

/**
 * Created by fang on 2015/12/31.
 */
public class DepartmentsResult extends BaseResult {

    private List<DeptReq> department;

    public List<DeptReq> getDepartment() {
        return department;
    }

    public void setDepartment(List<DeptReq> department) {
        this.department = department;
    }
}
