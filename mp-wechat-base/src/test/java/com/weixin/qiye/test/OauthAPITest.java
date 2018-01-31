package com.weixin.qiye.test;

import com.weixin.qiye.api.OauthAPI;
import com.weixin.qiye.bean.oauth.OAuthResult;

/**
 * Created by sdyang on 2016/4/21.
 */
public class OauthAPITest {

    private static String  accessToken = "i-NQfkV1COv7scS-V5Vbecgi-ivtj04wC96kHpYeCWUfPHXMNtqFEFtriX8AEoyn";
    private static String code = "sdf";
    public static void main(String[] args){

        OAuthResult oAuthResult = OauthAPI.getUserInfo(accessToken,code);
        if (oAuthResult.isSuccess()){
            System.out.println(oAuthResult.getUserId());
        }else {
            System.out.println(oAuthResult.getErrmsg());
        }
    }
}
