package com.weixin.qiye.message.send;

import com.weixin.mp.bean.Article;
import com.weixin.mp.util.JsonUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fang on 2016/1/8.
 */
public class SendMessageBuilder {

    private void setValue(Message msg,String[] userids,String[] partyids,String[] tags,int agentid,boolean safe){
        msg.setAgentid(agentid);
        msg.setToparty(toString(partyids));
        msg.setTotag(toString(tags));
        msg.setTouser(toString(userids));
        msg.setSafe(safe ? "1" : "0");
    }

    public TextMessage newTextMessage(String[] userids,String[] partyids,String[] tags,int agentid,boolean safe,String content){
        TextMessage msg = new TextMessage();
        setValue(msg, userids, partyids, tags, agentid, safe);
        msg.setText(TextMessage.newText(content));
        return msg;
    }

    public ImageMessage newImageMessage(String[] userids,String[] partyids,String[] tags,int agentid,boolean safe,String media_id){
        ImageMessage msg = new ImageMessage();
        setValue(msg, userids, partyids, tags, agentid, safe);
        msg.setImage(ImageMessage.newImage(media_id));
        return msg;
    }

    public VoiceMessage newVoiceMessage(String[] userids,String[] partyids,String[] tags,int agentid,boolean safe,String media_id){
        VoiceMessage msg = new VoiceMessage();
        setValue(msg, userids, partyids, tags, agentid, safe);
        msg.setVoice(VoiceMessage.newVoice(media_id));
        return msg;
    }

    public VideoMessage newVideoMessage(String[] userids,String[] partyids,String[] tags,int agentid,boolean safe,String media_id,String title,String desc){
        VideoMessage msg = new VideoMessage();
        setValue(msg, userids, partyids, tags, agentid, safe);
        msg.setVideo(VideoMessage.newVideo(media_id, title, desc));
        return msg;
    }

    public FileMessage newFileMessage(String[] userids,String[] partyids,String[] tags,int agentid,boolean safe,String media_id){
        FileMessage msg = new FileMessage();
        setValue(msg, userids, partyids, tags, agentid, safe);
        msg.setFile(FileMessage.newFile(media_id));
        return msg;
    }

    public NewsMessage newNewsMessage(String[] userids,String[] partyids,String[] tags,int agentid,boolean safe,List<NewsMessage.Article> list){
        NewsMessage msg = new NewsMessage();
        setValue(msg, userids, partyids, tags, agentid, safe);
        msg.setNews(NewsMessage.newNews(list));
        return msg;
    }

    public MpnewsMessage newMpnewsMessage(String[] userids,String[] partyids,String[] tags,int agentid,boolean safe,List<Article> list){
        MpnewsMessage msg = new MpnewsMessage();
        setValue(msg, userids, partyids, tags, agentid, safe);
        msg.setMpnews(MpnewsMessage.newNews(list));
        return msg;
    }

    public MaterialMessage newMaterialMessage(String[] userids,String[] partyids,String[] tags,int agentid,boolean safe,String media_id){
        MaterialMessage msg = new MaterialMessage();
        setValue(msg, userids, partyids, tags, agentid, safe);
        msg.setMpnews(MaterialMessage.newMpnews(media_id));
        return msg;
    }

    private String toString(String[] array){
        StringBuffer sb = new StringBuffer(64);
        for(int i=0;i<array.length;i++){
            sb.append(array[i]);
            if(i<array.length-1){
                sb.append("|");
            }
        }
        return sb.toString();
    }

//    public static void main(String[] args){
//        SendMessageBuilder builder = new SendMessageBuilder();
//        Object obj = builder.newTextMessage(new String[]{"a","a1","a2"},new String[]{"a","a1","a2"},new String[]{"a","a1","a2"},0,true,"adfasdfasdf");
//        System.out.println(JsonUtil.toJSONString(obj));
//        obj = builder.newImageMessage(new String[]{"a", "a1", "a2"}, new String[]{"a", "a1", "a2"}, new String[]{"a", "a1", "a2"}, 0, true, "adfasdfasdf");
//        System.out.println(JsonUtil.toJSONString(obj));
//        obj = builder.newVoiceMessage(new String[]{"a", "a1", "a2"}, new String[]{"a", "a1", "a2"}, new String[]{"a", "a1", "a2"}, 0, true, "adfasdfasdf");
//        System.out.println(JsonUtil.toJSONString(obj));
//        obj = builder.newVideoMessage(new String[]{"a", "a1", "a2"}, new String[]{"a", "a1", "a2"}, new String[]{"a", "a1", "a2"}, 0, true, "adfasdfasdf", "asdfas", "desc");
//        System.out.println(JsonUtil.toJSONString(obj));
//        obj = builder.newFileMessage(new String[]{"a", "a1", "a2"}, new String[]{"a", "a1", "a2"}, new String[]{"a", "a1", "a2"}, 0, true, "adfasdfasdf");
//        System.out.println(JsonUtil.toJSONString(obj));
//        List<NewsMessage.Article> list = new ArrayList<NewsMessage.Article>();
//        list.add(NewsMessage.newArticle("title", "desc", "url", "picurl"));
//        obj = builder.newNewsMessage(new String[]{"a", "a1", "a2"}, new String[]{"a", "a1", "a2"}, new String[]{"a", "a1", "a2"}, 0, true, list);
//        System.out.println(JsonUtil.toJSONString(obj));
//        List<Article> articles = new ArrayList<Article>();
//        articles.add(Article.newArticle("title","thumb","author","conurl","conent","digest","show"));
//        obj = builder.newMpnewsMessage(new String[]{"a", "a1", "a2"}, new String[]{"a", "a1", "a2"}, new String[]{"a", "a1", "a2"}, 0, true, articles);
//        System.out.println(JsonUtil.toJSONString(obj));
//        obj = builder.newMaterialMessage(new String[]{"a", "a1", "a2"}, new String[]{"a", "a1", "a2"}, new String[]{"a", "a1", "a2"}, 0, true, "adfasdfasdf");
//        System.out.println(JsonUtil.toJSONString(obj));
//    }
}
