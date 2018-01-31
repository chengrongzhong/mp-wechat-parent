package com.weixin.qiye.api;

import com.weixin.common.bean.BaseResult;
import com.weixin.common.client.LocalHttpClient;
import com.weixin.mp.util.JsonUtil;
import com.weixin.qiye.bean.menu.MenuInfo;
import com.weixin.qiye.bean.menu.MenuResult;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;

import java.nio.charset.Charset;

/**
 * 自定义菜单管理
 * Created by fang on 2015/12/31.
 */
public class MenuAPI extends BaseAPI {

    /**
     创建应用菜单
     请求说明

     Https请求方式: POST

     https://qyapi.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN&agentid=AGENTID
     */
    public static  BaseResult createMenu(String access_token,int agentid,MenuInfo info){
        String json = JsonUtil.toJSONString(info);
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setUri(BASE_URI + "/cgi-bin/menu/create")
                .addParameter(ACCESS_TOKEN, access_token)
                .addParameter("agentid", String.valueOf(agentid))
                .setEntity(new StringEntity(json, Charset.forName("utf-8")))
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest, BaseResult.class,ChartSet);
    }
    /**
     删除菜单

     请求说明

     Https请求方式：GET

     https://qyapi.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN&agentid=AGENTID
     */
    public static  BaseResult deleteMenu(String access_token,int agentid){
        HttpUriRequest httpUriRequest = RequestBuilder.get()
                .setUri(BASE_URI + "/cgi-bin/menu/delete")
                .addParameter(ACCESS_TOKEN, access_token)
                .addParameter("agentid", String.valueOf(agentid))
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest, BaseResult.class,ChartSet);
    }


    /**
     获取菜单列表

     请求说明

     Https请求方式：GET

     https://qyapi.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN&agentid=AGENTID
     */
    public static MenuResult listMenu(String access_token,int agentid){
        HttpUriRequest httpUriRequest = RequestBuilder.get()
                .setUri(BASE_URI + "/cgi-bin/menu/get")
                .addParameter(ACCESS_TOKEN, access_token)
                .addParameter("agentid", String.valueOf(agentid))
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest, MenuResult.class,"gbk");
    }
}
