package com.weixin.qiye.api;

import org.apache.http.Header;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHeader;

import java.nio.charset.Charset;
import java.util.Map;

/**
 * Created by fang on 2015/12/31.
 */
public class BaseAPI {
    protected static final String ChartSet = "gbk";//字符编码
    protected static final String BASE_URI = "https://qyapi.weixin.qq.com";
    protected static final String MEDIA_URI = "https://qyapi.weixin.qq.com";
    protected static final String ACCESS_TOKEN = "access_token";

    protected static Header jsonHeader = new BasicHeader(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.toString());
    protected static Header xmlHeader = new BasicHeader(HttpHeaders.CONTENT_TYPE,ContentType.APPLICATION_XML.toString());


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
            req.setEntity(new StringEntity(json, Charset.forName("utf-8")));
        }
        return req.build();
    }
}
