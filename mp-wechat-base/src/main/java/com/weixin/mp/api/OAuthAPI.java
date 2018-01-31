package com.weixin.mp.api;

/**
 * Created by fang on 2015/10/26.
 */
public class OAuthAPI {
//    自动登录实现方法
//    https://open.weixin.qq.com/connect/oauth2/authorize?appid={在微信公众平台后台获取这个APPID}&redirect_uri={你填写的回调域名下的地址}&response_type=code&scope=snsapi_base&state=1#wechat_redirect
//    https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx8d14842ec0581833&redirect_uri=http://xiaojula.meilyhome.com/together/list.html&response_type=code&scope=snsapi_base&state=1#wechat_redirect
//    scope=snsapi_base  :不需要用户点击一个授权按钮，直接跳转到回调页面
//    scope=snsapi_userinfo  :需要点击授权按钮，不过点击授权按钮有好处，一是可以在没有关注公众号的情况下也可以授权，二是授权后可以获得用户的一些信息，如昵称、性别、所在地。但是我们是为了利用openid进行登录，所以直接选择前者就可以了

    private static final String OAUTH_URL_PATTERN = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=%s&redirect_uri=%s&response_type=code&scope=%s&state=%s#wechat_redirect";

    public static final String OAUTH_SCOPE_BASE = "snsapi_base";
    public static final String OAUTH_SCOPE_USERINFO = "snsapi_userinfo";
    public static String oauthUrl(String appid,String redirect_url,String scope,String state){
        String url = String.format(OAUTH_URL_PATTERN,appid,redirect_url,scope,state);
        return url;
    }

    public static String oauthUrlBase(String appid,String redirect_url,String state){
        String url = String.format(OAUTH_URL_PATTERN,appid,redirect_url,OAUTH_SCOPE_BASE,state);
        return url;
    }
    public static String oauthUrlInfo(String appid,String redirect_url,String state){
        String url = String.format(OAUTH_URL_PATTERN,appid,redirect_url,OAUTH_SCOPE_USERINFO,state);
        return url;
    }


}
