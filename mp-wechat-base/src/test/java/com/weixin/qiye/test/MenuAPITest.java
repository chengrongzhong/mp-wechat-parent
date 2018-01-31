package com.weixin.qiye.test;

import com.weixin.common.bean.BaseResult;
import com.weixin.mp.util.JsonUtil;
import com.weixin.qiye.api.MenuAPI;
import com.weixin.qiye.bean.menu.Button;
import com.weixin.qiye.bean.menu.MenuInfo;
import com.weixin.qiye.bean.menu.MenuResult;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sdyang on 2016/4/20.
 */
public class MenuAPITest {

    private static String  accessToken = "AD5Ur8FaNUscVNx3LcMb4sMPkZsqKwRg4ZoRTsR4jM3UH7xo5CWDGifnGlpJtM-c";

    private static int agentid = 8;

    public static void main(String[] args){

        //创建菜单
//        MenuInfo menu = new MenuInfo();
//        Button btn1 = Button.newClickButton("今日歌曲","V1001_TODAY_MUSIC");
//
//        Button subbtn1 = Button.newClickButton("赞一下我们","V1001_GOOD");
//
//        Button subbtn2 = Button.newViewButton("搜索","http://www.baidu.com");
//
//        List<Button> buttons = new ArrayList<Button>();
//        buttons.add(subbtn1);
//        buttons.add(subbtn2);
//        Button btn2 = Button.newSubButton("菜单",buttons);
//
//        List<Button> buttonList = new ArrayList<Button>();
//        buttonList.add(btn1);
//        buttonList.add(btn2);
//
//        menu.setButton(buttonList);
//
//        System.out.println(JsonUtil.toJSONString(menu));
//        BaseResult result = MenuAPI.createMenu(accessToken, agentid, menu);

        //获取菜单列表
        MenuResult result = MenuAPI.listMenu(accessToken, agentid);
        System.out.println(JsonUtil.toJSONString(result));

        //删除菜单
//        BaseResult result = MenuAPI.deleteMenu(accessToken, agentid);

//        System.out.println(result.getErrmsg());
        System.out.println("");

    }
}
