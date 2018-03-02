package com.spoke.wechat.service;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author chengrongzhong on 2018/3/2 10:48
 */
public class TimerTaskThread extends Thread {
    public TimerTaskThread() {
        super.setName("ChinaMobileThread");
    }

    @Override
    public void run() {
        String text = "四哥派福利";
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://wx.nebiim.com:65181/luckdraw/a/mobile/draw/btnDarw");
        httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded");
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();

        nvps.add(new BasicNameValuePair("phone", "13430277039"));
        nvps.add(new BasicNameValuePair("num", "1000"));
        nvps.add(new BasicNameValuePair("command", text));
        nvps.add(new BasicNameValuePair("text01", text));
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(nvps));
            CloseableHttpResponse response = httpclient.execute(httpPost);
            System.out.println(response.getStatusLine());
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                System.out.println("================================");
                SimpleDateFormat matter = new SimpleDateFormat("现在时间:yyyy年MM月dd日E HH时mm分ss秒");
                System.out.println(matter.format(new Date()));
                String resStr = EntityUtils.toString(entity, "UTF-8");
                System.out.println(resStr);
                System.out.println("================================");
            }
            // do something useful with the response body
            // and ensure it is fully consumed
            EntityUtils.consume(entity);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}