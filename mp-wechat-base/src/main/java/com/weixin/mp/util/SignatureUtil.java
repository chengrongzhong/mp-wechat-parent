package com.weixin.mp.util;

import java.util.Arrays;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;

import com.weixin.mp.bean.pay.PayFeedback;
import com.weixin.mp.bean.pay.PayNativeInput;
import com.weixin.mp.bean.pay.PayNotify;
import com.weixin.mp.bean.pay.PayWarn;
import com.weixin.mp.bean.paymch.MchPayNotify;

public class SignatureUtil {

	/**
	 * 生成 package 字符串
	 * @param map
	 * @param paternerKey
	 * @return
	 */
	public static String generatePackage(Map<String, String> map,String paternerKey){
		String sign = generateSign(map,paternerKey);
		Map<String,String> tmap = MapUtil.order(map);
		String s2 = MapUtil.mapJoin(tmap,false,true);
		return s2+"&sign="+sign;
	}

	/**
	 * 生成sign MD5 加密 toUpperCase
	 * @param map
	 * @param paternerKey
	 * @return
	 */
	public static String generateSign(Map<String, String> map,String paternerKey){
		Map<String, String> tmap = MapUtil.order(map);
		if(tmap.containsKey("sign")){
			tmap.remove("sign");
		}
		String str = MapUtil.mapJoin(tmap, false, false);
		return DigestUtils.md5Hex(str+"&key="+paternerKey).toUpperCase();
	}

	/**
	 * 生成 paySign
	 * @param map
	 * @param paySignKey
	 * @return
	 */
	public static String generatePaySign(Map<String, String> map,String paySignKey){
		if(paySignKey!=null){
			map.put("appkey", paySignKey);
		}
		Map<String, String> tmap = MapUtil.order(map);
		String str = MapUtil.mapJoin(tmap,true,false);
		return DigestUtils.shaHex(str).toUpperCase();
	}

	/**
	 * 生成事件消息接收签名
	 * @param token
	 * @param timestamp
	 * @param nonce
	 * @return
	 */
	public static String generateEventMessageSignature(String token, String timestamp,String nonce) {
		String[] array = new String[]{token,timestamp,nonce};
		Arrays.sort(array);
		String s = StringUtils.arrayToDelimitedString(array, "");
		return DigestUtils.shaHex(s);
	}
	/**
	 * 生成事件消息接收签名,并判断是否正确签名
	 * @param token
	 * @param timestamp
	 * @param nonce
	 * @return
	 */
	public static boolean generateEventMessageSignature(String token, String timestamp,String nonce,String sign) {
		if (null==sign){
			return false;
		}
		String[] array = new String[]{token,timestamp,nonce};
		Arrays.sort(array);
		String s = StringUtils.arrayToDelimitedString(array, "");
		String str = DigestUtils.shaHex(s);
		return sign.equalsIgnoreCase(str);
	}


	/**
	 * 验证  pay feedback appSignature 签名
	 * @param payFeedback
	 * @param paySignKey 公众号支付请求中用于加密的密钥Key,
	 * 					  可验证商户唯一身份,对应于支付场景中的 appKey 值
	 * @return
	 */
	public static boolean validateAppSignature(PayFeedback payFeedback,String paySignKey) {
		Map<String, String> map = MapUtil.objectToMap(payFeedback,
				"msgtype",
				"appsignature",
				"signmethod",
				"feedbackid",
				"transid",
				"reason",
				"solution",
				"extinfo",
				"picInfo");
		return payFeedback.getAppsignature().equals(generatePaySign(map, paySignKey));
	}


	/**
	 * 验证  pay native appSignature 签名
	 * @param payNativeInput
	 * @param paySignKey 公众号支付请求中用于加密的密钥Key,
	 * 					  可验证商户唯一身份,对应于支付场景中的 appKey 值
	 * @return
	 */
	public static boolean validateAppSignature(PayNativeInput payNativeInput,String paySignKey) {
		Map<String, String> map = MapUtil.objectToMap(payNativeInput, "appsignature","signmethod");
		return payNativeInput.getAppsignature().equals(generatePaySign(map,paySignKey));
	}


	/**
	 * 验证  pay notify appSignature 签名
	 * @param payNotify
	 * @param paySignKey 公众号支付请求中用于加密的密钥Key,
	 * 					  可验证商户唯一身份,对应于支付场景中的 appKey 值
	 * @return
	 */
	public static boolean validateAppSignature(PayNotify payNotify,String paySignKey) {
		Map<String, String> map = MapUtil.objectToMap(payNotify, "appsignature","signmethod");
		return payNotify.getAppsignature().equals(generatePaySign(map,paySignKey));
	}

	/**
	 * 验证  pay warn appSignature 签名
	 * @param payWarn
	 * @param paySignKey 公众号支付请求中用于加密的密钥Key,
	 * 					  可验证商户唯一身份,对应于支付场景中的 appKey 值
	 * @return
	 */
	public static boolean validateAppSignature(PayWarn payWarn,String paySignKey) {
		Map<String, String> map = MapUtil.objectToMap(payWarn, "appsignature","signmethod");
		return payWarn.getAppsignature().equals(generatePaySign(map,paySignKey));
	}

	/**
	 * 验证 mch pay notify sign 签名
	 * @param mchPayNotify
	 * @param key mch key
	 * @return
	 */
	public static boolean validateAppSignature(MchPayNotify mchPayNotify,String key) {
		Map<String, String> map = MapUtil.objectToMap(mchPayNotify);
		return mchPayNotify.getSign().equals(generateSign(map, key));
	}

//	public static void main(String[] args){
//		//用于生成token
//		long t = System.currentTimeMillis();
//		String str = "weixin_token"+t;
//		System.out.println(str);
//		System.out.println(DigestUtils.md5Hex(str).toLowerCase());
//
//		//用户测试接口是否正确
//		String token = "ilbnfq1415374811";
//		String timestamp =  "1445153181";
//		String nonce = "44680403";
//		String sign = generateEventMessageSignature(token,timestamp,nonce);
//		//4daeb2aaa307d11036a867aa6135e0d94a36b0a5
//		//4daeb2aaa307d11036a867aa6135e0d94a36b0a5
//		System.out.println(String.format("signature=%s&timestamp=%s&nonce=%s&echostr=test",sign,timestamp,nonce));
//		System.out.println(String.format("http://127.0.0.1:8889/weixin/api/receiver/gh_0bee080dd83d.wx?signature=%s&timestamp=%s&nonce=%s&echostr=test",sign,timestamp,nonce));
//	}
}
