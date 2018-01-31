package com.weixin.qiye.test;

import com.weixin.mp.bean.Article;
import com.weixin.qiye.api.SendMsgAPI;
import com.weixin.qiye.bean.SendResult;
import com.weixin.qiye.message.send.NewsMessage;
import com.weixin.qiye.message.send.SendMessageBuilder;
import com.weixin.qiye.message.send.TextMessage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sdyang on 2016/4/21.
 */
public class SendMessageTest {

    private static String  accessToken = "z3JDdxwGMNAbkHiRtfU8lTC6l7waJCZAKd--zXKJk1Zp0Ey2AYoZudYbxYHsR8F9";


    public static void main(String[] args){
        SendMessageBuilder builder = new SendMessageBuilder();

        //发送文本信息
//        TextMessage message = builder.newTextMessage(new String[]{"sdyang"}, new String[]{}, new String[]{}, 8, false, "测试");
//        SendResult result = SendMsgAPI.sendMsg(accessToken,message);

        List<NewsMessage.Article> list = new ArrayList<NewsMessage.Article>();
        NewsMessage.Article article = NewsMessage.newArticle("测试","dec","http://www.baidu.com","");
        list.add(article);
        NewsMessage message =builder.newNewsMessage(new String[]{}, new String[]{"19"}, new String[]{}, 8, false, list);
        SendResult result = SendMsgAPI.sendMsg(accessToken,message);

        if(result.isSuccess()){
            System.out.println("success");
        }else{
            System.out.println(result.getErrmsg());
        }

    }
}
