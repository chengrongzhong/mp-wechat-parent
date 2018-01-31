package com.weixin.mp.support;

import com.weixin.common.bean.Ticket;
import com.weixin.mp.api.TicketAPI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.*;

/**
 * TicketManager ticket 自动刷新
 *
 * @author chengrongzhong
 */
public class TicketManager {

    private static final Logger logger = LoggerFactory.getLogger(TicketManager.class);

    private static Map<String, String> ticketMap = new LinkedHashMap<String, String>();

    private static ScheduledExecutorService scheduledExecutorService;

    private static int poolSize = 2;

    private static boolean daemon = Boolean.TRUE;

    /**
     * 初始化ticket 刷新，每7180秒刷新一次。
     * 依赖TokenManager
     *
     * @param appid
     */
    public static void init(final String appid) {
        if (scheduledExecutorService == null) {
            initScheduledExecutorService();
        }
        ScheduledFuture<?> scheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                try {
                    refreshTicket(appid);
                } catch (RuntimeException e) {
                    e.printStackTrace();
                }
            }
        }, 8, 7180, TimeUnit.SECONDS);
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

    public static void refreshTicket(String appid) {
        Ticket ticket = TicketAPI.ticketGetticket(TokenManager.getToken(appid));
        putTicket(appid, ticket);
    }

    public static void putTicket(String appid, Ticket ticket) {
        ticketMap.put(appid, ticket.getTicket());
        logger.info(String.format("init ticket:[appid=%s,ticket=%s]", appid, ticket.getTicket()));
    }

    /**
     * 获取 jsapi ticket
     *
     * @param appid
     * @return
     */
    public static String getTicket(final String appid) {
        return ticketMap.get(appid);
    }

    /**
     * 获取第一个appid 的  jsapi ticket
     * 适用于单一微信号
     *
     * @return
     */
    public static String getDefaultTicket() {
        Object[] objs = ticketMap.values().toArray();
        return objs.length > 0 ? objs[0].toString() : null;
    }

}
