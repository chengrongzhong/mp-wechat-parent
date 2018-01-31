package com.weixin.mp.bean.xmlmessage;

import com.weixin.mp.util.XMLConverUtil;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class XMLEmptyMessage extends XMLMessage{

	public XMLEmptyMessage(){
		super(null);
		this.setCreateTime(null);
	}


	public String toXML(){
		return "";
	}
	@Override
	public String subXML() {
		return "";
	}

	public String toString(){
		return toXML();
	}
}
