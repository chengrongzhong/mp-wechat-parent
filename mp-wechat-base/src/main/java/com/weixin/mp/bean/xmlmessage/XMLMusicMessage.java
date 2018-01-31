package com.weixin.mp.bean.xmlmessage;

import com.weixin.mp.bean.AdaptorCDATA;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement(name="xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class XMLMusicMessage extends XMLMessage{

	@XmlElement(name="title")
	@XmlJavaTypeAdapter(value = AdaptorCDATA.class)
	private String title;

	@XmlElement(name="Description")
	@XmlJavaTypeAdapter(value = AdaptorCDATA.class)
	private String description;

	@XmlElement(name="MusicUrl")
	@XmlJavaTypeAdapter(value = AdaptorCDATA.class)
	private String musicUrl;

	@XmlElement(name="HQMusicUrl")
	@XmlJavaTypeAdapter(value = AdaptorCDATA.class)
	private String hQMusicUrl;

	@XmlElement(name="ThumbMediaId")
	@XmlJavaTypeAdapter(value = AdaptorCDATA.class)
	private String thumbMediaId;

	public XMLMusicMessage(){
		super("music");
	}
	/**
	 * 
	 * @param toUserName
	 * @param fromUserName
	 * @param title			[可以为空]
	 * @param description	[可以为空]
	 * @param musicUrl		[可以为空] 音乐链接
	 * @param hQMusicUrl	[可以为空] 高质量音乐链接，WIFI环境优先使用该链接播放音乐
	 * @param thumbMediaId	缩略图的媒体id，通过上传多媒体文件，得到的id
	 */
	public XMLMusicMessage(String toUserName, String fromUserName,
			String title,String description,String musicUrl,String hQMusicUrl,String thumbMediaId) {
		super(toUserName, fromUserName, "music");
		this.title = title;
		this.description = description;
		this.musicUrl = musicUrl;
		this.hQMusicUrl = hQMusicUrl;
		this.thumbMediaId = thumbMediaId;
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

	public String getMusicUrl() {
		return musicUrl;
	}

	public void setMusicUrl(String musicUrl) {
		this.musicUrl = musicUrl;
	}

	public String gethQMusicUrl() {
		return hQMusicUrl;
	}

	public void sethQMusicUrl(String hQMusicUrl) {
		this.hQMusicUrl = hQMusicUrl;
	}

	public String getThumbMediaId() {
		return thumbMediaId;
	}

	public void setThumbMediaId(String thumbMediaId) {
		this.thumbMediaId = thumbMediaId;
	}

	@Override
	public String subXML() {
		StringBuilder sb = new StringBuilder();
		sb.append("<Music>");
		sb.append("<Title><![CDATA["+(title==null?"":title)+"]]></Title>");
		sb.append("<Description><![CDATA["+(description==null?"":description)+"]]></Description>");
		sb.append("<MusicUrl><![CDATA["+(musicUrl==null?"":musicUrl)+"]]></MusicUrl>");
		sb.append("<HQMusicUrl><![CDATA["+(hQMusicUrl==null?"":hQMusicUrl)+"]]></HQMusicUrl>");		
		sb.append("<ThumbMediaId><![CDATA["+(thumbMediaId==null?"":thumbMediaId)+"]]></ThumbMediaId>");
		sb.append("</Music>");
		return sb.toString();
	}

	
}
