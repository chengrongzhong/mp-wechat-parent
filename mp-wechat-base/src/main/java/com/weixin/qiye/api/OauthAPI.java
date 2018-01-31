package com.weixin.qiye.api;

import com.weixin.common.client.LocalHttpClient;
import com.weixin.qiye.bean.oauth.ConvertResult;
import com.weixin.qiye.bean.oauth.OAuthResult;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;

import java.nio.charset.Charset;

/**
 * 身份验证接口
 * Created by fang on 2015/12/31.
 */
public class OauthAPI extends BaseAPI {
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

    /**
     企业获取code

     企业如果需要员工在跳转到企业网页时带上员工的身份信息，需构造如下的链接：

     https://open.weixin.qq.com/connect/oauth2/authorize?appid=CORPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect
     */

    /**
     根据code获取成员信息

     请求说明

     Https请求方式：GET

     https://qyapi.weixin.qq.com/cgi-bin/user/getuserinfo?access_token=ACCESS_TOKEN&code=CODE
     */
    public static OAuthResult getUserInfo(String access_token,String code){
        HttpUriRequest httpUriRequest = RequestBuilder.get()
                .setUri(BASE_URI + "/cgi-bin/user/getuserinfo")
                .addParameter("access_token", access_token)
                .addParameter("code", code)
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest, OAuthResult.class);
    }

    /**
    userid转换成openid接口

    该接口使用场景为微信支付、微信红包和企业转账，企业号用户在使用微信支付的功能时，需要自行将企业号的userid转成openid。在使用微信红包功能时，需要将应用id和userid转成appid和openid才能使用。

    请求说明

    Https请求方式: POST

    https://qyapi.weixin.qq.com/cgi-bin/user/convert_to_openid?access_token=ACCESS_TOKEN
    */
    public static ConvertResult convertToOpenid(String access_token,String userid,String agentid){
        String json = "{\"userid\":\""+userid+"\",\"agentid\":"+agentid+"}";
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setUri(BASE_URI + "/cgi-bin/user/convert_to_openid")
                .addParameter("access_token", access_token)
                .setEntity(new StringEntity(json, Charset.forName("utf-8")))
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest, ConvertResult.class);
    }

    /**
     openid转换成userid接口

     该接口主要应用于使用微信支付、微信红包和企业转账之后的结果查询，开发者需要知道某个结果事件的openid对应企业号内成员的信息时，可以通过调用该接口进行转换查询。

     请求说明

     Https请求方式: POST

     https://qyapi.weixin.qq.com/cgi-bin/user/convert_to_userid?access_token=ACCESS_TOKEN
     */
    public static ConvertResult convertToUserid(String access_token,String openid){
        String json = "{\"openid\":\""+openid+"\"}";
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setUri(BASE_URI + "/cgi-bin/user/convert_to_userid")
                .addParameter("access_token", access_token)
                .setEntity(new StringEntity(json, Charset.forName("utf-8")))
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest, ConvertResult.class);
    }

}

