package com.weixin.mp.util;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by fang on 2016/1/19.
 */
public class RandomUtils {
    private static DateFormat format = new SimpleDateFormat("yyyymmdd");
    private static Random random = new Random();
    private static DecimalFormat df = new DecimalFormat("0000000000");
    public static String billno(String mch_id){
        String date = format.format(new Date());
        int v = random.nextInt(999999999);
        String no = df.format(v);
        return mch_id+date+no;
    }

    public static int randomValue(int min,int max){
        int val = random.nextInt(max+1-min);
        return min+val;
    }
}
