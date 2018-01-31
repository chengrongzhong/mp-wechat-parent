package com.spoke.mp.wechat.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Created by chengrongzhong on 2017/2/13.
 * Time: 11:03.
 */
public class CookieUtil {
    private static Logger logger = LoggerFactory.getLogger(CookieUtil.class);

    public static final int MAX_AGE = 24 * 60 * 60;//一天
    public static final String DEFAULT_ENCODING = "UTF-8";

    public static void addCookie(HttpServletResponse response, String key, String value) {
        Cookie cookie = new Cookie(key, encode(value));
        cookie.setPath("/");// 这个要设置。不设置的话，则cookies不写入硬盘,而是写在内存,只在当前页面有用,以秒为单位
        if (MAX_AGE >= 0) cookie.setMaxAge(MAX_AGE);
        response.addCookie(cookie);
    }

    private static String encode(String value) {
        if (value == null) return null;

        try {
            return URLEncoder.encode(value, DEFAULT_ENCODING);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
        return null;
    }

    /**
     * 将cookie转成Map
     *
     * @param cookies
     * @return
     */
    public static Map<String, String> ReadCookieMap(Cookie[] cookies) {
        Map<String, String> cookieMap = new HashMap<String, String>();
        if (null != cookies) {
            for (Cookie cookie : cookies) {
                cookieMap.put(cookie.getName(), cookie.getValue());
            }
        }
        return cookieMap;
    }
}
