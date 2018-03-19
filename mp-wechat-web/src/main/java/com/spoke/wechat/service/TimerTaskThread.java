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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;

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
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://hd.nebiim.com/luckdraw/a/mobile/draw/btnDarw");
        httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded");

        Map<String, String> pageValue = getPageValue("http://hd.nebiim.com/luckdraw/a/mobile/draw/card?m=Bl7zlhRKXoQcglHJb5hHWw%3D%3D", "UTF-8");

        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        nvps.add(new BasicNameValuePair("phone", "13430277039"));
        nvps.add(new BasicNameValuePair("num", pageValue.get("num")));
        nvps.add(new BasicNameValuePair("command", pageValue.get("command")));
        nvps.add(new BasicNameValuePair("text01", pageValue.get("command")));
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

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>(5);
//        String command = "         var command = '嚯嚯嚯嚯'";
//        String num = "         var num = '1000'";
//        String htmls= getPageSource("http://www.no5.com.cn/browse/specialprice_p2.html","GBK");
//        String htmls= getPageSource("http://www.baidu.com","UTF-8");
//        String htmls= getPageSource("https://www.jd.com/","UTF-8");
//        String htmls= getPageSource("http://wx.nebiim.com:65181/luckdraw/a/mobile/draw/card?m=Bl7zlhRKXoQcglHJb5hHWw%3D%3D","UTF-8");
        String htmls= getPageSource("http://hd.nebiim.com/luckdraw/a/mobile/draw/card?m=Bl7zlhRKXoQcglHJb5hHWw%3D%3D","UTF-8", map);
        System.err.println(map);
        System.out.println(htmls);




    }

    public static String getPageSource(String pageUrl,String encoding, Map<String, String> map) {
        StringBuffer sb = new StringBuffer();
        try {
            //构建一URL对象
            URL url = new URL(pageUrl);
            //使用openStream得到一输入流并由此构造一个BufferedReader对象
            BufferedReader in = new BufferedReader(new InputStreamReader(url
                    .openStream(), encoding));
            String line;
            //读取www资源
            while ((line = in.readLine()) != null) {
                if (line.contains("var command = '")) {
                    System.err.println(line);
                    String[] split = line.split("'");
                    map.put("command", split[1]);
                    map.put("text01", split[1]);
                }
                else if (line.contains(("var num = '"))) {
                    System.err.println(line);
                    String[] split = line.split("'");
                    map.put("num", split[1]);
                }
                sb.append(line);
                sb.append("\n");
            }
            in.close();
        } catch (Exception ex) {
            System.err.println(ex);
        }
        return sb.toString();
    }

    public static Map<String, String> getPageValue(String pageUrl,String encoding) {
        Map<String, String> map = new HashMap<>(5);
        map.put("command", "");
        map.put("text01", "");
        map.put("num", "");
        try {
            //构建一URL对象
            URL url = new URL(pageUrl);
            //使用openStream得到一输入流并由此构造一个BufferedReader对象
            BufferedReader in = new BufferedReader(new InputStreamReader(url
                    .openStream(), encoding));
            String line;
            //读取www资源
            while ((line = in.readLine()) != null) {
                if (line.contains("var command = '")) {
                    System.err.println(line);
                    String[] split = line.split("'");
                    map.put("command", split[1]);
                    map.put("text01", split[1]);
                }
                else if (line.contains(("var num = '"))) {
                    System.err.println(line);
                    String[] split = line.split("'");
                    map.put("num", split[1]);
                }
            }
            in.close();
        } catch (Exception ex) {
            System.err.println(ex);
        }
        return map;
    }
}