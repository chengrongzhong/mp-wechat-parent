package com.weixin.mp.api;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;

import com.weixin.mp.bean.paymch.Closeorder;
import com.weixin.mp.bean.paymch.DownloadbillResult;
import com.weixin.mp.bean.paymch.MchBaseResult;
import com.weixin.mp.bean.paymch.MchDownloadbill;
import com.weixin.mp.bean.paymch.MchOrderInfoResult;
import com.weixin.mp.bean.paymch.MchOrderquery;
import com.weixin.mp.bean.paymch.MchReverse;
import com.weixin.mp.bean.paymch.MchReverseResult;
import com.weixin.mp.bean.paymch.MchShorturl;
import com.weixin.mp.bean.paymch.MchShorturlResult;
import com.weixin.mp.bean.paymch.Micropay;
import com.weixin.mp.bean.paymch.MicropayResult;
import com.weixin.mp.bean.paymch.QueryCoupon;
import com.weixin.mp.bean.paymch.QueryCouponResult;
import com.weixin.mp.bean.paymch.QueryCouponStock;
import com.weixin.mp.bean.paymch.QueryCouponStockResult;
import com.weixin.mp.bean.paymch.Refundquery;
import com.weixin.mp.bean.paymch.RefundqueryResult;
import com.weixin.mp.bean.paymch.Report;
import com.weixin.mp.bean.paymch.SecapiPayRefund;
import com.weixin.mp.bean.paymch.SecapiPayRefundResult;
import com.weixin.mp.bean.paymch.SendCoupon;
import com.weixin.mp.bean.paymch.SendCouponResult;
import com.weixin.mp.bean.paymch.Sendgroupredpack;
import com.weixin.mp.bean.paymch.Sendredpack;
import com.weixin.mp.bean.paymch.SendredpackResult;
import com.weixin.mp.bean.paymch.Transfers;
import com.weixin.mp.bean.paymch.TransfersResult;
import com.weixin.mp.bean.paymch.Unifiedorder;
import com.weixin.mp.bean.paymch.UnifiedorderResult;
import com.weixin.common.client.LocalHttpClient;
import com.weixin.mp.util.MapUtil;
import com.weixin.mp.util.SignatureUtil;
import com.weixin.mp.util.XMLConverUtil;

/**
 * https://pay.weixin.qq.com/wiki/doc/api/jsapi.php?chapter=9_1
 * 微信支付 基于V3.X 版本
 * @author Yi
 *
 */
public class PayMchAPI extends BaseAPI{

	public static Unifiedorder newUnifiedorder(String appid,String mchid,String body,String out_trade_no,int total_fee,String spbill_create_ip,String notify_url,String openid){

		String nonce_str = create_nonce_str();
		String sign = null;//这个参数在加密后赋值,这里不动
		String detail = null;//可不填
		String attach = null;//可不填
		String time_start = create_timestamp();
		String time_expire = create_timestamp(System.currentTimeMillis()+30*60*1000);//30分钟
		//商品标记，代金券或立减优惠功能的参数，说明详见代金券或立减优惠
		String goods_tag = null;
		String product_id = null;
		Unifiedorder uni = new Unifiedorder();
		uni.setAppid(appid);
		uni.setMch_id(mchid);
		uni.setDevice_info("WEB");
		//随机字符串，不长于32位。推荐随机数生成算法
		//https://pay.weixin.qq.com/wiki/doc/api/jsapi.php?chapter=4_3
		uni.setNonce_str(nonce_str);
		//签名，详见签名生成算法
		//https://pay.weixin.qq.com/wiki/doc/api/jsapi.php?chapter=4_3
		uni.setSign(sign);
		uni.setBody(body);
		uni.setDetail(detail);
		uni.setAttach(attach);
		uni.setOut_trade_no(out_trade_no);
		uni.setFee_type("CNY");
		uni.setTotal_fee(total_fee);
		uni.setSpbill_create_ip(spbill_create_ip);
		uni.setTime_start(time_start);
		uni.setTime_expire(time_expire);
		uni.setGoods_tag(goods_tag);
		uni.setNotify_url(notify_url);
		uni.setTrade_type("JSAPI");
		uni.setProduct_id(product_id);
		//uni.setLimit_pay();//no_credit--指定不能使用信用卡支付
		uni.setOpenid(openid);
		return uni;
	}
	/**
	 * 统一下单
	 * 请使用  payUnifiedorder(Unifiedorder unifiedorder,String key),
	 * 自动生成sign
	 * @param unifiedorder
	 * @return
	 */
//	@Deprecated
//	public static UnifiedorderResult payUnifiedorder(Unifiedorder unifiedorder){
//		return payUnifiedorder(unifiedorder, null);
//	}

	/**
	 * 统一下单
	 * 2015-10-14验证接口签名完全正确
	 * @param unifiedorder
	 * @param key
	 * @return
	 */
	public static UnifiedorderResult payUnifiedorder(Unifiedorder unifiedorder,String key){
		Map<String,String> map = MapUtil.objectToMap(unifiedorder);
		if(key != null){
			String sign = SignatureUtil.generateSign(map,key);
			unifiedorder.setSign(sign);
		}
		String unifiedorderXML = XMLConverUtil.convertToXML(unifiedorder);
//		System.out.println(unifiedorderXML);
//		return null;
		HttpUriRequest httpUriRequest = RequestBuilder.post()
										.setHeader(xmlHeader)
										.setUri(MCH_URI + "/pay/unifiedorder")
										.setEntity(new StringEntity(unifiedorderXML,Charset.forName("utf-8")))
										.build();
		return LocalHttpClient.executeXmlResult(httpUriRequest, UnifiedorderResult.class);
		/**
		 * 返回结果示例
		 <appid>wx2421b1c4370ec43b</appid>
		 <attach>支付测试</attach>
		 <body>JSAPI支付测试</body>
		 <mch_id>10000100</mch_id>
		 <nonce_str>1add1a30ac87aa2db72f57a2375d8fec</nonce_str>
		 <notify_url>http://wxpay.weixin.qq.com/pub_v2/pay/notify.v2.php</notify_url>
		 <openid>oUpF8uMuAJO_M2pxb1Q9zNjWeS6o</openid>
		 <out_trade_no>1415659990</out_trade_no>
		 <spbill_create_ip>14.23.150.211</spbill_create_ip>
		 <total_fee>1</total_fee>
		 <trade_type>JSAPI</trade_type>
		 <sign>0CB01533B8C1EF103065174F50BCA001</sign>
		 </xml>
		 */
	}

	/**
	 * 刷卡支付  提交被扫支付API
	 * @param micropay
	 * @param key
	 * @return
	 */
	public static MicropayResult payMicropay(Micropay micropay,String key){
		Map<String,String> map = MapUtil.objectToMap(micropay);
		String sign = SignatureUtil.generateSign(map, key);
		micropay.setSign(sign);
		String closeorderXML = XMLConverUtil.convertToXML(micropay);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(xmlHeader)
				.setUri(MCH_URI + "/pay/micropay")
				.setEntity(new StringEntity(closeorderXML, Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeXmlResult(httpUriRequest,MicropayResult.class);
	}

	/**
	 * 查询订单
	 * @param mchOrderquery
	 * @param key
	 * @return
	 */
	public static MchOrderInfoResult payOrderquery(MchOrderquery mchOrderquery,String key){
		Map<String,String> map = MapUtil.objectToMap(mchOrderquery);
		String sign = SignatureUtil.generateSign(map,key);
		mchOrderquery.setSign(sign);
		String closeorderXML = XMLConverUtil.convertToXML(mchOrderquery);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(xmlHeader)
				.setUri(MCH_URI + "/pay/orderquery")
				.setEntity(new StringEntity(closeorderXML,Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeXmlResult(httpUriRequest,MchOrderInfoResult.class);
	}



	/**
	 * 关闭订单
	 * @param closeorder
	 * @param key 商户支付密钥
	 * @return
	 */
	public static MchBaseResult payCloseorder(Closeorder closeorder,String key){
		Map<String,String> map = MapUtil.objectToMap(closeorder);
		String sign = SignatureUtil.generateSign(map,key);
		closeorder.setSign(sign);
		String closeorderXML = XMLConverUtil.convertToXML(closeorder);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(xmlHeader)
				.setUri(MCH_URI + "/pay/closeorder")
				.setEntity(new StringEntity(closeorderXML,Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeXmlResult(httpUriRequest,MchBaseResult.class);
	}


	/**
	 * 申请退款
	 *
	 * 注意：
	 *	1.交易时间超过半年的订单无法提交退款；
	 *	2.微信支付退款支持单笔交易分多次退款，多次退款需要提交原支付订单的商户订单号和设置不同的退款单号。一笔退款失败后重新提交，要采用原来的退款单号。总退款金额不能超过用户实际支付金额。
	 * @param secapiPayRefund
	 * @param key 商户支付密钥
	 * @return
	 */
	public static SecapiPayRefundResult secapiPayRefund(SecapiPayRefund secapiPayRefund,String key){
		Map<String,String> map = MapUtil.objectToMap( secapiPayRefund);
		String sign = SignatureUtil.generateSign(map,key);
		secapiPayRefund.setSign(sign);
		String secapiPayRefundXML = XMLConverUtil.convertToXML( secapiPayRefund);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(xmlHeader)
				.setUri(MCH_URI + "/secapi/pay/refund")
				.setEntity(new StringEntity(secapiPayRefundXML,Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.keyStoreExecuteXmlResult(secapiPayRefund.getMch_id(), httpUriRequest, SecapiPayRefundResult.class);
	}

	/**
	 * 撤销订单
	 * 7天以内的交易单可调用撤销，其他正常支付的单如需实现相同功能请调用申请退款API。提交支付交易后调用【查询订单API】，没有明确的支付结果再调用【撤销订单API】。
	 * @param mchReverse
	 * @param key
	 * @return
	 */
	public static MchReverseResult secapiPayReverse(MchReverse mchReverse,String key){
		Map<String,String> map = MapUtil.objectToMap( mchReverse);
		String sign = SignatureUtil.generateSign(map,key);
		mchReverse.setSign(sign);
		String secapiPayRefundXML = XMLConverUtil.convertToXML( mchReverse);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(xmlHeader)
				.setUri(MCH_URI + "/secapi/pay/reverse")
				.setEntity(new StringEntity(secapiPayRefundXML,Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.keyStoreExecuteXmlResult(mchReverse.getMch_id(),httpUriRequest,MchReverseResult.class);
	}

	/**
	 * 查询退款
	 *
	 * 提交退款申请后，通过调用该接口查询退款状态。退款有一定延时，用零钱支付的退款
	 * 20 分钟内到账，银行卡支付的退款3 个工作日后重新查询退款状态。
	 * @param refundquery
	 * @param key 商户支付密钥
	 * @return
	 */
	public static RefundqueryResult payRefundquery(Refundquery refundquery,String key){
		Map<String,String> map = MapUtil.objectToMap(refundquery);
		String sign = SignatureUtil.generateSign(map,key);
		refundquery.setSign(sign);
		String refundqueryXML = XMLConverUtil.convertToXML(refundquery);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(xmlHeader)
				.setUri(MCH_URI + "/pay/refundqueryd")
				.setEntity(new StringEntity(refundqueryXML,Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeXmlResult(httpUriRequest, RefundqueryResult.class);
	}

	/**
	 * 下载对账单
	 * @param downloadbill
	 * @param key
	 * @return
	 */
	public static DownloadbillResult payDownloadbill(MchDownloadbill downloadbill,String key){
		Map<String,String> map = MapUtil.objectToMap(downloadbill);
		String sign = SignatureUtil.generateSign(map,key);
		downloadbill.setSign(sign);
		String closeorderXML = XMLConverUtil.convertToXML(downloadbill);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(xmlHeader)
				.setUri(MCH_URI + "/pay/downloadbill")
				.setEntity(new StringEntity(closeorderXML,Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.execute(httpUriRequest, new ResponseHandler<DownloadbillResult>() {

			@Override
			public DownloadbillResult handleResponse(HttpResponse response)
					throws ClientProtocolException, IOException {
				int status = response.getStatusLine().getStatusCode();
				if (status >= 200 && status < 300) {
					HttpEntity entity = response.getEntity();
					String str = EntityUtils.toString(entity, "utf-8");
					if (str.startsWith("<xml>")) {
						return XMLConverUtil.convertToObject(DownloadbillResult.class, str);
					} else {
						DownloadbillResult dr = new DownloadbillResult();
						dr.setData(str);
						return dr;
					}
				} else {
					throw new ClientProtocolException("Unexpected response status: " + status);
				}
			}
		});
	}

	/**
	 * 短链接转换
	 * @param shorturl
	 * @param key 商户支付密钥
	 * @return
	 */
	public static MchShorturlResult toolsShorturl(MchShorturl shorturl,String key){
		Map<String,String> map = MapUtil.objectToMap(shorturl);
		String sign = SignatureUtil.generateSign(map,key);
		shorturl.setSign(sign);
		String shorturlXML = XMLConverUtil.convertToXML(shorturl);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(xmlHeader)
				.setUri(MCH_URI + "/tools/shorturl")
				.setEntity(new StringEntity(shorturlXML,Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeXmlResult(httpUriRequest, MchShorturlResult.class);
	}

	/**
	 * 测速上报
	 * @param report
	 * @param key
	 * @return
	 */
	public static MchBaseResult payitilReport(Report report,String key){
		Map<String,String> map = MapUtil.objectToMap(report);
		String sign = SignatureUtil.generateSign(map,key);
		report.setSign(sign);
		String shorturlXML = XMLConverUtil.convertToXML(report);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(xmlHeader)
				.setUri(MCH_URI + "/payitil/report")
				.setEntity(new StringEntity(shorturlXML,Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeXmlResult(httpUriRequest,MchBaseResult.class);
	}

	/**
	 * 发放代金券
	 * @param sendCoupon
	 * @param key
	 * @return
	 */
	public static SendCouponResult mmpaymkttransfersSend_coupon(SendCoupon sendCoupon,String key){
		Map<String,String> map = MapUtil.objectToMap( sendCoupon);
		String sign = SignatureUtil.generateSign(map,key);
		sendCoupon.setSign(sign);
		String secapiPayRefundXML = XMLConverUtil.convertToXML( sendCoupon);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(xmlHeader)
				.setUri(MCH_URI + "/mmpaymkttransfers/send_coupon")
				.setEntity(new StringEntity(secapiPayRefundXML,Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.keyStoreExecuteXmlResult(sendCoupon.getMch_id(), httpUriRequest, SendCouponResult.class);
	}

	/**
	 * 查询代金券批次
	 * @param queryCouponStock
	 * @param key
	 * @return
	 */
	public static QueryCouponStockResult mmpaymkttransfersQuery_coupon_stock(QueryCouponStock queryCouponStock,String key){
		Map<String,String> map = MapUtil.objectToMap( queryCouponStock);
		String sign = SignatureUtil.generateSign(map,key);
		queryCouponStock.setSign(sign);
		String secapiPayRefundXML = XMLConverUtil.convertToXML( queryCouponStock);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(xmlHeader)
				.setUri(MCH_URI + "/mmpaymkttransfers/query_coupon_stock")
				.setEntity(new StringEntity(secapiPayRefundXML,Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeXmlResult(httpUriRequest, QueryCouponStockResult.class);
	}

	/**
	 * 查询代金券信息
	 * @param queryCoupon
	 * @param key
	 * @return
	 */
	public static QueryCouponResult promotionQuery_coupon(QueryCoupon queryCoupon,String key){
		Map<String,String> map = MapUtil.objectToMap( queryCoupon);
		String sign = SignatureUtil.generateSign(map,key);
		queryCoupon.setSign(sign);
		String secapiPayRefundXML = XMLConverUtil.convertToXML( queryCoupon);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(xmlHeader)
				.setUri(MCH_URI + "/promotion/query_coupon")
				.setEntity(new StringEntity(secapiPayRefundXML,Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeXmlResult(httpUriRequest,QueryCouponResult.class);
	}

	/**
	 * 现金红包
	 *
	 * 微信红包发送规则
	 * 1. 发送频率规则
　	 *	每分钟发送红包数量不得超过1800个；
　	 *	北京时间0：00-8：00不触发红包赠送；（如果以上规则不满足您的需求，请发邮件至wxhongbao@tencent.com获取升级指引）
	 *	2. 红包规则
	 *	单个红包金额介于[1.00元，200.00元]之间；
	 *	同一个红包只能发送给一个用户；（如果以上规则不满足您的需求，请发邮件至wxhongbao@tencent.com获取升级指引）
	 * @param sendredpack
	 * @param key
	 * @return
	 */
	public static SendredpackResult mmpaymkttransfersSendredpack(Sendredpack sendredpack,String key){
		Map<String,String> map = MapUtil.objectToMap( sendredpack);
		String sign = SignatureUtil.generateSign(map,key);
		sendredpack.setSign(sign);
		String secapiPayRefundXML = XMLConverUtil.convertToXML( sendredpack);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(xmlHeader)
				.setUri(MCH_URI + "/mmpaymkttransfers/sendredpack")
				.setEntity(new StringEntity(secapiPayRefundXML,Charset.forName("utf-8")))
				.build();
		SendredpackResult result = LocalHttpClient.keyStoreExecuteXmlResult(sendredpack.getMch_id(), httpUriRequest, SendredpackResult.class);
		return result;
	}

	/**
	 * 裂变红包
	 * @param sendgroupredpack
	 * @param key
	 * @return
	 */
	public static SendredpackResult mmpaymkttransfersSendgroupredpack(Sendgroupredpack sendgroupredpack,String key){
		Map<String,String> map = MapUtil.objectToMap( sendgroupredpack);
		String sign = SignatureUtil.generateSign(map,key);
		sendgroupredpack.setSign(sign);
		String secapiPayRefundXML = XMLConverUtil.convertToXML( sendgroupredpack);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(xmlHeader)
				.setUri(MCH_URI + "/mmpaymkttransfers/sendgroupredpack")
				.setEntity(new StringEntity(secapiPayRefundXML,Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.keyStoreExecuteXmlResult(sendgroupredpack.getMch_id(),httpUriRequest,SendredpackResult.class);
	}


	/**
	 * 企业付款
	 * @param transfers
	 * @param key
	 * @return
	 */
	public static TransfersResult mmpaymkttransfersPromotionTransfers(Transfers transfers,String key){
		Map<String,String> map = MapUtil.objectToMap( transfers);
		String sign = SignatureUtil.generateSign(map,key);
		transfers.setSign(sign);
		String secapiPayRefundXML = XMLConverUtil.convertToXML( transfers);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(xmlHeader)
				.setUri(MCH_URI + "/mmpaymkttransfers/promotion/transfers")
				.setEntity(new StringEntity(secapiPayRefundXML,Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.keyStoreExecuteXmlResult(transfers.getMchid(),httpUriRequest,TransfersResult.class);
	}

	/**
	 * 在微信网站默认测试数据测试
	 * https://pay.weixin.qq.com/wiki/tools/signverify/
	 */
	private static void test(){
		//微信测试例子
//		Unifiedorder info = new Unifiedorder();// PayMchAPI.newUnifiedorder(appid,mchid,body,null,0,null,notify_url,null);
//		info.setAppid("wxd930ea5d5a258f4f");
//		info.setMch_id("10000100");
//		info.setDevice_info("1000");
//		info.setBody("test");
//		info.setNonce_str("ibuaiVcKdpRxkhJA");
//		UnifiedorderResult result = PayMchAPI.payUnifiedorder(info, "192006250b4c09247ec02edce69f6a2d");
		/*测试结果
		<xml>
		<appid>wxd930ea5d5a258f4f</appid>
		<mch_id>10000100</mch_id>
		<device_info>1000</device_info>
		<nonce_str>ibuaiVcKdpRxkhJA</nonce_str>
		<sign><![CDATA[9A0A8659F005D6984697E2CA0A9CF3B7]]></sign>
		<body><![CDATA[test]]></body>
		</xml>*/
	}

	/**
	 * 自己输入数据,跟微信测试接口比对的数据
	 * https://pay.weixin.qq.com/wiki/tools/signverify/
	 */
	private static void test1(){
		Unifiedorder info = new Unifiedorder();// PayMchAPI.newUnifiedorder(appid,mchid,body,null,0,null,notify_url,null);
		info.setAppid("wx8d14842ec0581833");
		info.setMch_id("1270410801");
		info.setDevice_info("3535");
		info.setBody("小聚啦");
		info.setNonce_str("1234567890");
		info.setAttach("attach");
		info.setOut_trade_no("out_trade_no");
		info.setTotal_fee(50);
		info.setSpbill_create_ip("223.73.39.93");
		info.setTime_start("20091225091010");
		info.setTime_expire("20091227091010");
		info.setGoods_tag("goods_tag");

		UnifiedorderResult result = PayMchAPI.payUnifiedorder(info, "25806772ca057103eded3f30940ba255");
		/*
		<xml>
		<appid>wx8d14842ec0581833</appid>
		<mch_id>1270410801</mch_id>
		<device_info>3535</device_info>
		<nonce_str>1234567890</nonce_str>
		<sign><![CDATA[3CBD555B33A81586202E258C3C0F78C8]]></sign>
		<body><![CDATA[小聚啦]]></body>
		<attach><![CDATA[attach]]></attach>
		<out_trade_no>out_trade_no</out_trade_no>
		<total_fee>50</total_fee>
		<spbill_create_ip>223.73.39.93</spbill_create_ip>
		<time_start>20091225091010</time_start>
		<time_expire>20091227091010</time_expire>
		<goods_tag>goods_tag</goods_tag>
		</xml>*/

		/*微信测试结果
		https://pay.weixin.qq.com/wiki/tools/signverify/
		#1.生成字符串：
		appid=wx8d14842ec0581833&attach=attach&body=小聚啦&device_info=3535&goods_tag=goods_tag&mch_id=1270410801&nonce_str=1234567890&out_trade_no=out_trade_no&spbill_create_ip=223.73.39.93&time_expire=20091227091010&time_start=20091225091010&total_fee=50

		#2.连接商户key：
		appid=wx8d14842ec0581833&attach=attach&body=小聚啦&device_info=3535&goods_tag=goods_tag&mch_id=1270410801&nonce_str=1234567890&out_trade_no=out_trade_no&spbill_create_ip=223.73.39.93&time_expire=20091227091010&time_start=20091225091010&total_fee=50&key=25806772ca057103eded3f30940ba255

		#3.md5编码并转成大写：
		sign=3CBD555B33A81586202E258C3C0F78C8
		*/

		/*测试结果
		<xml>
		<appid>wx8d14842ec0581833</appid>
		<attach>attach</attach>
		<body>小聚啦</body>
		<device_info>3535</device_info>
		<goods_tag>goods_tag</goods_tag>
		<mch_id>1270410801</mch_id>
		<nonce_str>1234567890</nonce_str>
		<out_trade_no>out_trade_no</out_trade_no>
		<spbill_create_ip>223.73.39.93</spbill_create_ip>
		<time_expire>20091227091010</time_expire>
		<time_start>20091225091010</time_start>
		<total_fee>50</total_fee>
		<sign>3CBD555B33A81586202E258C3C0F78C8</sign>
		</xml>*/
	}
//	public static void main(String[] args){
		//appid=wx8d14842ec0581833&device_info=WEB&fee_type=CNY&mch_id=1270410801&nonce_str=5218bdfa2854409ab686f53d13834ca8&notify_url=http://xiaojula.meilyhome.com/together/list.html&openid=gh_0bee080dd83d&out_trade_no=2fe6522ababd48a79790b955c601cdf8&spbill_create_ip=127.0.0.1&time_expire=1445009737&time_start=1445007937&total_fee=5000&trade_type=JSAPI&key=25806772ca057103eded3f30940ba255
		//{"resultSuccess":false,"returnSuccess":false,"return_code":"FAIL","return_msg":"缺少参数"}
		//appId=wx8d14842ec0581833&nonceStr=b8c58e917326465a92dff04586d0e82b&package=prepay_id=null&signType=MD5&timeStamp=1445007938&key=25806772ca057103eded3f30940ba255

//	}
}
