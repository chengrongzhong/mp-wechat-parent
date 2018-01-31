package com.weixin.qiye.message.reply;

import com.weixin.mp.bean.AdaptorCDATA;
import com.weixin.mp.util.XMLConverUtil;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement(name="xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class XMLImageMessage extends XMLMessage {

	@XmlElement(name="Image")
	private Image image;

	public XMLImageMessage(){
		super("image");
	}
	public XMLImageMessage(String toUserName, String fromUserName,String mediaId) {
		super(toUserName, fromUserName, "image");
		this.image = new Image();
		this.image.mediaId = mediaId;
	}

	@Override
	public String subXML() {
		return "<Image><MediaId><![CDATA["+(image.mediaId==null?"":image.mediaId)+"]]></MediaId></Image>";
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	private static class Image{
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
