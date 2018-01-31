package com.weixin.qiye.bean.im;

import com.weixin.common.bean.BaseResult;

/**
 * Created by fang on 2016/1/11.
 */
public class ChatInfoResult extends BaseResult {
    private ChatInfo chat_info;

    public ChatInfo getChat_info() {
        return chat_info;
    }

    public void setChat_info(ChatInfo chat_info) {
        this.chat_info = chat_info;
    }
}
