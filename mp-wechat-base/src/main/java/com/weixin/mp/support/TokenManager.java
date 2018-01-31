package com.weixin.mp.support;

import com.weixin.mp.api.TokenAPI;
import com.weixin.common.bean.Token;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.*;

/**
 * TokenManager token 自动刷新
 *
 * @author Chengrongzhong
 */
public class TokenManager {
    private static final Logger logger = LoggerFactory.getLogger(TokenManager.class);

    private static Map<String, String> tokenMap = new LinkedHashMap<String, String>();

    private static ScheduledExecutorService scheduledExecutorService;

    private static int poolSize = 2;

    private static boolean daemon = Boolean.TRUE;

    private static String appid = "";

    private static String secret = "";

    /**
     * 初始化token 刷新，每7180秒刷新一次。
     *
     * @param appid
     * @param secret
     */
    public static void init(final String appid, final String secret) {
        TokenManager.appid = appid;
        TokenManager.secret = secret;
        if (scheduledExecutorService == null) {
            initScheduledExecutorService();
        }
        ScheduledFuture<?> scheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                try {
                    refreshToken();
                } catch (RuntimeException e) {
                    e.printStackTrace();
                }
            }
        }, 1, 7180, TimeUnit.SECONDS);
    }

    /**
     * 初始化 scheduledExecutorService
     */
    private static void initScheduledExecutorService() {
        scheduledExecutorService = Executors.newScheduledThreadPool(poolSize, new ThreadFactory() {

            @Override
            public Thread newThread(Runnable arg0) {
                Thread thread = Executors.defaultThreadFactory().newThread(arg0);
                //设置守护线程
                thread.setDaemon(daemon);
                return thread;
            }
        });
    }

    public static void refreshToken() {
        Token token = TokenAPI.token(TokenManager.appid, TokenManager.secret);
        putToken(TokenManager.appid, token);
    }

    public static void putToken(String appid, Token token) {
        tokenMap.put(TokenManager.appid, token.getAccess_token());
        logger.info(String.format("init token:[appid=%s,token=%s]", appid, token.getAccess_token()));
    }

    /**
     * 获取 access_token
     *
     * @param appid
     * @return
     */
    public static String getToken(String appid) {
        return tokenMap.get(appid);
    }

    /**
     * 获取第一个appid 的 access_token
     * 适用于单一微信号
     *
     * @return
     */
    public static String getDefaultToken() {
        Object[] objs = tokenMap.values().toArray();
        return objs.length > 0 ? objs[0].toString() : null;
    }

}
