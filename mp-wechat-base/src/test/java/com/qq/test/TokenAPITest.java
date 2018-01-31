package com.qq.test;


import com.qq.api.MenuAPI;
import com.qq.api.TokenAPI;
import com.qq.bean.AccessToken;
import com.weixin.mp.bean.menu.Menu;
import com.weixin.mp.bean.menu.MenuButtons;

/**
 * Created by sdyang on 2016/3/25.
 */
public class TokenAPITest {
    private static String appid = "200553550";
    private static String secret= "u8sVLS6ENzFu5nky";

    public static void main(String[] args){
        AccessToken token = TokenAPI.token(appid, secret);
        if(token.isSuccess()){
            System.out.println("AccessToken:"+token.getAccess_token());
        }else {
            token.printErrInfo();
        }
    }

    public static String getToken(){
        AccessToken token = TokenAPI.token(appid, secret);
        if(token.isSuccess()){
            System.out.println("AccessToken:"+token.getAccess_token());
        }else {
            token.printErrInfo();
        }
        return token.getAccess_token();
    }
}
