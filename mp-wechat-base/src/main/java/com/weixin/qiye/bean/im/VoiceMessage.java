package com.weixin.qiye.bean.im;

/**
 * Created by fang on 2016/1/11.
 */
public class VoiceMessage extends ChatMessage {
    private Voice voice;

    public VoiceMessage() {
        super("image");
    }

    public Voice getVoice() {
        return voice;
    }

    public void setVoice(Voice voice) {
        this.voice = voice;
    }

    public static Voice newFile(String text){
        return new Voice(text);
    }

    public static class Voice{
        private String media_id;

        public Voice() {

        }
        public Voice(String text) {
            this.media_id = text;
        }

        public String getMedia_id() {
            return media_id;
        }

        public void setMedia_id(String media_id) {
            this.media_id = media_id;
        }
    }

}
