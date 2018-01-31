package com.weixin.qiye.api;

import com.weixin.common.bean.BaseResult;
import com.weixin.mp.bean.*;
import com.weixin.common.client.LocalHttpClient;
import com.weixin.mp.util.JsonUtil;
import com.weixin.qiye.bean.material.MaterialReq;
import com.weixin.qiye.bean.material.MediaCountResult;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

/**
 * 素材文件管理
 * Created by fang on 2015/12/31.
 */
public  class MaterialAPI extends BaseAPI {

    /**
     上传临时素材文件

     用于上传图片、语音、视频等媒体资源文件以及普通文件（如doc，ppt），接口返回媒体资源标识ID：media_id。请注意，media_id是可复用的，同一个media_id可用于消息的多次发送(3天内有效)。

     请求说明

     Https请求方式: POST

     https://qyapi.weixin.qq.com/cgi-bin/media/upload?access_token=ACCESS_TOKEN&type=TYPE
     */
    public static Media uploadMaterialByTemporary(String access_token,MediaType mediaType,File media){
        HttpPost httpPost = new HttpPost(MEDIA_URI + "/cgi-bin/media/upload");
        FileBody bin = new FileBody(media);
        MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create()
             .addPart("media", bin);
        HttpEntity reqEntity = multipartEntityBuilder.addTextBody("access_token", access_token)
             .addTextBody("type", mediaType.uploadType())
             .build();
        httpPost.setEntity(reqEntity);
        return LocalHttpClient.executeJsonResult(httpPost, Media.class);
    }
    /**
     获取临时素材文件

     通过media_id获取图片、语音、视频等文件，协议和普通的http文件下载完全相同。

     请求说明

     Https请求方式: GET

     https://qyapi.weixin.qq.com/cgi-bin/media/get?access_token=ACCESS_TOKEN&media_id=MEDIA_ID
     */
    public static byte[] getMaterialByTemporary(String access_token,String media_id){
        HttpUriRequest httpUriRequest = RequestBuilder.get()
                .setUri(BASE_URI+"/cgi-bin/media/get")
                .addParameter(ACCESS_TOKEN, access_token)
                .addParameter("media_id", media_id)
                .build();
        CloseableHttpResponse httpResponse = LocalHttpClient.execute(httpUriRequest);
        try {
            return EntityUtils.toByteArray(httpResponse.getEntity());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                httpResponse.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     上传永久图文素材

     用于上传图文消息素材，接口返回素材资源标识ID：media_id。media_id是可复用的，同一个media_id可用于消息的多次发送。使用永久图文素材ID发送消息参见：mpnews消息发送说明

     请求说明

     Https请求方式: POST

     https://qyapi.weixin.qq.com/cgi-bin/material/add_mpnews?access_token=ACCESS_TOKEN
     */
    public static Media addMaterial(String access_token,String agentid,List<Article> articles){
        String str = JsonUtil.toJSONString(articles);
        String messageJson = "{\"agentid\":"+agentid+",\"mpnews\":{ \"articles\":"+str+"}}";
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setHeader(jsonHeader)
                .setUri(BASE_URI+"/cgi-bin/material/add_mpnews")
                .addParameter("access_token", access_token)
                .setEntity(new StringEntity(messageJson, Charset.forName("utf-8")))
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest,Media.class);
    }

    /**
     上传其他类型永久素材

     用于上传图片、语音、视频等媒体资源文件以及普通文件（如doc，ppt），接口返回素材资源标识ID：media_id。media_id是可复用的，同一个media_id可用于消息的多次发送。

     请求说明

     Https请求方式: POST

     https://qyapi.weixin.qq.com/cgi-bin/material/add_material?agentid=AGENTID&type=TYPE&access_token=ACCESS_TOKEN
     */
    public static Media uploadMaterialByOther(String access_token,String agentid,MediaType mediaType,File media){
        HttpPost httpPost = new HttpPost(MEDIA_URI + "/cgi-bin/material/add_material");
        FileBody bin = new FileBody(media);
        MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create()
                .addPart("media", bin);
        HttpEntity reqEntity = multipartEntityBuilder.addTextBody("access_token", access_token)
                .addTextBody("type", mediaType.uploadType())
                .addTextBody("agentid", agentid)
                .build();
        httpPost.setEntity(reqEntity);
        return LocalHttpClient.executeJsonResult(httpPost, Media.class);
    }


    /**
     获取永久素材

     通过media_id获取上传的图文消息、图片、语音、文件、视频素材。

     请求说明

     Https请求方式: GET
     http://qydev.weixin.qq.com/wiki/index.php?title=%E8%8E%B7%E5%8F%96%E6%B0%B8%E4%B9%85%E7%B4%A0%E6%9D%90
     https://qyapi.weixin.qq.com/cgi-bin/material/get?access_token=ACCESS_TOKEN&media_id=MEDIA_ID&agentid=AGENTID
     */
    public static byte[] getMaterial(String access_token,String agentid,String media_id){
        HttpUriRequest httpUriRequest = RequestBuilder.get()
                .setUri(BASE_URI + "/cgi-bin/material/get")
                .addParameter("access_token", access_token)
                .addParameter("media_id", media_id)
                .addParameter("agentid", agentid)
                .build();
        HttpResponse httpResponse = LocalHttpClient.execute(httpUriRequest);
        try {//TODO不同素材类型返回结构不一样,需要处理
            return EntityUtils.toByteArray(httpResponse.getEntity());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     删除永久素材

     通过media_id删除上传的图文消息、图片、语音、文件、视频素材。

     请求说明

     Https请求方式: GET

     https://qyapi.weixin.qq.com/cgi-bin/material/del?access_token=ACCESS_TOKEN&agentid=AGENTID&media_id=MEDIA_ID
     */
    public static BaseResult delMaterial(String access_token, String agentid, String media_id){
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setHeader(jsonHeader)
                .setUri(BASE_URI + "/cgi-bin/material/del")
                .addParameter("access_token", access_token)
                .addParameter("agentid", agentid)
                .addParameter("media_id", media_id)
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest,BaseResult.class);
    }
    /**
     修改永久图文素材

     通过本接口对永久图文素材进行修改。

     请求说明

     Https请求方式: POST

     https://qyapi.weixin.qq.com/cgi-bin/material/update_mpnews?access_token=ACCESS_TOKEN
     */
    public static BaseResult updateMaterial(String access_token,String agentid,String media_id,List<Article> articles){
        String str = JsonUtil.toJSONString(articles);
        String messageJson = "{\"agentid\":"+agentid+",\"media_id\":\""+media_id+"\",\"mpnews\":{ \"articles\":"+str+"}}";
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setHeader(jsonHeader)
                .setUri(BASE_URI + "/cgi-bin/material/update_mpnews")
                .addParameter("access_token", access_token)
                .setEntity(new StringEntity(messageJson, Charset.forName("utf-8")))
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest,BaseResult.class);
    }
    /**

     获取素材总数

     本接口可以获取应用素材总数以及每种类型素材的数目。

     请求说明

     Https请求方式: GET

     https://qyapi.weixin.qq.com/cgi-bin/material/get_count?access_token=ACCESS_TOKEN&agentid=AGENTID
     */
    public static MediaCountResult getMaterialCount(String access_token,String agentid){
        HttpUriRequest httpUriRequest = RequestBuilder.get()
                .setUri(BASE_URI + "/cgi-bin/material/get_count")
                .addParameter("access_token", access_token)
                .addParameter("agentid ", agentid)
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest, MediaCountResult.class);
    }
    /**

     获取素材列表

     本接口可以获取应用素材素材列表。

     请求说明

     Https请求方式: POST

     https://qyapi.weixin.qq.com/cgi-bin/material/batchget?access_token=ACCESS_TOKEN
     */
    /**

     返回说明

     若为图片，文件，视频，音频则返回json格式如下

     {
     "errcode": 0,
     "errmsg": "ok",
     "type": "image",
     "total_count": 12,
     "item_count": 1,
     "itemlist": [
     {
     "media_id": "2qN9QW-6HI3-AXuvAMi0vYQTyAm7k0Vgiuf7t5Kl4hjOwhYGwY",
     "filename": "test01.png",
     "update_time": 1434686658
     }
     ]
     }

     永久图文消息素材列表的返回如下

     {
     "errcode":0,
     "errmsg":"ok",
     "type":"mpnews",
     "total_count":20,
     "item_count":3,
     "itemlist": [
     {
     "media_id": "2-G6nrLmr5EC3MMb_-zK1dDdzmd0p7cNliYu",
     "articles": [
     {
     "title": "Title01",
     "thumb_media_id": "2-G6nrLmr5EC3MMb_-zK1dDdzmd0p7cNliYu9V5w7o8K0",
     "author": "zs",
     "content_source_url": "",
     "digest": "airticle01",
     "show_cover_pic": "0"
     },
     //可能有多篇文章
     ],
     "update_time": "1380000000"
     },
     //可能有多个图文消息结构
     ]
     }
     */
    public static MediaCountResult getMaterialList(String access_token,MaterialReq req){
        String json = JsonUtil.toJSONString(req);
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setUri(BASE_URI + "/cgi-bin/material/batchget")
                .addParameter("access_token", access_token)
                .setEntity(new StringEntity(json, Charset.forName("utf-8")))
                .build();
        //TODO:不完善,还需要补充
        return LocalHttpClient.executeJsonResult(httpUriRequest, MediaCountResult.class);
    }
}
