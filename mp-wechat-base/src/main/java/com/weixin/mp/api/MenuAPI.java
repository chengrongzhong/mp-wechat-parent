package com.weixin.mp.api;

import java.nio.charset.Charset;

import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;

import com.weixin.common.bean.BaseResult;
import com.weixin.mp.bean.menu.Menu;
import com.weixin.mp.bean.menu.MenuButtons;
import com.weixin.mp.bean.selfmenu.CurrentSelfmenuInfo;
import com.weixin.common.client.LocalHttpClient;
import com.weixin.mp.util.JsonUtil;

public class MenuAPI extends BaseAPI{
	/**
	 * 点击事件
	 */
	public static final String MENU_CLICK="click";
	/**
	 * 跳转RUL
	 */
	public static final String MENU_VIEW="view";
	/**
	 * 扫码推事件
	 */
	public static final String MENU_SCANCODE_PUSH="scancode_push";
	/**
	 * 扫码推事件且弹出,消息接收中,提示框
	 */
	public static final String MENU_SCANCODE_WAITMSG="scancode_waitmsg";
	/**
	 * 弹出系统拍照发图
	 */
	public static final String MENU_PIC_SYSPHOTO="pic_sysphoto";
	/**
	 * 弹出拍照或者相册发图
	 */
	public static final String MENU_PIC_PHOTO_OR_ALBUM="pic_photo_or_album";
	/**
	 * 弹出微信相册发图器
	 */
	public static final String MENU_PIC_WEIXIN="pic_weixin";
	/**
	 * 弹出地理位置选择器
	 */
	public static final String MENU_LOCATION_SELECT="location_select";
	/**
	 * 下发消息
	 */
	public static final String MENU_MEDIA="media_id";
	/**
	 * 跳转图文消息URL
	 */
	public static final String MENU_VIEW_LIMITED="view_limited";


	/**
	 * 创建菜单
	 * @param access_token
	 * @param menuJson 菜单json 数据 例如{\"button\":[{\"type\":\"click\",\"name\":\"今日歌曲\",\"key\":\"V1001_TODAY_MUSIC\"},{\"type\":\"click\",\"name\":\"歌手简介\",\"key\":\"V1001_TODAY_SINGER\"},{\"name\":\"菜单\",\"sub_button\":[{\"type\":\"view\",\"name\":\"搜索\",\"url\":\"http://www.soso.com/\"},{\"type\":\"view\",\"name\":\"视频\",\"url\":\"http://v.qq.com/\"},{\"type\":\"click\",\"name\":\"赞一下我们\",\"key\":\"V1001_GOOD\"}]}]}
	 * @return
	 */
	public static BaseResult menuCreate(String access_token,String menuJson){
		HttpUriRequest httpUriRequest = RequestBuilder.post()
										.setHeader(jsonHeader)
										.setUri(BASE_URI+"/cgi-bin/menu/create")
										.addParameter("access_token", access_token)
										.setEntity(new StringEntity(menuJson,Charset.forName("utf-8")))
										.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,BaseResult.class);
	}

	/**
	 * 创建菜单
	 * @param access_token
	 * @param menuButtons
	 * @return
	 */
	public static BaseResult menuCreate(String access_token,MenuButtons menuButtons){
		String str = JsonUtil.toJSONString(menuButtons);
		return menuCreate(access_token,str);
	}

	/**
	 * 获取菜单
	 * @param access_token
	 * @return
	 */
	public static Menu menuGet(String access_token){
		HttpUriRequest httpUriRequest = RequestBuilder.post()
					.setUri(BASE_URI+"/cgi-bin/menu/get")
					.addParameter("access_token", access_token)
					.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,Menu.class);
	}

	/**
	 * 删除菜单
	 * @param access_token
	 * @return
	 */
	public static BaseResult menuDelete(String access_token){
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setUri(BASE_URI+"/cgi-bin/menu/delete")
				.addParameter("access_token", access_token)
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,BaseResult.class);
	}


	/**
	 * 获取自定义菜单配置
	 * 本接口将会提供公众号当前使用的自定义菜单的配置，
	 * 如果公众号是通过API调用设置的菜单，则返回菜单的开发配置，
	 * 而如果公众号是在公众平台官网通过网站功能发布菜单，
	 * 则本接口返回运营者设置的菜单配置。
	 * @param access_token
	 * @return
	 */
	public static CurrentSelfmenuInfo get_current_selfmenu_info(String access_token){
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setUri(BASE_URI+"/cgi-bin/get_current_selfmenu_info")
				.addParameter("access_token", access_token)
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,CurrentSelfmenuInfo.class);
	}



}