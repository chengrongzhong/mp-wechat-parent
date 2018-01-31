package com.qq.api;

import org.apache.http.Header;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHeader;

import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

/**
 * 基础API
 * Created by sdyang on 2016/3/25.
 */
public abstract class BaseAPI {
    protected static final String BASE_URI = "https://api.mp.qq.com";
    protected static final String ACCESS_TOKEN = "access_token";
    protected static final String CHARSET = "utf-8";

    protected static Header jsonHeader = new BasicHeader(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.toString());
    protected static Header xmlHeader = new BasicHeader(HttpHeaders.CONTENT_TYPE,ContentType.APPLICATION_XML.toString());

    private static SimpleDateFormat formater = new SimpleDateFormat("yyyyMMddHHmmss");

    public static String create_nonce_str(){
        String uuid = UUID.randomUUID().toString();
        uuid = uuid.replace("-", "");
        return uuid;
    }

    public static String create_timestamp() {
        return formater.format(new Date());
    }
    public static String create_timestamp(long time){
        return formater.format(new Date(time));
    }

    public HttpUriRequest newGetRequest(String uri,Map<String,String> params){
        RequestBuilder req = RequestBuilder.get()
                .setUri(BASE_URI + uri);
        for(Map.Entry<String,String> item:params.entrySet()){
            req.addParameter(item.getKey(), item.getValue());
        }
        return req.build();
    }

    public HttpUriRequest newPostRequest(String uri,Map<String,String> params,String json){
        RequestBuilder req = RequestBuilder.post()
                .setUri(BASE_URI + uri);
        for(Map.Entry<String,String> item:params.entrySet()){
            req.addParameter(item.getKey(), item.getValue());
        }
        if(json!=null){
            req.setEntity(new StringEntity(json, Charset.forName(CHARSET)));
        }
        return req.build();
    }
}