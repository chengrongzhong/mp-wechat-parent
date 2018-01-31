package com.weixin.mp.bean.xmlmessage;

import com.weixin.mp.bean.AdaptorCDATA;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;

@XmlRootElement(name="xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class XMLVoiceMessage extends XMLMessage{

	@XmlElement(name="MediaId")
	@XmlJavaTypeAdapter(value = AdaptorCDATA.class)
	private String mediaId;

	public XMLVoiceMessage(){
		super("voice");
	}
	public XMLVoiceMessage(String toUserName, String fromUserName,String mediaId) {
		super(toUserName, fromUserName, "voice");
		this.mediaId = mediaId;
	}

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaid) {
		this.mediaId = mediaid;
	}

	@Override
	public String subXML() {
		return "<Voice><MediaId><![CDATA["+mediaId+"]]></MediaId></Voice>";
	}

	
}
