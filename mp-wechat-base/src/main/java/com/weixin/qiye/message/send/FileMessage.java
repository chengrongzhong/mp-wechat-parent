package com.weixin.qiye.message.send;

/**
 * Created by fang on 2016/1/8.
 */
public class FileMessage extends Message {
    private File file;

    public FileMessage() {
        super("file");
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public static File newFile(String media_id) {
        return new File(media_id);
    }

    private static class File{
        private String media_id;

        public File() {

        }
        public File(String media_id) {
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
