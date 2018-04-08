package com.spoke.wechat.service;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 *
 * @author chengrongzhong on 2018/3/2 10:46
 */
public class TimerService {

    public static void init() {
        long restMinuteReload = restMinuteReload();
        ScheduledThreadPoolExecutor timerThreadPool = new ScheduledThreadPoolExecutor(1, new ThreadFactoryBuilder().setNameFormat("TimerThreadPool-01").build());
        timerThreadPool.scheduleWithFixedDelay(new TimerTaskThread(), restMinuteReload, 12 * 60, TimeUnit.MINUTES);
    }

    public static long restMinuteReload() {
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(new Date());
        c2.setTime(new Date());
        int nowDay = c1.get(Calendar.DAY_OF_MONTH);
        c2.set(Calendar.DATE, nowDay + 1);
        c2.set(Calendar.HOUR_OF_DAY, 0);
        c2.set(Calendar.MINUTE, 10);
        c2.set(Calendar.SECOND, 0);
        return minuteDiff(c1.getTime(), c2.getTime());
    }

    public static long minuteDiff(long d1, long d2) {
        return Math.abs(d1 - d2) / (1000 * 60);
    }

    public static long minuteDiff(Date d1, Date d2) {
        return minuteDiff(d1.getTime(), d2.getTime());
    }
}
