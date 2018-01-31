package com.weixin.mp.bean.xmlmessage;

import com.weixin.mp.bean.AdaptorCDATA;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement(name="xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class XMLImageMessage extends XMLMessage{

	@XmlElement(name="mediaId")
	@XmlJavaTypeAdapter(value = AdaptorCDATA.class)
	private String mediaId;

	public XMLImageMessage(){
		super("image");
	}
	public XMLImageMessage(String toUserName, String fromUserName,String mediaId) {
		super(toUserName, fromUserName, "image");
		this.mediaId = mediaId;
	}

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	@Override
	public String subXML() {
		return "<Image><MediaId><![CDATA["+(mediaId==null?"":mediaId)+"]]></MediaId></Image>";
	}

	
}
