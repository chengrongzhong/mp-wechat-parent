package com.weixin.qiye.api;

import com.weixin.common.client.LocalHttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;

import java.util.Map;

/**
 * Created by ${chengrz} on 2016/5/24 0024.
 */
public class DealerAPI extends BaseAPI {

    public static <T> T get(Class<T> clazz, String url, Map<String, String> map) {
        RequestConfig.Builder requestConfigBuilder = RequestConfig.custom();
        requestConfigBuilder = requestConfigBuilder.setConnectTimeout(20 * 1000);
        requestConfigBuilder = requestConfigBuilder.setConnectionRequestTimeout(10 * 1000);

        RequestBuilder requestBuilder = RequestBuilder.get();
        requestBuilder.setConfig(requestConfigBuilder.build());
        requestBuilder.setUri(url);

        for(Map.Entry<String, String> entry : map.entrySet()) {
            requestBuilder.addParameter(entry.getKey(), entry.getValue());
        }
        HttpUriRequest httpUriRequest = requestBuilder.build();
        return LocalHttpClient.executeJsonResult(httpUriRequest, clazz, "UTF-8");
    }
}
