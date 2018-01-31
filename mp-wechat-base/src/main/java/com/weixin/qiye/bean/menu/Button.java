package com.weixin.qiye.bean.menu;

import java.util.List;

/**
 * Created by fang on 2016/1/8.
 */
public class Button {
    private String type;
    private String name;
    private String url;
    private String key;

    private List<Button> sub_button;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public List<Button> getSub_button() {
        return sub_button;
    }

    public void setSub_button(List<Button> sub_button) {
        this.sub_button = sub_button;
    }

    public Button(){}

    public Button(String name){this.name = name;}

    public Button(String type,String name,String key){
        this.setType(type);
        this.setName(name);
        if(key !=null) {
            this.setKey(key);
        }
    }
    //单击按钮
    public static Button newClickButton(String name,String key){
        Button button = new Button(MenuType.CLICK.getName(),name,key);
        return button;
    }

    //url跳转按钮
    public static Button newViewButton(String name,String url){
        Button button = new Button(MenuType.VIEW.getName(),name,null);
        button.setUrl(url);
        return button;
    }

    public static Button newSubButton(String name,List<Button> buttons){
        Button button = new Button(name);
        button.setSub_button(buttons);
        return button;
    }
}
