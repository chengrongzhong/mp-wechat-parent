package com.weixin.mp.api;

import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;

import com.weixin.common.bean.Token;
import com.weixin.common.client.LocalHttpClient;

public class TokenAPI extends BaseAPI{

	/**
	 * 获取access_token
	 * @param appid
	 * @param secret
	 * @return
	 */
	public static Token token(String appid, String secret){
		HttpUriRequest httpUriRequest = RequestBuilder.get()
				.setUri(BASE_URI + "/cgi-bin/token")
				.addParameter("grant_type","client_credential")
				.addParameter("appid", appid)
				.addParameter("secret", secret)
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,Token.class);
	}

	public static void main(String[] args) {
		String appid = "wxdd7eeb6c8ea824c7";
		String secret = "02ebabfcb6697b5a7912e8e3d12ee0da";

		HttpUriRequest httpUriRequest = RequestBuilder.get()
				.setUri(BASE_URI + "/cgi-bin/token")
				.addParameter("grant_type","client_credential")
				.addParameter("appid", appid)
				.addParameter("secret", secret)
				.build();
		Token token = LocalHttpClient.executeJsonResult(httpUriRequest, Token.class);
		System.out.println(token.getAccess_token());
		System.err.println(token.getExpires_in());

	}

}
