package com.weixin.qiye.message.receive;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 接收微信消息
 * Created by sdyang on 2016/4/22.
 */
@XmlRootElement(name="xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class ReceiveMsg {

    @XmlElement(name="ToUserName")
    private String ToUserName;//企业号CorpID

    @XmlElement(name="FromUserName")
    private String FromUserName;//成员UserID

    @XmlElement(name="CreateTime")
    private String CreateTime;//消息创建时间（整型）

    @XmlElement(name="MsgType")
    private String MsgType;//消息类型

    @XmlElement(name="MsgId")
    private String MsgId;//消息id，64位整型

    @XmlElement(name="AgentID")
    private String AgentId;//企业应用的id，整型。可在应用的设置页面查看

    @XmlElement(name="Content")
    private String Content;//文本消息内容

    @XmlElement(name="PicUrl")
    private String PicUrl;//图片链接

    @XmlElement(name="MediaId")
    private String MediaId;//图片媒体文件id，可以调用获取媒体文件接口拉取数据

    @XmlElement(name="Format")
    private String Format;//语音格式，如amr，speex等

    @XmlElement(name="ThumbMediaId")
    private String ThumbMediaId;//视频消息缩略图的媒体id，可以调用获取媒体文件接口拉取数据

    @XmlElement(name="Location_X")
    private String Location_X;//地理位置维度

    @XmlElement(name="Location_Y")
    private String Location_Y;//地理位置经度

    @XmlElement(name="Scale")
    private String Scale;//地图缩放大小

    @XmlElement(name="Label")
    private String Label;//地理位置信息

    @XmlElement(name="Title")
    private String Title;//标题

    @XmlElement(name="Description")
    private String Description;//描述

    @XmlElement(name="Event")
    private String Event;//事件类型

    @XmlElement(name="EventKey")
    private String EventKey;//事件KEY值，与自定义菜单接口中KEY值对应

    @XmlElement(name="Latitude")
    private String Latitude;//地理位置纬度

    @XmlElement(name="Longitude")
    private String Longitude;//地理位置经度

    @XmlElement(name="Precision")
    private String Precision;//地理位置精度

    @XmlElement(name="ScanCodeInfo")
    private String ScanCodeInfo;//扫描信息

    @XmlElement(name="ScanType")
    private String ScanType;//扫描类型，一般是qrcode

    @XmlElement(name = "ScanResult")
    private String ScanResult;//扫描结果，即二维码对应的字符串信息


    public String getToUserName() {
        return ToUserName;
    }

    public void setToUserName(String toUserName) {
        ToUserName = toUserName;
    }

    public String getFromUserName() {
        return FromUserName;
    }

    public void setFromUserName(String fromUserName) {
        FromUserName = fromUserName;
    }

    public String getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(String createTime) {
        CreateTime = createTime;
    }

    public String getMsgType() {
        return MsgType;
    }

    public void setMsgType(String msgType) {
        MsgType = msgType;
    }

    public String getMsgId() {
        return MsgId;
    }

    public void setMsgId(String msgId) {
        MsgId = msgId;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getLocation_X() {
        return Location_X;
    }

    public void setLocation_X(String location_X) {
        Location_X = location_X;
    }

    public String getLocation_Y() {
        return Location_Y;
    }

    public void setLocation_Y(String location_Y) {
        Location_Y = location_Y;
    }

    public String getScale() {
        return Scale;
    }

    public void setScale(String scale) {
        Scale = scale;
    }

    public String getLabel() {
        return Label;
    }

    public void setLabel(String label) {
        Label = label;
    }

    public String getEvent() {
        return Event;
    }

    public void setEvent(String event) {
        Event = event;
    }

    public String getEventKey() {
        return EventKey;
    }

    public void setEventKey(String eventKey) {
        EventKey = eventKey;
    }

    public String getLatitude() {
        return Latitude;
    }

    public void setLatitude(String latitude) {
        Latitude = latitude;
    }

    public String getLongitude() {
        return Longitude;
    }

    public void setLongitude(String longitude) {
        Longitude = longitude;
    }

    public String getPrecision() {
        return Precision;
    }

    public void setPrecision(String precision) {
        Precision = precision;
    }

    public String getAgentId() {
        return AgentId;
    }

    public void setAgentId(String agentId) {
        AgentId = agentId;
    }

    public String getPicUrl() {
        return PicUrl;
    }

    public void setPicUrl(String picUrl) {
        PicUrl = picUrl;
    }

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

    public String getFormat() {
        return Format;
    }

    public void setFormat(String format) {
        Format = format;
    }

    public String getThumbMediaId() {
        return ThumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        ThumbMediaId = thumbMediaId;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getScanCodeInfo() {
        return ScanCodeInfo;
    }

    public void setScanCodeInfo(String scanCodeInfo) {
        ScanCodeInfo = scanCodeInfo;
    }

    public String getScanType() {
        return ScanType;
    }

    public void setScanType(String scanType) {
        ScanType = scanType;
    }

    public String getScanResult() {
        return ScanResult;
    }

    public void setScanResult(String scanResult) {
        ScanResult = scanResult;
    }

}
