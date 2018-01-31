package com.spoke.wechat.service;

import com.weixin.mp.support.TicketManager;
import com.weixin.mp.support.TokenManager;
import com.weixin.qiye.support.QyTokenManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.annotation.PostConstruct;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * Created by chengrongzhong on 2017/2/22.
 * Time: 10:56.
 */
@Service
public class WeixinService {
    private static Logger logger = LoggerFactory.getLogger(WeixinService.class);

    @Value("${wenet.url}")
    private String url;

    @Value("${wenet.appid}")
    private String appid;

    @Value("${wenet.secret}")
    private String secret;

    @Value("${wenet.token}")
    private String token;

    @Value("${wenet.encodingAESKey}")
    private String encodingAESKey;

    public String cookie_user = "wenet_user";

    public String cookie_user_token = "wenet_token";

    private String salt = "service20160422";

    @PostConstruct
    public void init() {
        TokenManager.init(appid, secret);
        TicketManager.init(appid);
    }

    public static Logger getLogger() {
        return logger;
    }

    public static void setLogger(Logger logger) {
        WeixinService.logger = logger;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void refreshToken() {
        QyTokenManager.refreshToken();
    }

    public String getEncodingAESKey() {
        return encodingAESKey;
    }

    public void setEncodingAESKey(String encodingAESKey) {
        this.encodingAESKey = encodingAESKey;
    }

    public String getCookie_user() {
        return cookie_user;
    }

    public void setCookie_user(String cookie_user) {
        this.cookie_user = cookie_user;
    }

    public String getCookie_user_token() {
        return cookie_user_token;
    }

    public void setCookie_user_token(String cookie_user_token) {
        this.cookie_user_token = cookie_user_token;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public boolean verifyUserData(Model model, HttpServletRequest request, HttpServletResponse response) {
        logger.info("==========::**  Verify User  **::==========");
        return false;
    }

    private void settingCookies(HttpServletResponse response) {
        //经销商登录成功，设置cookie标识
        Cookie cookie = new Cookie("user_role", "dealer");
        cookie.setPath("/");
        response.addCookie(cookie);

        // 登录渠道商或经销商类型
        Cookie usertypeCookies = new Cookie("DEALERORCHANNELSTYPE", "2");

        // 有效时间为1天
        usertypeCookies.setMaxAge(24 * 60 * 60 * 1000);
        usertypeCookies.setPath("/");
        response.addCookie(usertypeCookies);
        logger.info("settingCookies succeed !!!");
    }


    private void responAddCookies(HttpServletResponse response, String name, String value) {
        Cookie cookie = new Cookie(name, value);// 客户信息uuid
        cookie.setMaxAge(24 * 60 * 60);
        cookie.setPath("/");
        response.addCookie(cookie);
    }

}
