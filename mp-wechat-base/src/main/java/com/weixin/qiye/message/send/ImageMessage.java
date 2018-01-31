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
public class ImageMessage extends Message {
    private Image image;
    public ImageMessage() {
        super("image");
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public static Image newImage(String media_id) {
        return new Image(media_id);
    }

    private static class Image{
        private String media_id;

        public Image() {

        }
        public Image(String media_id) {
            this.media_id = media_id;
        }

        public String getMedia_id() {
            return media_id;
        }

        public void setMedia_id(String media_id) {
            this.media_id = media_id;
        }
    }
}
