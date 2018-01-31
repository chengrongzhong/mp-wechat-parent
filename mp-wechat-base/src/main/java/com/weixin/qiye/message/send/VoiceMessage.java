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
public class VoiceMessage extends Message {
    private Voice voice;
    public VoiceMessage() {
        super("voice");
    }

    public Voice getVoice() {
        return voice;
    }

    public void setVoice(Voice voice) {
        this.voice = voice;
    }

    public static Voice newVoice(String media_id) {
        return new Voice(media_id);
    }

    private static class Voice{
        private String media_id;

        public Voice() {

        }
        public Voice(String media_id) {
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
