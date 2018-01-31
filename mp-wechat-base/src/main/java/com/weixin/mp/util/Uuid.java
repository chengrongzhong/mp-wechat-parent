package com.weixin.mp.util;

import java.util.UUID;

/**
 * Created by fang on 2015/10/15.
 */
public class Uuid {
    public static String uuid(){
        String uuid = UUID.randomUUID().toString();
        uuid = uuid.replace("-", "");
        return uuid;
    }
}
