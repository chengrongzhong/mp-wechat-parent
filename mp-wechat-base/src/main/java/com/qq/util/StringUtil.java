package com.qq.util;

/**
 * Created by sdyang on 2016/4/1.
 */
public class StringUtil {

    /**
     * 判断是否为空字符串
     * @param str
     * @return
     */
    public static boolean isEmpty(String str){
        if(str == null || str.equals("")){
            return  true;
        }else {
            return false;
        }
    }

    /**
     * 判断是否不为空字符
     * @param str
     * @return
     */
    public static boolean isNotEmpty(String str){
        return !isEmpty(str);
    }


    public static String arrayToDelimitedString(Object[] arr, String delim) {
        if (arr == null || arr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (i > 0) {
                sb.append(delim);
            }
            sb.append(arr[i]);
        }
        return sb.toString();
    }
}
