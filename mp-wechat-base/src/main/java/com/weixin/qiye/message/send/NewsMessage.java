package com.weixin.qiye.message.send;

import java.util.List;

/**
 * Created by fang on 2016/1/8.
 */
public class NewsMessage extends Message {
    private News news;
    public NewsMessage() {
        super("news");
    }

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }

    public static News newNews(List<Article> list) {
        return new News(list);
    }

    public static Article newArticle(String title,String desc,String url,String picUrl){
        Article article = new Article();
        article.setTitle(title);
        article.setDescription(desc);
        article.setUrl(url);
        article.setPicurl(picUrl);
        return article;
    }

    private static class News{
        private List<Article> articles;

        public News(List<Article> list) {
            this.articles = list;
        }

        public List<Article> getArticles() {
            return articles;
        }

        public void setArticles(List<Article> articles) {
            this.articles = articles;
        }
    }

    public static class Article{
        private String title;
        private String description;
        private String url;
        private String picurl;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getPicurl() {
            return picurl;
        }

        public void setPicurl(String picurl) {
            this.picurl = picurl;
        }
    }
}
