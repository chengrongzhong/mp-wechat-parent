package com.weixin.qiye.bean.im.receive;

import com.weixin.mp.util.XMLConverUtil;
import org.springframework.stereotype.Component;

/**
 * Created by fang on 2016/1/12.
 */
@Component
public class DecryptBuilder {

    public String decryptToString(String xml){
        //TODO:解密算法需要实现
        //http://qydev.weixin.qq.com/wiki/index.php?title=%E4%BC%81%E4%B8%9A%E4%BC%9A%E8%AF%9D%E5%9B%9E%E8%B0%83
        //http://qydev.weixin.qq.com/wiki/index.php?title=%E5%8A%A0%E8%A7%A3%E5%AF%86%E6%96%B9%E6%A1%88%E7%9A%84%E8%AF%A6%E7%BB%86%E8%AF%B4%E6%98%8E
        return "";
    }
    public String decryptToString(EncryptMessage msg){
        return decryptToString(msg.getEncrypt());
    }
    public DecryptMessage decrypt(EncryptMessage em){
        String str = decryptToString(em.getEncrypt());
        DecryptMessage msg = XMLConverUtil.convertToObject(DecryptMessage.class,str);
        return msg;
    }

    public DecryptMessage decrypt(String xml){
        String str = decryptToString(xml);
        DecryptMessage msg = XMLConverUtil.convertToObject(DecryptMessage.class,str);
        return msg;
    }
}
