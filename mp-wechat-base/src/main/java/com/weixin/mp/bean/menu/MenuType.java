package com.weixin.mp.bean.menu;

/**
 * Created by fang on 2015/10/19.
 */
public enum MenuType {
    CLICK("click","点击事件"),
    VIEW("view","view"),
    SCANCODE_WAITMSG("scancode_waitmsg","扫码带提示"),
    SCANCODE_PUSH("scancode_push","扫码推事件"),
    PIC_SYSPHOTO("pic_sysphoto","系统拍照发图"),
    PIC_PHOTO_OR_ALBUM("pic_photo_or_album","拍照或者相册发图"),
    PIC_WEIXIN("pic_weixin","微信相册发图"),
    LOCATION_SELECT("location_select","发送位置"),
    MEDIA_ID("media_id","图片"),
    VIEW_LIMITED("view_limited","图文消息");

    private MenuType(String name,String desc){
        this.name = name;
        this.desc = desc;
    }

    private String name;
    private String desc;

    public String getName(){
        return name;
    }

    public String getDesc(){
        return desc;
    }

    public String toString(){
        return name;
    }
}
