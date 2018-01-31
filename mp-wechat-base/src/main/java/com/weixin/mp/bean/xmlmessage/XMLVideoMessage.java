package com.weixin.mp.bean.xmlmessage;

import com.weixin.mp.bean.AdaptorCDATA;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement(name="xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class XMLVideoMessage extends XMLMessage{

	@XmlElement(name="mediaId")
	@XmlJavaTypeAdapter(value = AdaptorCDATA.class)
	private String mediaId;

	@XmlElement(name="Title")
	@XmlJavaTypeAdapter(value = AdaptorCDATA.class)
	private String title;

	@XmlElement(name="Description")
	@XmlJavaTypeAdapter(value = AdaptorCDATA.class)
	private String description;

	public XMLVideoMessage(){
		super("video");
	}
	public XMLVideoMessage(String toUserName, String fromUserName,String mediaId,String title,String description) {
		super(toUserName, fromUserName, "video");
		this.mediaId = mediaId;
		this.title = title;
		this.description = description;
	}

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

	@Override
	public String subXML() {
		StringBuilder sb = new StringBuilder();
		sb.append("<Video>");
		sb.append("<MediaId><![CDATA["+(mediaId==null?"":mediaId)+"]]></MediaId>");
		sb.append("<Title><![CDATA["+(title==null?"":title)+"]]></Title>");
		sb.append("<Description><![CDATA["+(description==null?"":description)+"]]></Description>");
		sb.append("</Video>");
		return sb.toString();
	}

	
}
