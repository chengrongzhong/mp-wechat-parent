package com.weixin.qiye.message.reply;

import com.weixin.mp.bean.AdaptorCDATA;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement(name="xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class XMLVideoMessage extends XMLMessage {

	@XmlElement(name="Video")
	private Video video;

	public XMLVideoMessage(){
		super("video");
	}
	public XMLVideoMessage(String toUserName, String fromUserName,String mediaId,String title,String description) {
		super(toUserName, fromUserName, "video");
		video = new Video();
		this.video.mediaId = mediaId;
		this.video.title = title;
		this.video.description = description;
	}

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

	@Override
	public String subXML() {
		StringBuilder sb = new StringBuilder();
		sb.append("<Video>");
		sb.append("<MediaId><![CDATA["+(video.mediaId==null?"":video.mediaId)+"]]></MediaId>");
		sb.append("<Title><![CDATA["+(video.title==null?"":video.title)+"]]></Title>");
		sb.append("<Description><![CDATA["+(video.description==null?"":video.description)+"]]></Description>");
		sb.append("</Video>");
		return sb.toString();
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	private static class Video{
		@XmlElement(name="MediaId")
		@XmlJavaTypeAdapter(value = AdaptorCDATA.class)
		private String mediaId;

		@XmlElement(name="Title")
		@XmlJavaTypeAdapter(value = AdaptorCDATA.class)
		private String title;

		@XmlElement(name="Description")
		@XmlJavaTypeAdapter(value = AdaptorCDATA.class)
		private String description;

		public String getMediaId() {
			return mediaId;
		}

		public void setMediaId(String mediaId) {
			this.mediaId = mediaId;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

	}
	
}
