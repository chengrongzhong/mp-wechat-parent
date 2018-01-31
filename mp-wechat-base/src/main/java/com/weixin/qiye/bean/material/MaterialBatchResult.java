package com.weixin.qiye.bean.material;

import com.weixin.common.bean.BaseResult;

import java.util.List;

/**
 * Created by fang on 2016/1/4.
 */
public class MaterialBatchResult extends BaseResult {
    private String type;
    private int total_count;
    private int item_count;
    private List<Object> itemlist;
}
