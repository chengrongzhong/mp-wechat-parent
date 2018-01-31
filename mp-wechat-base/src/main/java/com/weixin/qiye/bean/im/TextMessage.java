package com.weixin.qiye.bean.im;

/**
 * Created by fang on 2016/1/11.
 */
public class TextMessage extends ChatMessage {
    private Text text;

    public TextMessage() {
        super("text");
    }

    public Text getText() {
        return text;
    }

    public void setText(Text text) {
        this.text = text;
    }

    public static Text newText(String text){
        return new Text(text);
    }
    public static class Text{
        private String content;

        public Text() {

        }
        public Text(String text) {
            this.content = text;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }
}
