package com.weixin.qiye.support;

import com.weixin.common.bean.Token;
import com.weixin.qiye.api.ConnectAPI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.*;

/**
 * 微信企业号应用Token管理
 * Created by sdyang on 2016/4/21.
 */
public class QyTokenManager {

    private static Logger logger = LoggerFactory.getLogger(QyTokenManager.class);

    private static ScheduledExecutorService scheduledExecutorService;

    private static Map<String, String> tokenMap = new LinkedHashMap<String, String>();

    private static Map<String, ScheduledFuture<?>> futureMap = new HashMap<String, ScheduledFuture<?>>();

    private static int poolSize = 2;

    private static boolean daemon = Boolean.TRUE;

    private static String corpid = "";

    private static String secret = "";

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

    /**
     * 设置线程池
     *
     * @param poolSize
     */
    public static void setPoolSize(int poolSize) {
        QyTokenManager.poolSize = poolSize;
    }

    /**
     * 设置线程方式
     *
     * @param daemon
     */
    public static void setDaemon(boolean daemon) {
        QyTokenManager.daemon = daemon;
    }

    /**
     * 初始化token 刷新，每118分钟刷新一次。
     *
     * @param corpid
     * @param secret
     */
    public static void init(final String corpid, final String secret) {
        QyTokenManager.corpid = corpid;
        QyTokenManager.secret = secret;
        if (scheduledExecutorService == null) {
            initScheduledExecutorService();
        }
        if (futureMap.containsKey(corpid + secret)) {
            futureMap.get(corpid + secret).cancel(true);
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
        }, 0, 120, TimeUnit.MINUTES);
        futureMap.put(corpid + secret, scheduledFuture);
    }

    /**
     * 取消 token 刷新
     */
    public static void destroyed() {
        scheduledExecutorService.shutdownNow();
    }

    /**
     * 获取 access_token
     *
     * @param corpid
     * @param secret
     * @return
     */
    public static String getToken(String corpid, String secret) {
        return tokenMap.get(corpid + secret);
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

    public static void refreshToken() {
        Token token = ConnectAPI.getToken(QyTokenManager.corpid, QyTokenManager.secret);
        tokenMap.put(QyTokenManager.corpid + QyTokenManager.secret, token.getAccess_token());
        logger.info("获取AccessToken:" + token.getAccess_token());
    }

}
