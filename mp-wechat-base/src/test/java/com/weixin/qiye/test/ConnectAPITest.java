package com.weixin.qiye.test;

import com.weixin.common.bean.Token;
import com.weixin.qiye.api.ConnectAPI;

/**
 * Created by sdyang on 2016/4/20.
 */
public class ConnectAPITest {

//    private static String cropid = "wxa6afde45e29493ce";
//
//    private static String cropsecret = "q_qpnZ3bycBMyLnEBzyaHWfRtYfcH7Yq8qRRFzihqETRzIfTkUDlFzU7Tw3fR2pj";


    private static String cropid = "wx9777ecc861796fac";
    private static String cropsecret = "gyZo6z7d4L7pxMBGGKYX1Oegty1PLggxfnFtcDEtM6x7VVEjVgmlQBZW6ERYCZLS";


    public static void main(String[] args){
        Token token= ConnectAPI.getToken(cropid, cropsecret);
        System.out.println(token.getAccess_token());
        System.out.println(String.format("Errcode:%s,Errmsg:%s", token.getErrcode(), token.getErrmsg()));
    }
}
