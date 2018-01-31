package com.weixin.qiye.api;

import com.weixin.common.client.LocalHttpClient;
import com.weixin.mp.util.JsonUtil;
import com.weixin.qiye.bean.SendResult;
import com.weixin.qiye.message.send.Message;
import com.weixin.qiye.support.QyTokenManager;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.Charset;

/**
 * 发送消息
 * Created by fang on 2015/12/31.
 * Update By Spoke on 2016/10/27
 */
public class SendMsgAPI extends BaseAPI {
    private static Logger logger = LoggerFactory.getLogger(SendMsgAPI.class);

    /**
     * 发送接口说明
     * <p>
     * 请求说明
     * <p>
     * Https请求方式: POST
     * <p>
     * https://qyapi.weixin.qq.com/cgi-bin/message/send?access_token=ACCESS_TOKEN
     */
    public static SendResult sendMsg (String access_token, Message msg) {
        String json = JsonUtil.toJSONString(msg);
        try {
            HttpUriRequest httpUriRequest = post(access_token, json);
            SendResult sendResult = LocalHttpClient.executeJsonResult(httpUriRequest, SendResult.class);
            if (sendResult.getErrcode().equals("40014")) {
                logger.info("AccessToken 过期 access_token:" + access_token);
                QyTokenManager.refreshToken();
                return sendMsg(QyTokenManager.getDefaultToken(), msg);
            }
            logger.info("SendMsgAPI sendMsg SUCCESS!!");
            return sendResult;
        } catch (Exception e) {
            logger.error("SendMsgAPI sendMsg ERROR!! Message:" + json, e);
            return new SendResult();
        }
    }

    private static HttpUriRequest post (String access_token, String json) {
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setUri(BASE_URI + "/cgi-bin/message/send")
                .addParameter("access_token", access_token)
                .setEntity(new StringEntity(json, Charset.forName("utf-8")))
                .build();
        return httpUriRequest;
    }
}
