package com.qq.support;

import com.qq.api.TokenAPI;
import com.qq.bean.AccessToken;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.*;


/**
 * Created by sdyang on 2016/3/31.
 */
public class TokenManager {

    private static ScheduledExecutorService scheduledExecutorService;

    private static Map<String, String> tokenMap = new LinkedHashMap<String, String>();

    private static Map<String, ScheduledFuture<?>> futureMap = new HashMap<String, ScheduledFuture<?>>();

    private static int poolSize = 2;

    private static boolean daemon = Boolean.TRUE;

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
        TokenManager.poolSize = poolSize;
    }

    /**
     * 设置线程方式
     *
     * @param daemon
     */
    public static void setDaemon(boolean daemon) {
        TokenManager.daemon = daemon;
    }

    /**
     * 初始化token 刷新，每118分钟刷新一次。
     *
     * @param appid
     * @param secret
     */
    public static void init(final String appid, final String secret) {
        if (scheduledExecutorService == null) {
            initScheduledExecutorService();
        }
        if (futureMap.containsKey(appid)) {
            futureMap.get(appid).cancel(true);
        }
        ScheduledFuture<?> scheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                refreshToken(appid, secret);
            }
        }, 0, 118, TimeUnit.MINUTES);
        futureMap.put(appid, scheduledFuture);
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
     * @param appid
     * @return
     */
    public static String getDefaultToken(String appid) {
        return tokenMap.get(appid);
    }

    public static void refreshToken(final String appid, final String secret) {
        AccessToken token = TokenAPI.token(appid, secret);
        tokenMap.put(appid, token.getAccess_token());
    }

}
