package com.weixin.qiye.message.send;

import com.weixin.mp.bean.Article;

import java.util.List;

/**
 * 注：mpnews消息与news消息类似，不同的是图文消息内容存储在微信后台，并且支持保密选项。每个应用每天最多可以发送100次。
 * Created by fang on 2016/1/8.
 */
public class MpnewsMessage extends Message {
    private Mpnews mpnews;
    public MpnewsMessage() {
        super("mpnews");
    }

    public Mpnews getMpnews() {
        return mpnews;
    }

    public void setMpnews(Mpnews mpnews) {
        this.mpnews = mpnews;
    }

    public static Mpnews newNews(List<Article> list){
        return new Mpnews(list);
    }
    private static class Mpnews{
        private List<Article> articles;

        public Mpnews() {

        }
        public Mpnews(List<Article> list) {
            this.articles = list;
        }

        public List<Article> getArticles() {
            return articles;
        }

        public void setArticles(List<Article> articles) {
            this.articles = articles;
        }
    }
}
