package com.weixin.qiye.message.send;

import com.weixin.mp.bean.AdaptorCDATA;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Map;

/**
 * Created by fang on 2016/1/8.
 */
public class TextMessage extends Message {
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

    public static Text newText(String content){
        return new Text(content);
    }
    public static class Text{
        private String content;

        public Text() {
        }

        public Text(String content) {
            this.content = content;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }
}
