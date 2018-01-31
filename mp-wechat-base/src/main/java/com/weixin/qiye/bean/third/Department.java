package com.weixin.qiye.bean.third;

/**
 * Created by fang on 2016/1/11.
 */
public class Department {
    private int id;

    private String name;

    private int parentid;

    private String writable;

    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setParentid(int parentid){
        this.parentid = parentid;
    }
    public int getParentid(){
        return this.parentid;
    }
    public void setWritable(String writable){
        this.writable = writable;
    }
    public String getWritable(){
        return this.writable;
    }

}