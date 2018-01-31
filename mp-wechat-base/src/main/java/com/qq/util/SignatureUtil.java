package com.qq.util;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.Arrays;

/**
 * Created by sdyang on 2016/4/1.
 */
public class SignatureUtil {

    /**
     * 明文校验
     * @param token
     * @param timestamp  时间戳
     * @param nonce      字符串
     * @param signature  签名
     * @return
     */
    public static Boolean validate(String token, String timestamp,String nonce,String signature) {
        Boolean result = false;
        String[] array = new String[]{token,timestamp,nonce};
        Arrays.sort(array);
        String s = StringUtil.arrayToDelimitedString(array, "");
        if(signature.equals(DigestUtils.shaHex(s))){
            result = true;
        }
        return result;
    }
}
