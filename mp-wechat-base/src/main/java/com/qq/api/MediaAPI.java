package com.qq.api;

import com.qq.bean.BaseResult;
import com.qq.bean.media.*;
import com.weixin.common.client.LocalHttpClient;
import com.weixin.mp.util.JsonUtil;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;

import java.io.File;
import java.nio.charset.Charset;
import java.util.List;

/**
 * 上传临时素材  https://api.mp.qq.com/cgi-bin/media/upload?access_token=ACCESS_TOKEN&type=TYPE
 * <p>
 * 获取临时素材  https://api.mp.qq.com/cgi-bin/media/get?access_token=ACCESS_TOKEN&media_id=MEDIA_ID
 * <p>
 * 新增永久素材  https://api.mp.qq.com/cgi-bin/material/add_material?access_token=ACCESS_TOKEN
 * <p>
 * 获取永久素材  https://api.mp.qq.com/cgi-bin/material/get_material?access_token=ACCESS_TOKEN
 * <p>
 * 删除永久素材  https://api.mp.qq.com/cgi-bin/material/del_material?access_token=ACCESS_TOKEN
 * <p>
 * 获取永久素材总数  https://api.mp.qq.com/cgi-bin/material/get_materialcount?access_token=ACCESS_TOKEN
 * <p>
 * Created by sdyang on 2016/3/29.
 */
public class MediaAPI extends BaseAPI {

    /**
     * 新增临时图片
     * 媒体文件在后台保存时间为3天，即3天后media_id失效。
     *
     * @param access_token
     * @param mediaType
     * @param media        多媒体文件有格式和大小限制，如下：
     *                     图片（image）: 2M，支持bmp/png/jpeg/jpg/gif格式
     *                     语音（voice）：2M，播放长度不超过60s，支持AMR\MP3格式
     *                     视频（video）：10MB，支持MP4格式
     *                     缩略图（thumb）：64KB，支持JPG格式
     * @return
     */
    public static Media uploadImage(String access_token, MediaType mediaType, File media) {
        HttpPost httpPost = new HttpPost(BASE_URI + "/cgi-bin/media/upload?" + ACCESS_TOKEN + "=" + access_token + "&type=" + mediaType.uploadType());
        FileBody fileBody = new FileBody(media, ContentType.create("image/jpg"),media.getName());
        HttpEntity reqEntity = MultipartEntityBuilder.create()
                .addPart("media", fileBody)
                .build();
        httpPost.setEntity(reqEntity);
        return LocalHttpClient.executeJsonResult(httpPost, Media.class);
    }

    /**
     * 新增其他类型永久素材
     *
     * @param access_token
     * @param mediaType
     * @param media        多媒体文件有格式和大小限制，如下：
     *                     图片（image）: 2M，支持bmp/png/jpeg/jpg/gif格式
     *                     语音（voice）：5M，播放长度不超过60s，支持AMR\MP3格式
     *                     视频（video）：10MB，支持MP4格式
     *                     缩略图（thumb）：64KB，支持JPG格式
     * @param description  视频文件类型额外字段，其它类型不用添加
     * @return
     */
    public static Media materialAdd_material(String access_token, MediaType mediaType, File media, Description description) {
        HttpPost httpPost = new HttpPost(BASE_URI + "/cgi-bin/material/add_material?" + ACCESS_TOKEN + "=" + access_token + "&type=" + mediaType.uploadType());
        FileBody bin = new FileBody(media, ContentType.create(mediaType.contentType()),media.getName());
        MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create()
                .addPart("media", bin);
        if (description != null) {
            multipartEntityBuilder.addTextBody("description", JsonUtil.toJSONString(description));
        }
        HttpEntity reqEntity = multipartEntityBuilder.build();
        httpPost.setEntity(reqEntity);
        return LocalHttpClient.executeJsonResult(httpPost, Media.class);
    }

    /**
     * 获取永久素材总数
     * <p>
     * 图片和图文消息素材（包括单图文和多图文）的总数上限为5000，其他素材的总数上限为1000
     *
     * @param access_token
     * @return
     */
    public static MediaCount materialCount(String access_token) {
        HttpUriRequest httpUriRequest = RequestBuilder.get()
                .setUri(BASE_URI + "/cgi-bin/material/get_materialcount")
                .addParameter(ACCESS_TOKEN, access_token)
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest, MediaCount.class);
    }

    /**
     * 获取临时素材
     * 媒体文件在后台保存时间为3天，即3天后media_id失效。
     *
     * @param access_token
     * @param media_id     媒体文件ID
     * @return
     */
    public static Media mediaGet(String access_token, String media_id) {
        HttpUriRequest httpUriRequest = RequestBuilder.get()
                .setUri(BASE_URI + "/cgi-bin/media/get")
                .addParameter(ACCESS_TOKEN, access_token)
                .addParameter("media", media_id)
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest, Media.class);
    }

    /**
     * 获取永久素材
     *
     * @param access_token
     * @param media_id     媒体文件ID
     * @return
     */
    public static Material materialGet(String access_token, String media_id) {
//        String materialJson = String.format("{\"media_id\":\"%1$s\"}", media_id);
//        HttpUriRequest httpUriRequest = RequestBuilder.post()
//                .setHeader(jsonHeader)
//                .setUri(BASE_URI + "/cgi-bin/material/get_material")
//                .addParameter(ACCESS_TOKEN, access_token)
//                .setEntity(new StringEntity(materialJson, Charset.forName("utf-8")))
//                .build();
//        return LocalHttpClient.executeJsonResult(httpUriRequest, Material.class);
//
//
        HttpPost httpPost = new HttpPost(BASE_URI + "/cgi-bin/material/get_material?" + ACCESS_TOKEN + "=" + access_token);
        HttpEntity reqEntity = MultipartEntityBuilder.create()
                .addTextBody("media_id", media_id)
                .build();
        httpPost.setEntity(reqEntity);
        return LocalHttpClient.executeJsonResult(httpPost, Material.class);

    }

    /**
     * 删除永久素材
     *
     * @param access_token
     * @param media_id     媒体文件ID
     * @return
     */
    public static BaseResult materialDel(String access_token, String media_id) {
        String materialJson = String.format("{\"media_id\":%1$s}", media_id);
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setHeader(jsonHeader)
                .setUri(BASE_URI + "/cgi-bin/material/del_material")
                .addParameter(ACCESS_TOKEN, access_token)
                .setEntity(new StringEntity(materialJson, Charset.forName("utf-8")))
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest, BaseResult.class);
    }

    /**
     * 上传图文消息素材(新闻)
     *
     * @param access_token
     * @return
     */
    public static Media uploadNews(String access_token, List<Material> articles) {
        String messageJson = JsonUtil.toJSONString(articles);
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setHeader(jsonHeader)
                .setUri(BASE_URI + "/cgi-bin/media/uploadnews")
                .addParameter(ACCESS_TOKEN, access_token)
                .setEntity(new StringEntity(messageJson, Charset.forName(CHARSET)))
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest, Media.class);
    }
}
