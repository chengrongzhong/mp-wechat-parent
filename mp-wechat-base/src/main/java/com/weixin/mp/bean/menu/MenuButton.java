package com.weixin.mp.bean.menu;

import java.util.List;

/**
 * Created by fang on 2015/10/24.
 */
public class MenuButton {
        private String type;	//click|view
        private String name;
        private String key;
        private String url;

        private List<MenuButton> sub_button;

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

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public List<MenuButton> getSub_button() {
            return sub_button;
        }

        public void setSub_button(List<MenuButton> subButton) {
            sub_button = subButton;
        }

    public static MenuButton newClickButton(String name,String key,List<MenuButton> btns){
        MenuButton btn = newButton(MenuType.CLICK,name,key,null);
        btn.setSub_button(btns);
        return btn;
    }
    public static MenuButton newViewButton(String name,String url){
        return newButton(MenuType.VIEW,name,null,url);
    }

    public static MenuButton newButton(MenuType type,String name,String key,String url){
        MenuButton btn = new MenuButton();
        btn.setKey(key);
        btn.setType(type.toString());
        btn.setName(name);
        btn.setUrl(url);
        return btn;
    }

}
