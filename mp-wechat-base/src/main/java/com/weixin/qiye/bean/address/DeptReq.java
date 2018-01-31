package com.weixin.qiye.bean.address;

/**
 * Created by fang on 2015/12/31.
 */
public class DeptReq {

    private String parentid;//父亲部门id。根部门id为1

    private String name;//部门名称。长度限制为1~64个字节，字符不能包括\:*?"<>｜

    private String order;//在父部门中的次序值。order值小的排序靠前。

    private String id;//部门id，整型。指定时必须大于1，不指定时则自动生成

    public String getParentid() {
        return parentid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
