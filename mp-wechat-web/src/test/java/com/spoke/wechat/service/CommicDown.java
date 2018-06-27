package com.spoke.wechat.service;

import com.spoke.wechat.utils.HttpDownload;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Created with IntelliJ IDEA.
 *
 * @author chengrongzhong on 2018/6/27 11:20
 */
public class CommicDown {

    // 可以用于下载http://hncircle.com收费漫画
    // 目录http://hncircle.com/1PRQ95/comic/6352
    @Test
    public void hncircle() {
        String downPath = "E:\\tcl-work\\github\\studyEveryThing\\mp-wechat-parent\\mp-wechat-web\\src\\main\\resources\\download\\";
//        HttpClientUtils.getInstance().download("http://jhpgq.cn/p_1111940", "E:\\tcl-work\\github\\studyEveryThing\\mp-wechat-parent\\mp-wechat-web\\src\\main\\resources\\download\\" + "p_1111940.png");
        String source = "http://jsmlsyz.com/1PRQ95/comic/6352";

        int[] list = {
                112970};

        for (int so : list) {
            String onepage = getImageStart("http://hncircle.com/view/6352/" + so,"UTF-8");// 第二页
            if (onepage == null) {
                System.out.println("==============" + so);
                continue;
            }
            String pageNum = onepage;
            for (int i = 0; i < 35; i ++) {
                int page = Integer.parseInt(pageNum);
                page = page + i;
                String url = "http://jhpgq.cn/p_" + page;
                HttpDownload.download(url, downPath + page + ".jpg");
            }
        }
    }

    @Test
    public void hncircle2() {
        String downPath = "E:\\tcl-work\\github\\studyEveryThing\\mp-wechat-parent\\mp-wechat-web\\src\\main\\resources\\download\\";
//        HttpClientUtils.getInstance().download("http://jhpgq.cn/p_1111940", "E:\\tcl-work\\github\\studyEveryThing\\mp-wechat-parent\\mp-wechat-web\\src\\main\\resources\\download\\" + "p_1111940.png");

        String pageNum = "1118443";
        for (int i = 0; i < 35; i ++) {
            int page = Integer.parseInt(pageNum);
            page = page + i;
            String url = "http://jhpgq.cn/p_" + page;
            HttpDownload.download(url, downPath + page + ".jpg");
        }
    }

    public static String getImageStart(String pageUrl,String encoding) {
        StringBuffer sb = new StringBuffer();
        try {
            //构建一URL对象
            URL url = new URL(pageUrl);
            //使用openStream得到一输入流并由此构造一个BufferedReader对象
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream(), encoding));
            String line;
            //读取www资源
            String key = "http:\\/\\/jhpgq.cn\\/p_";
            while ((line = in.readLine()) != null) {
                if (line.contains(key)) {
                    String[] split = line.split("\"pages\":");
                    String number = split[1].substring(23, 30);
                    return number;
                }
            }
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

}
