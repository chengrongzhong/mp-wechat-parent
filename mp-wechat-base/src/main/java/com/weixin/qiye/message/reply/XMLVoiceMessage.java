package com.weixin.qiye.message.reply;

import com.weixin.mp.bean.AdaptorCDATA;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement(name="xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class XMLVoiceMessage extends XMLMessage {

	@XmlElement(name="Voice")
	private Voice voice;

	public XMLVoiceMessage(){
		super("voice");
	}
	public XMLVoiceMessage(String toUserName, String fromUserName,String mediaId) {
		super(toUserName, fromUserName, "voice");
		this.voice = new Voice();
		this.voice.mediaId = mediaId;
	}

	@Override
	public String subXML() {
		return "<Voice><MediaId><![CDATA["+voice.mediaId+"]]></MediaId></Voice>";
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	private static class Voice{
		@XmlElement(name="MediaId")
		@XmlJavaTypeAdapter(value = AdaptorCDATA.class)
		private String mediaId;

		public String getMediaId() {
			return mediaId;
		}

		public void setMediaId(String mediaId) {
			this.mediaId = mediaId;
		}
	}
}
