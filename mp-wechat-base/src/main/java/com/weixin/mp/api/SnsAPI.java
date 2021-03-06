package com.weixin.mp.api;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;

import com.weixin.mp.bean.SnsToken;
import com.weixin.mp.bean.User;
import com.weixin.common.client.LocalHttpClient;

/**
 * 网页授权
 * @author LiYi
 *
 */
public class SnsAPI extends BaseAPI{

	/**
	 * 通过code换取网页授权access_token
	 * @param appid
	 * @param secret
	 * @param code
	 * @return
	 */
	public static SnsToken oauth2AccessToken(String appid,String secret,String code){
		/**
		 * 返回例子
		 * {"access_token":"OezXcEiiBSKSxW0eoylIeFxGExGPN_jte3H3tCk9LoDCINiJsViRO9vgWtWC3Avs5qnrmZeyBOYA-1_gVks4rD4g3ngm0DUd8AOxallqrBtkLjJzXtGL0YnuUFLtGsPkCXf7OCJ0iF61gi2Fir_Qng","expires_in":7200,"refresh_token":"OezXcEiiBSKSxW0eoylIeFxGExGPN_jte3H3tCk9LoDCINiJsViRO9vgWtWC3AvsjH3OiyeeZHFCmA2XP3fhSkNzxixmaXMXUpOrnfE2katrgk8Ky4mUPE5r10zjiUrWHHGx3eAp9kHBWHNe0nAqaw","openid":"oKjZ0v1OIUGGe03fo3SD99iiBFhM","scope":"snsapi_userinfo"}
		 */
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setUri(BASE_URI + "/sns/oauth2/access_token")
				.addParameter("appid", appid)
				.addParameter("secret", secret)
				.addParameter("code", code)
				.addParameter("grant_type", "authorization_code")
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,SnsToken.class);
	}

	/**
	 * 通过code换取网页授权access_token (第三方平台开发)
	 * @param appid
	 * @param code
	 * @param component_appid 服务开发方的appid
	 * @param component_access_token 服务开发方的access_token
	 * @return
	 */
	public static SnsToken oauth2ComponentAccessToken(String appid,String code,String component_appid,String component_access_token ){
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setUri(BASE_URI + "/sns/oauth2/component/access_token")
				.addParameter("appid", appid)
				.addParameter("code", code)
				.addParameter("grant_type", "authorization_code")
				.addParameter("component_appid", component_appid)
				.addParameter("component_access_token", component_access_token)
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,SnsToken.class);
	}


	/**
	 * 刷新access_token
	 * @param appid
	 * @param refresh_token
	 * @return
	 */
	public static SnsToken oauth2RefreshToken(String appid,String refresh_token){
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setUri(BASE_URI + "/sns/oauth2/refresh_token")
				.addParameter("appid", appid)
				.addParameter("refresh_token", refresh_token)
				.addParameter("grant_type", "refresh_token")
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,SnsToken.class);
	}

	/**
	 * 刷新access_token (第三方平台开发)
	 * @param appid
	 * @param refresh_token
	 * @param component_appid 服务开发商的appid
	 * @param component_access_token 服务开发方的access_token
	 * @return
	 */
	public static SnsToken oauth2ComponentRefreshToken(String appid,String refresh_token,String component_appid,String component_access_token){
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setUri(BASE_URI + "/sns/oauth2/component/refresh_token")
				.addParameter("appid", appid)
				.addParameter("refresh_token", refresh_token)
				.addParameter("grant_type", "refresh_token")
				.addParameter("component_appid", component_appid)
				.addParameter("component_access_token", component_access_token)
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,SnsToken.class);
	}

	/**
	 * 拉取用户信息(需scope为 snsapi_userinfo)
	 * @param access_token
	 * @param openid
	 * @param lang 国家地区语言版本，zh_CN 简体，zh_TW 繁体，en 英语
	 * @return
	 */
	public static User userinfo(String access_token,String openid,String lang){
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setUri(BASE_URI + "/sns/userinfo")
				.addParameter("access_token", access_token)
				.addParameter("openid", openid)
				.addParameter("lang", lang)
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,User.class);
	}
	public static User userinfo(String access_token,String openid){
		return userinfo(access_token,openid,"zh_CN");
	}

	/**
	 * 生成网页授权 URL
	 * @param appid
	 * @param redirect_uri 自动URLEncoder
	 * @param snsapi_userinfo
	 * @param state 可以为空
	 * @return
	 */
	public static String connectOauth2Authorize(String appid,String redirect_uri,boolean snsapi_userinfo,String state){
		return connectOauth2Authorize(appid, redirect_uri, snsapi_userinfo, state, null);
	}

	/**
	 * 生成网页授权 URL  (第三方平台开发)
	 * @param appid
	 * @param redirect_uri 自动URLEncoder
	 * @param snsapi_userinfo
	 * @param state 可以为空
	 * @param component_appid 第三方平台开发，可以为空。
	 * 			 服务方的appid，在申请创建公众号服务成功后，可在公众号服务详情页找到
	 * @return
	 */
	public static String connectOauth2Authorize(String appid,String redirect_uri,boolean snsapi_userinfo,String state,String component_appid){
		try {
			StringBuilder sb = new StringBuilder();
			sb.append(OPEN_URI + "/connect/oauth2/authorize?")
			.append("appid=").append(appid)
			.append("&redirect_uri=").append(URLEncoder.encode(redirect_uri, "utf-8"))
			.append("&response_type=code")
			.append("&scope=").append(snsapi_userinfo?"snsapi_userinfo":"snsapi_base")
			.append("&state=").append(state==null?"":state);
			if(component_appid!=null){
				sb.append("&component_appid=").append(component_appid);
			}
			 sb.append("#wechat_redirect");
			return sb.toString();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}

}
