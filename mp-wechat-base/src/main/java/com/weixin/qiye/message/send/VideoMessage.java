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
public class VideoMessage extends Message {
    private Video video;
    public VideoMessage() {
        super("video");
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public static Video newVideo(String media_id, String title, String desc) {
        return new Video(media_id,title,desc);
    }

    private static class Video{
        private String media_id;

        private String title;

        private String description;

        public Video() {

        }
        public Video(String media_id, String title, String desc) {
            this.media_id = media_id;
            this.title = title;
            this.description = desc;
        }

        public String getMedia_id() {
            return media_id;
        }

        public void setMedia_id(String media_id) {
            this.media_id = media_id;
        }

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
    }
}
