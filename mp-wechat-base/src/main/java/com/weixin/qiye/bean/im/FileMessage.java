package com.weixin.qiye.bean.im;

/**
 * Created by fang on 2016/1/11.
 */
public class FileMessage extends ChatMessage {
    private File file;

    public FileMessage() {
        super("image");
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public static File newFile(String text){
        return new File(text);
    }

    public static class File{
        private String media_id;

        public File() {

        }
        public File(String text) {
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
