package com.spoke.wechat.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Created with IntelliJ IDEA.
 *
 * @author chengrongzhong on 2018/3/29 15:32
 */
@SpringBootTest
//@RunWith(SpringRunner.class)
public class serviceTest {

    @Test
    public void serviceTest() {
        String htmls= getTextSource("https://www.biqudu.com/35_35213/2674399.html","UTF-8");//2630457
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
            String next = "";
            while ((line = in.readLine()) != null) {
                if (line.contains("<br/><br/>")) {
                    String[] split = line.split("<br/><br/>");
                    for (String str : split) {
                        sb.append(str);
                        sb.append("\n");
                    }
                }
                if (line.contains("下一章")) {
                    next = line;
                }
            }
            in.close();
            System.out.println(sb.toString());
            System.err.println(next);

        } catch (Exception ex) {
            System.err.println(ex);
        }
        return sb.toString();
    }

}
