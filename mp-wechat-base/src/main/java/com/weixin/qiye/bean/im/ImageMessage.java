package com.weixin.qiye.bean.im;

/**
 * Created by fang on 2016/1/11.
 */
public class ImageMessage extends ChatMessage {
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

    public static Image newImage(String text){
        return new Image(text);
    }
    public static class Image{
        private String media_id;

        public Image() {

        }
        public Image(String text) {
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
