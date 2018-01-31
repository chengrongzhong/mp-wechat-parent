package com.weixin.qiye.bean.third;

import java.util.List;

/**
 * Created by fang on 2016/1/11.
 */
public class AuthInfo {
    private List<AgentInfo> agent ;

    private List<Department> department ;

    public void setAgent(List<AgentInfo> agent){
        this.agent = agent;
    }
    public List<AgentInfo> getAgent(){
        return this.agent;
    }
    public void setDepartment(List<Department> department){
        this.department = department;
    }
    public List<Department> getDepartment(){
        return this.department;
    }
}