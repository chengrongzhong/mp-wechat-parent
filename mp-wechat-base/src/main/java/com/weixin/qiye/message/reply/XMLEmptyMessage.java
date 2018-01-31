package com.weixin.qiye.message.reply;

import com.weixin.mp.util.XMLConverUtil;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class XMLEmptyMessage extends XMLMessage {

	public XMLEmptyMessage(){
		super(null);
		this.setCreateTime(null);
	}


	public String toXML(){
		return "<xml></xml>";
	}
	@Override
	public String subXML() {
		return "";
	}

	public String toString(){
		return toXML();
	}
}
