package com.weixin.mp.bean;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fang on 2016/1/11.
 */
public class AdapterArray extends XmlAdapter<String,List<String>> {
    @Override
    public List<String> unmarshal(String v) throws Exception {
        String[] values = v.split("\\|");
        ArrayList<String> list = new ArrayList<String>();
        for(String item:values){
            list.add(item);
        }
        return list;
    }

    @Override
    public String marshal(List<String> v) throws Exception {
        if (null==v){
            return null;
        }
        StringBuffer sb = new StringBuffer();
        int count = v.size();
        for(int i=0;i<count;i++){
            sb.append(v.get(i));
            if (i<count-1){
                sb.append("|");
            }
        }
        return sb.toString();
    }
}
