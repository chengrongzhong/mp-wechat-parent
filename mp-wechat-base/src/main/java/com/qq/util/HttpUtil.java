package com.qq.util;

import java.io.*;

/**
 * Created by sdyang on 2016/4/1.
 */
public class HttpUtil {

    /**
     *
     * @param outputStream
     * @param text
     * @return
     */
    public static boolean outputStreamWrite(OutputStream outputStream,String text){
        try {
            outputStream.write(text.getBytes("utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 将inputStream转换为String
     * @param inputStream
     * @return
     */
    public  static String inputStreamToString(InputStream inputStream) {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
            String content;
            while ((content = reader.readLine()) != null) {
                sb.append(content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
}
