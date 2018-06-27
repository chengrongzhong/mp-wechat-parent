package com.spoke.wechat.service;

import com.alibaba.fastjson.JSONArray;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 * Created with IntelliJ IDEA.
 *；
 * @author chengrongzhong on 2018/3/29 15:32
 */
@SpringBootTest
//@RunWith(SpringRunner.class)
public class serviceTest {

    @Test
    public void serviceTest() {
        StringBuffer sb = new StringBuffer();
        sb.append("1");
        sb.append("2");
        System.out.println(sb.toString());
//        String htmls= getWapTextSource("https://m.biqudu.com/14_14721/3431198.html","UTF-8");//2630457
    }


    @Test
    public void fanRen() {
        printPageSource("http://m.biquke.com/bq/0/990/4148603.html","UTF-8");//2630457
    }

    public static void printPageSource(String pageUrl,String encoding) {
        StringBuffer sb = new StringBuffer();
        try {
            //构建一URL对象
            URL url = new URL(pageUrl);
            //使用openStream得到一输入流并由此构造一个BufferedReader对象
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream(), encoding));
            String line;
            //读取www资源
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static String getDownloadImgPageNum(String pageUrl, String encoding) {
        StringBuffer sb = new StringBuffer();
        try {
            //构建一URL对象
            URL url = new URL(pageUrl);
            //使用openStream得到一输入流并由此构造一个BufferedReader对象
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream(), encoding));
            String line;
            //读取www资源
            while ((line = in.readLine()) != null) {
                if (line.contains("eval(function(p,a,c,k,e,d)")) {
                    System.out.println(line);
                    int len = line.length();
                    String imgName = line.substring(len - 55, len - 48);
                    System.out.println(imgName);
                    System.out.println();
                    return imgName;
                }
            }
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    @Test
    public void servicqeTest() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        String startDate = sdf.format(calendar.getTime());
        String endDate = sdf.format(new Date());
        System.out.println(startDate);
        System.out.println(endDate);
    }

    @Test
    public void ja() {
        JSONArray jsonArray = new JSONArray();
        jsonArray.add("1");
        jsonArray.add("1");
        jsonArray.add("1");
        jsonArray.add("1");
        System.out.println(jsonArray.toJSONString());
    }

    public static String getTextSource(String pageUrl,String encoding) {
        StringBuffer sb = new StringBuffer();
        try {
            //构建一URL对象
            URL url = new URL(pageUrl);
            //使用openStream得到一输入流并由此构造一个BufferedReader对象
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream(), encoding));
            String line;
            //读取www资源
            while ((line = in.readLine()) != null) {
                if (line.contains("下一章")) {
                    String[] split = line.split("下一章");
                    for (String str : split) {
                        String substring = str.substring(str.length() - 60, str.length());
                        System.err.println(substring);
                        break;
                    }
                }
                if (line.contains("<h1>")) {
                    sb.append(line);
                    sb.append("\n");
                }
                if (line.contains("<br/><br/>")) {
                    String[] split = line.split("<br/><br/>");
                    for (String str : split) {
                        sb.append(str);
                        sb.append("\n");
                    }
                }

            }
            in.close();
            System.out.println(sb.toString());

        } catch (Exception ex) {
            System.err.println(ex);
        }
        return sb.toString();
    }

    public static String getWapTextSource(String pageUrl,String encoding) {
        StringBuffer sb = new StringBuffer();
        try {
            //构建一URL对象
            URL url = new URL(pageUrl);
            //使用openStream得到一输入流并由此构造一个BufferedReader对象
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream(), encoding));
            String line;
            //读取www资源
            while ((line = in.readLine()) != null) {
                if (line.contains("下一章")) {
                    System.err.println(line);
                }
                if (line.contains("nr_title")) {
                    sb.append(line);
                    sb.append("\n");
                }
                if (line.contains("<br/><br/>")) {
                    String[] split = line.split("<br/><br/>");
                    for (String str : split) {
                        sb.append(str);
                        sb.append("\n");
                    }
                }

            }
            in.close();
            System.out.println(sb.toString());

        } catch (Exception ex) {
            System.err.println(ex);
        }
        return sb.toString();
    }
}
