package com.spoke.wechat.action;

import com.spoke.wechat.service.WeixinService;
import com.weixin.mp.support.TicketManager;
import com.weixin.mp.support.TokenManager;
import com.weixin.mp.util.JsUtil;
import com.weixin.qiye.api.OauthAPI;
import com.weixin.qiye.bean.oauth.OAuthResult;
import com.weixin.qiye.support.QyTokenManager;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * Created by chengrongzhong on 2017/2/22.
 * Time: 10:56.
 */
@Controller
@RequestMapping("/a")
public class WeixinController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private WeixinService weixinService;

    @RequestMapping(value = "/b", method = RequestMethod.GET)
    public String getMessage(HttpServletRequest request, @RequestParam(value = "wenetcard", required = false, defaultValue = "") String company, Model model) {
        //1、获取AccessToken
        String accessToken = TokenManager.getDefaultToken();

        //2、获取Ticket
        String jsapi_ticket = TicketManager.getDefaultTicket();

        //3、时间戳和随机字符串
        String noncestr = UUID.randomUUID().toString().replace("-", "").substring(0, 16);//随机字符串
        String timestamp = String.valueOf(System.currentTimeMillis() / 1000);//时间戳

        //4、获取url
//        String url = weixinService.getUrl()+"/a/b?wenetcard="+company;

        String URL = request.getRequestURL().toString();
        //获取所有请求,返回Map集合,遍历
        Map<String, String[]> map = request.getParameterMap();
        Set<Map.Entry<String, String[]>> entry = map.entrySet();
        Iterator<Map.Entry<String, String[]>> iterator = entry.iterator();

        //遍历集合
        StringBuffer sb = new StringBuffer();
        while(iterator.hasNext()){
            Map.Entry<String, String[]> item = iterator.next();
            //请求名
            String key = item.getKey();
            //请求值
            for(String value : item.getValue()){
                //拼接每个请求参数   key=value&
                sb.append(key+"="+value+"&");
            }
        }
        String string = sb.toString();
        //拼接URL,   URL?key=value&key=value&   并且去掉最后一个&
        URL = URL + "?"+string.substring(0, string.lastIndexOf("&"));
        System.out.println(URL);
        String signature = JsUtil.generateConfigSignature(noncestr, jsapi_ticket, timestamp, URL);

        System.out.println("accessToken:"+accessToken+"\njsapi_ticket:"+jsapi_ticket+"\n时间戳："+timestamp+"\n随机字符串："+noncestr+"\nurl："+URL + "\nsignature：" + signature);

        model.addAttribute("signature", signature);
        model.addAttribute("appId", weixinService.getAppid());
        model.addAttribute("timestamp", timestamp);
        model.addAttribute("nonceStr", noncestr);
        model.addAttribute("url", URL);
        return "/" + company;
    }

//    /**
//     * 接收微信的消息入口
//     *
//     * @param timestamp
//     * @param nonce
//     * @param msg_signature
//     * @param echostr
//     * @param xml
//     * @param response
//     * @param request
//     * @throws java.io.IOException
//     * @throws com.mp.aes.AesException
//     */
//    @RequestMapping(value = "/getMessage", method = RequestMethod.GET)
//    public void getMessage(@RequestParam(value = "timestamp", required = false, defaultValue = "") String timestamp,
//                           @RequestParam(value = "nonce", required = false, defaultValue = "") String nonce,
//                           @RequestParam(value = "msg_signature", required = false, defaultValue = "") String msg_signature,
//                           @RequestParam(value = "echostr", required = false, defaultValue = "") String echostr,
//                           @RequestBody(required = false) String xml,
//                           HttpServletResponse response, HttpServletRequest request) throws IOException, AesException {
//        ServletOutputStream outputStream = response.getOutputStream();
//        try {
//            //验证请求签名
//            if (StringUtils.isNotEmpty(echostr) && StringUtils.isEmpty(xml)) {
//                String msg = weixinService.getWXBizMsgCrypt().verifyUrl(msg_signature, timestamp, nonce, echostr);
//                outputStreamWrite(outputStream, msg);
//                logger.info("首次验证成功！");
//                return;
//            }
//
//            if (StringUtils.isNotEmpty(xml)) {
//                logger.debug("接收到微信的加密xml字符串：" + xml);
//                String context = weixinService.getWXBizMsgCrypt().decryptMsg(msg_signature, timestamp, nonce, xml);
//                logger.debug("解析后的明文xml字符串：" + context);
//                ReceiveMsg msg = XMLConverUtil.convertToObject(ReceiveMsg.class, context);
//
//                if (msg.getMsgType().equals(MsgType.TEXT)) {
//                    XMLTextMessage textMessage = new XMLTextMessage(msg.getFromUserName(), msg.getToUserName(), "欢迎使用消息推送系统");
//                    textMessage.outputStreamWrite(outputStream, weixinService.getWXBizMsgCrypt());
//                }
//            }
//        } catch (Exception e) {
//            logger.error("微信消息接收失败，" + e.toString());
//        }
//    }

    /**
     * 微信授权 回调接口，包含code参数
     *
     * @param code     用户获取access_token
     * @param state    自定义的参数
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/getQyAuthCode", method = RequestMethod.GET)
    public RedirectView getQyAuthCode(@RequestParam(value = "code", required = false, defaultValue = "") String code,
                                      @RequestParam(value = "state", required = false, defaultValue = "") String state,
                                      HttpServletRequest request, HttpServletResponse response) {
        logger.info("网页授权,code =" + code + ",state=" + state);
        try {
            if (StringUtils.isEmpty(code)) {
                return new RedirectView("redirect:/dealer/toLogin");
            }
            OAuthResult result = OauthAPI.getUserInfo(QyTokenManager.getDefaultToken(), code);
            String userId = result.getUserId();

            if (StringUtils.isEmpty(userId)) {
                String openId = result.getOpenId();
//                userId = openId;
                logger.error("user通过网页进入错误,openId=" + openId);
                return new RedirectView("redirect:/dealer/toLogin");
            } else {
//                setUserInfo(userId, response);
            }
        } catch (Exception e) {
            logger.error("网页授权失败,code =" + code + ",state=" + state, e);
        }
        return new RedirectView(getRedirectPage(state));
    }

    /**
     * 跳转页面
     *
     * @param state
     * @return
     */
    private String getRedirectPage(String state) {
        logger.info("getRedirectPage:" + weixinService.getUrl() + state);
        return weixinService.getUrl() + state;
    }

    public void outputStreamWrite(OutputStream outputStream, String text) throws IOException {
        outputStream.write(text.getBytes("utf-8"));
    }

}

