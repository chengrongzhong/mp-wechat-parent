package com.weixin.qiye.message.receive;

import com.weixin.mp.bean.AdaptorCDATA;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.List;

/**
 * Created by fang on 2016/1/6.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="xml")
public class EventMessage {

    private String ToUserName; 		//开发者微信号
    private String FromUserName;	//发送方帐号（一个OpenID）
    private Integer CreateTime;		//消息创建时间 （整型）
    private String MsgType;			//消息类型，event
    private String Event;			//事件类型，subscribe(订阅)、unsubscribe(取消订阅)
    private String AgentID;

    //----上报地理位置事件
    private String Latitude;		//地理位置纬度
    private String Longitude;		//地理位置经度
    private String Precision;		//地理位置精度

    //上报菜单事件
    private String EventKey;

    //扫码推事件的事件推送
    private ScanCodeInfo ScanCodeInfo;
    private SendPicsInfo SendPicsInfo;
    private SendLocationInfo SendLocationInfo;
    private BatchJob BatchJob;

    @XmlElement(name="ToUserName")
    @XmlJavaTypeAdapter(value = AdaptorCDATA.class)
    public String getToUserName() {
        return ToUserName;
    }

    public void setToUserName(String toUserName) {
        ToUserName = toUserName;
    }

    @XmlElement(name="FromUserName")
    @XmlJavaTypeAdapter(value = AdaptorCDATA.class)
    public String getFromUserName() {
        return FromUserName;
    }

    public void setFromUserName(String fromUserName) {
        FromUserName = fromUserName;
    }

    @XmlElement(name="CreateTime")
    public Integer getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(Integer createTime) {
        CreateTime = createTime;
    }

    @XmlElement(name="MsgType")
    @XmlJavaTypeAdapter(value = AdaptorCDATA.class)
    public String getMsgType() {
        return MsgType;
    }

    public void setMsgType(String msgType) {
        MsgType = msgType;
    }

    @XmlElement(name="Event")
    @XmlJavaTypeAdapter(value = AdaptorCDATA.class)
    public String getEvent() {
        return Event;
    }

    public void setEvent(String event) {
        Event = event;
    }

    @XmlElement(name="AgentID")
    @XmlJavaTypeAdapter(value = AdaptorCDATA.class)
    public String getAgentID() {
        return AgentID;
    }

    public void setAgentID(String agentID) {
        AgentID = agentID;
    }

    @XmlElement(name="Latitude")
    @XmlJavaTypeAdapter(value = AdaptorCDATA.class)
    public String getLatitude() {
        return Latitude;
    }

    public void setLatitude(String latitude) {
        this.Latitude = latitude;
    }

    @XmlElement(name="Longitude")
    @XmlJavaTypeAdapter(value = AdaptorCDATA.class)
    public String getLongitude() {
        return Longitude;
    }

    public void setLongitude(String longitude) {
        this.Longitude = longitude;
    }

    @XmlElement(name="Precision")
    @XmlJavaTypeAdapter(value = AdaptorCDATA.class)
    public String getPrecision() {
        return Precision;
    }

    public void setPrecision(String precision) {
        this.Precision = precision;
    }

    @XmlElement(name="EventKey")
    @XmlJavaTypeAdapter(value = AdaptorCDATA.class)
    public String getEventKey() {
        return EventKey;
    }

    public void setEventKey(String eventKey) {
        EventKey = eventKey;
    }

    @XmlElement(name="ScanCodeInfo")
    public EventMessage.ScanCodeInfo getScanCodeInfo() {
        return ScanCodeInfo;
    }

    public void setScanCodeInfo(EventMessage.ScanCodeInfo scanCodeInfo) {
        ScanCodeInfo = scanCodeInfo;
    }

    @XmlElement(name="SendPicsInfo")
    public EventMessage.SendPicsInfo getSendPicsInfo() {
        return SendPicsInfo;
    }

    public void setSendPicsInfo(EventMessage.SendPicsInfo sendPicsInfo) {
        SendPicsInfo = sendPicsInfo;
    }

    @XmlElement(name="SendLocationInfo")
    public EventMessage.SendLocationInfo getSendLocationInfo() {
        return SendLocationInfo;
    }

    public void setSendLocationInfo(EventMessage.SendLocationInfo sendLocationInfo) {
        SendLocationInfo = sendLocationInfo;
    }

    @XmlElement(name="BatchJob")
    public EventMessage.BatchJob getBatchJob() {
        return BatchJob;
    }

    public void setBatchJob(EventMessage.BatchJob batchJob) {
        BatchJob = batchJob;
    }

    //异步任务完成事件推送
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlRootElement(name="BatchJob")
    private static class BatchJob{
        @XmlElement(name="JobId")
        @XmlJavaTypeAdapter(value = AdaptorCDATA.class)
        private String JobId;
        @XmlElement(name="JobType")
        @XmlJavaTypeAdapter(value = AdaptorCDATA.class)
        private String JobType;
        @XmlElement(name="ErrCode")
        private int ErrCode;
        @XmlElement(name="ErrMsg")
        @XmlJavaTypeAdapter(value = AdaptorCDATA.class)
        private String ErrMsg;

        public String getJobId() {
            return JobId;
        }

        public void setJobId(String jobId) {
            JobId = jobId;
        }

        public String getJobType() {
            return JobType;
        }

        public void setJobType(String jobType) {
            JobType = jobType;
        }

        public int getErrCode() {
            return ErrCode;
        }

        public void setErrCode(int errCode) {
            ErrCode = errCode;
        }

        public String getErrMsg() {
            return ErrMsg;
        }

        public void setErrMsg(String errMsg) {
            ErrMsg = errMsg;
        }
    }

    //弹出地理位置选择器的事件推送
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlRootElement(name="SendLocationInfo")
    private static class SendLocationInfo{
        @XmlElement(name="Location_X")
        @XmlJavaTypeAdapter(value = AdaptorCDATA.class)
        private String Location_X;
        @XmlElement(name="Location_Y")
        @XmlJavaTypeAdapter(value = AdaptorCDATA.class)
        private String Location_Y;
        @XmlElement(name="Scale")
        @XmlJavaTypeAdapter(value = AdaptorCDATA.class)
        private String Scale;
        @XmlElement(name="Label")
        @XmlJavaTypeAdapter(value = AdaptorCDATA.class)
        private String Label;
        @XmlElement(name="Poiname")
        @XmlJavaTypeAdapter(value = AdaptorCDATA.class)
        private String Poiname;

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

        public String getPoiname() {
            return Poiname;
        }

        public void setPoiname(String poiname) {
            Poiname = poiname;
        }
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlRootElement(name="PicMd5Sum")
    private static class PicMd5Sum{
        @XmlElement(name="PicMd5Sum")
        @XmlJavaTypeAdapter(value = AdaptorCDATA.class)
        private String md5;

        public String getMd5() {
            return md5;
        }

        public void setMd5(String md5) {
            this.md5 = md5;
        }
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlRootElement(name="SendPicsInfo")
    private static class SendPicsInfo{
        @XmlElement(name="Count")
        private int Count;
        @XmlElementWrapper(name="PicList")
        @XmlElement(name="item")
        private List<PicMd5Sum> PicMd5Sum;

        public int getCount() {
            return Count;
        }

        public void setCount(int count) {
            Count = count;
        }

        public List<EventMessage.PicMd5Sum> getPicMd5Sum() {
            return PicMd5Sum;
        }

        public void setPicMd5Sum(List<EventMessage.PicMd5Sum> picMd5Sum) {
            PicMd5Sum = picMd5Sum;
        }
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlRootElement(name="ScanCodeInfo")
    private static class ScanCodeInfo{
        @XmlElement(name="ScanType")
        @XmlJavaTypeAdapter(value = AdaptorCDATA.class)
        private String ScanType;
        @XmlElement(name="ScanResult")
        @XmlJavaTypeAdapter(value = AdaptorCDATA.class)
        private String ScanResult;

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

//    public static void main(String[] args){
//        String xml = "<xml><ToUserName><![CDATA[toUser]]></ToUserName>" +
//                "<FromUserName><![CDATA[FromUser]]></FromUserName>" +
//                "<CreateTime>1408090502</CreateTime>" +
//                "<MsgType><![CDATA[event]]></MsgType>" +
//                "<Event><![CDATA[scancode_push]]></Event>" +
//                "<EventKey><![CDATA[6]]></EventKey>" +
//                "<ScanCodeInfo><ScanType><![CDATA[qrcode]]></ScanType>" +
//                "<ScanResult><![CDATA[1]]></ScanResult>" +
//                "</ScanCodeInfo>" +
//                "<SendPicsInfo><Count>1</Count>" +
//                "<PicList><item><PicMd5Sum><![CDATA[1b5f7c23b5bf75682a53e7b6d163e185]]></PicMd5Sum>" +
//                "</item>" +
//                "</PicList>" +
//                "</SendPicsInfo>" +
//                "<SendLocationInfo><Location_X><![CDATA[23]]></Location_X>" +
//                "<Location_Y><![CDATA[113]]></Location_Y>" +
//                "<Scale><![CDATA[15]]></Scale>" +
//                "<Label><![CDATA[ 广州市海珠区客村艺苑路 106号]]></Label>" +
//                "<Poiname><![CDATA[]]></Poiname>" +
//                "</SendLocationInfo>" +
//                "<BatchJob><JobId><![CDATA[S0MrnndvRG5fadSlLwiBqiDDbM143UqTmKP3152FZk4]]></JobId>" +
//                "<JobType><![CDATA[sync_user]]></JobType>" +
//                "<ErrCode>0</ErrCode>" +
//                "<ErrMsg><![CDATA[ok]]></ErrMsg>" +
//                "</BatchJob>" +
//                "<AgentID>1</AgentID>" +
//                "</xml>";
//
//        EventMessage event = XMLConverUtil.convertToObject(EventMessage.class,xml);
//        System.out.println(XMLConverUtil.convertToXML(event));
//    }
}
