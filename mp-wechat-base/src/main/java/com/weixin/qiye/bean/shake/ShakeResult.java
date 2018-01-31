package com.weixin.qiye.bean.shake;

import com.weixin.common.bean.BaseResult;

/**
 * Created by fang on 2016/1/12.
 */
public class ShakeResult extends BaseResult {
    private Data data;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public static Data newData(int page_id,BeaconInfo info,String userid){
        return new Data(page_id,info,userid);
    }

    public static class Data{
        private int page_id;
        private BeaconInfo beacon_info;
        private String userid;

        public Data() {

        }
        public Data(int page_id, BeaconInfo info, String userid) {
            this.page_id = page_id;
            this.beacon_info = info;
            this.userid = userid;
        }

        public int getPage_id() {
            return page_id;
        }

        public void setPage_id(int page_id) {
            this.page_id = page_id;
        }

        public BeaconInfo getBeacon_info() {
            return beacon_info;
        }

        public void setBeacon_info(BeaconInfo beacon_info) {
            this.beacon_info = beacon_info;
        }

        public String getUserid() {
            return userid;
        }

        public void setUserid(String userid) {
            this.userid = userid;
        }
    }
}
