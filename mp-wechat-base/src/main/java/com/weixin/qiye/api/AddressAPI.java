package com.weixin.qiye.api;

import com.weixin.common.bean.BaseResult;
import com.weixin.common.client.LocalHttpClient;
import com.weixin.mp.util.JsonUtil;
import com.weixin.qiye.bean.address.*;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/**
 * 通讯录管理
 * 1、创建部门   createDepartment
 * 2、更新部门   updateDepartment
 * 3、删除部门   deleteDepartment
 * 4 获取部门列表  listDepartment
 * 5、创建成员  createUser
 * 6、更新成员  updateUser
 * 7、删除成员  deleteUser
 * 8、批量删除成员
 * 9、获取成员
 * 10、获取部门成员
 * 11、获取部门成员(详情)
 * 12、创建标签
 * 13、更新标签名字
 * 14、删除标签
 * 15、获取标签成员
 * 16、增加标签成员
 * 17、删除标签成员
 * 18、获取标签列表
 * 19、异步任务接口（未测）
 * http://qydev.weixin.qq.com/wiki/index.php?title=%E6%88%90%E5%91%98%E5%85%B3%E6%B3%A8%E4%BC%81%E4%B8%9A%E5%8F%B7
 * Created by fang on 2015/12/31.
 */
public class AddressAPI extends BaseAPI {
    /*
    成员关注企业号

    成员必须在成功关注企业号后，才可以使用企业号的服务。成员关注时，首先要与企业通讯录中的帐号绑定；如果企业开启了二次验证，那么在绑定成功后还需要经过企业的验证，才可以关注成功。


    成员与通讯录中的帐号绑定

    成员关注企业号时，会根据成员的微信号、微信绑定的手机或邮箱，与企业通讯录的帐号匹配。如果匹配到，则绑定成功；否则会下发一条图文消息给成员，引导成员在页面上验证手机号或邮箱，验证后即绑定成功。注意，成员的微信版本需要在5.4以上，目前仅支持iOS、Android两个平台。


    二次验证

    企业在开启二次验证时，必须填写企业二次验证页面的url，此url的域名必须设置为企业小助手的可信域名。当成员绑定通讯录中的帐号后，会收到一条图文消息，引导成员到企业的验证页面验证身份。在跳转到企业的验证页面时，会带上如下参数：code=CODE&state=STATE，企业可以调用oauth2接口，根据code获取成员的userid。

    企业在成员验证成功后，调用如下接口即可让成员关注成功。

    请求说明
    */
    //Https请求方式: GET
    //https://qyapi.weixin.qq.com/cgi-bin/user/authsucc?access_token=ACCESS_TOKEN&userid=USERID
    public static BaseResult authsucc(String token,String userid){
        HttpUriRequest httpUriRequest = RequestBuilder.get()
                .setUri(BASE_URI + "/cgi-bin/user/authsucc")
                .addParameter(ACCESS_TOKEN, token)
                .addParameter("userid", userid)
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest, BaseResult.class,ChartSet);
    }

    /**
     创建部门
     Https请求方式: POST
     https://qyapi.weixin.qq.com/cgi-bin/department/create?access_token=ACCESS_TOKEN
     **/
    public static CreateDepartmentResult createDepartment(String token,DeptReq dept){
        String json = JsonUtil.toJSONString(dept);
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setUri(BASE_URI + "/cgi-bin/department/create")
                .addParameter(ACCESS_TOKEN, token)
                .setEntity(new StringEntity(json, Charset.forName("utf-8")))
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest,CreateDepartmentResult.class,ChartSet);
    }
    /**
     更新部门
     请求说明
     Https请求方式: POST
     https://qyapi.weixin.qq.com/cgi-bin/department/update?access_token=ACCESS_TOKEN
     **/
    public static CreateDepartmentResult updateDepartment(String token,DeptReq dept){
        String json = JsonUtil.toJSONString(dept);
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setUri(BASE_URI + "/cgi-bin/department/update")
                .addParameter(ACCESS_TOKEN, token)
                .setEntity(new StringEntity(json, Charset.forName("utf-8")))
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest,CreateDepartmentResult.class,ChartSet);
    }


    /**
     * 删除部门
     请求说明
     Https请求方式: GET
     https://qyapi.weixin.qq.com/cgi-bin/department/delete?access_token=ACCESS_TOKEN&id=ID
     */
    public static BaseResult deleteDepartment(String token,String id){
        HttpUriRequest httpUriRequest = RequestBuilder.get()
                .setUri(BASE_URI + "/cgi-bin/department/delete")
                .addParameter(ACCESS_TOKEN, token)
                .addParameter("id", id)
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest,BaseResult.class,ChartSet);
    }
    /**
     获取部门列表

     请求说明

     Https请求方式: GET

     https://qyapi.weixin.qq.com/cgi-bin/department/list?access_token=ACCESS_TOKEN&id=ID
     */
    public static DepartmentsResult listDepartment(String token,String id){
        HttpUriRequest httpUriRequest = RequestBuilder.get()
                .setUri(BASE_URI + "/cgi-bin/department/list")
                .addParameter(ACCESS_TOKEN, token)
                .addParameter("id", id)
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest,DepartmentsResult.class,ChartSet);
    }

    /**
     创建成员

     请求说明

     Https请求方式: POST

     https://qyapi.weixin.qq.com/cgi-bin/user/create?access_token=ACCESS_TOKEN
     mobile/weixinid/email三者不能同时为空
     */
    public static BaseResult createUser(String token,MemberUser user){
        String json = JsonUtil.toJSONString(user);
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setUri(BASE_URI + "/cgi-bin/user/create")
                .addParameter(ACCESS_TOKEN, token)
                .setEntity(new StringEntity(json, Charset.forName("utf-8")))
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest,BaseResult.class,ChartSet);
    }

    /**
     更新成员

     请求说明

     Https请求方式: POST

     https://qyapi.weixin.qq.com/cgi-bin/user/update?access_token=ACCESS_TOKEN
     */
    public static BaseResult updateUser(String token,MemberUser user){
        String json = JsonUtil.toJSONString(user);
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setUri(BASE_URI + "/cgi-bin/user/update")
                .addParameter(ACCESS_TOKEN, token)
                .setEntity(new StringEntity(json, Charset.forName("utf-8")))
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest,BaseResult.class,ChartSet);
    }

    /**
     删除成员

     请求说明

     Https请求方式: GET

     https://qyapi.weixin.qq.com/cgi-bin/user/delete?access_token=ACCESS_TOKEN&userid=USERID
     */
    public static BaseResult deleteUser(String token,String userid){
        HttpUriRequest httpUriRequest = RequestBuilder.get()
                .setUri(BASE_URI + "/cgi-bin/user/delete")
                .addParameter(ACCESS_TOKEN, token)
                .addParameter("userid", userid)
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest,BaseResult.class,ChartSet);
    }

    /**
     批量删除成员

     请求说明

     Https请求方式: POST

     https://qyapi.weixin.qq.com/cgi-bin/user/batchdelete?access_token=ACCESS_TOKEN
     */
    public static BaseResult deleteUser(String token,String[] ids){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("useridlist",ids);
        String json = JsonUtil.toJSONString(map);
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setUri(BASE_URI + "/cgi-bin/user/batchdelete")
                .addParameter(ACCESS_TOKEN, token)
                .setEntity(new StringEntity(json, Charset.forName("utf-8")))
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest,BaseResult.class,ChartSet);
    }
    /**
     获取成员

     请求说明

     Https请求方式: GET

     https://qyapi.weixin.qq.com/cgi-bin/user/get?access_token=ACCESS_TOKEN&userid=USERID
     */
    public static MemberUser getUser(String token,String userid){
        HttpUriRequest httpUriRequest = RequestBuilder.get()
                .setUri(BASE_URI + "/cgi-bin/user/get")
                .addParameter(ACCESS_TOKEN, token)
                .addParameter("userid", userid)
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest,MemberUser.class,"utf-8");
    }

    /**
     * 获取部门成员
     * @param token
     * @param department_id  获取的部门id
     * @param fetch_child    1/0：是否递归获取子部门下面的成员
     * @param status    0获取全部成员，1获取已关注成员列表，2获取禁用成员列表，4获取未关注成员列表。status可叠加，未填写则默认为4
     * @return
     */
    public static MemberUsers simplelistUser(String token,String department_id,String fetch_child,String status){
        HttpUriRequest httpUriRequest = RequestBuilder.get()
                .setUri(BASE_URI + "/cgi-bin/user/simplelist")
                .addParameter(ACCESS_TOKEN, token)
                .addParameter("department_id", department_id)
                .addParameter("fetch_child", fetch_child)
                .addParameter("status", status)
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest,MemberUsers.class,ChartSet);
    }

    /**
     * 获取部门成员(详情)
     * @param token
     * @param department_id  获取的部门id
     * @param fetch_child   1/0：是否递归获取子部门下面的成员
     * @param status 0获取全部成员，1获取已关注成员列表，2获取禁用成员列表，4获取未关注成员列表。status可叠加,未填写则默认为4
     * @return
     */
    public static MemberUsers listUser(String token,String department_id,String fetch_child,String status){
        HttpUriRequest httpUriRequest = RequestBuilder.get()
                .setUri(BASE_URI + "/cgi-bin/user/list")
                .addParameter(ACCESS_TOKEN, token)
                .addParameter("department_id", department_id)
                .addParameter("fetch_child", fetch_child)
                .addParameter("status", status)
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest, MemberUsers.class, ChartSet);
    }
    /**
     邀请成员关注

     接口说明

     认证号优先使用微信推送邀请关注，如果没有weixinid字段则依次对手机号，邮箱绑定的微信进行推送，全部没有匹配则通过邮件邀请关注。 邮箱字段无效则邀请失败。 非认证号只通过邮件邀请关注。邮箱字段无效则邀请失败。 已关注以及被禁用成员不允许发起邀请关注请求。

     为避免骚扰成员，企业应遵守以下邀请规则：

     每月邀请的总人次不超过成员上限的2倍；每7天对同一个成员只能邀请一次。

     请求说明

     Https请求方式: POST

     https://qyapi.weixin.qq.com/cgi-bin/invite/send?access_token=ACCESS_TOKEN
     */
    public static UserResult invite(String token,String userid){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("userid",userid);
        String json = JsonUtil.toJSONString(map);
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setUri(BASE_URI + "/cgi-bin/invite/send")
                .addParameter(ACCESS_TOKEN, token)
                .setEntity(new StringEntity(json, Charset.forName("utf-8")))
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest,UserResult.class,ChartSet);
    }

    /**
     创建标签

     请求说明

     Https请求方式: POST

     https://qyapi.weixin.qq.com/cgi-bin/tag/create?access_token=ACCESS_TOKEN
     */
    public static TagResult createTag(String token,Tag tag){
        String json = JsonUtil.toJSONString(tag);
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setUri(BASE_URI + "/cgi-bin/tag/create")
                .addParameter(ACCESS_TOKEN, token)
                .setEntity(new StringEntity(json, Charset.forName("utf-8")))
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest,TagResult.class,ChartSet);
    }
    /**
     更新标签名字

     请求说明

     Https请求方式: POST

     https://qyapi.weixin.qq.com/cgi-bin/tag/update?access_token=ACCESS_TOKEN
     */
    public static TagResult updateTag(String token,Tag tag){
        String json = JsonUtil.toJSONString(tag);
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setUri(BASE_URI + "/cgi-bin/tag/update")
                .addParameter(ACCESS_TOKEN, token)
                .setEntity(new StringEntity(json, Charset.forName("utf-8")))
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest,TagResult.class,ChartSet);
    }
    /**
     删除标签

     请求说明

     Https请求方式: GET

     https://qyapi.weixin.qq.com/cgi-bin/tag/delete?access_token=ACCESS_TOKEN&tagid=TAGID
      */
    public static BaseResult deleteTag(String token,String id){
        HttpUriRequest httpUriRequest = RequestBuilder.get()
                .setUri(BASE_URI + "/cgi-bin/tag/delete")
                .addParameter(ACCESS_TOKEN, token)
                .addParameter("tagid", id)
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest,BaseResult.class,ChartSet);
    }

    /**
     获取标签成员

     请求说明

     Https请求方式: GET

     https://qyapi.weixin.qq.com/cgi-bin/tag/get?access_token=ACCESS_TOKEN&tagid=TAGID
     */
    public static MemberUsers getMembers(String token,String tagid){
        HttpUriRequest httpUriRequest = RequestBuilder.get()
                .setUri(BASE_URI + "/cgi-bin/tag/get")
                .addParameter(ACCESS_TOKEN, token)
                .addParameter("tagid", tagid)
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest,MemberUsers.class,ChartSet);
    }

    /**
     增加标签成员

     请求说明

     Https请求方式: POST

     https://qyapi.weixin.qq.com/cgi-bin/tag/addtagusers?access_token=ACCESS_TOKEN
     */
    public static BaseResult addTagUser(String token,TagUserReq user){
        String json = JsonUtil.toJSONString(user);
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setUri(BASE_URI + "/cgi-bin/tag/addtagusers")
                .addParameter(ACCESS_TOKEN, token)
                .setEntity(new StringEntity(json, Charset.forName("utf-8")))
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest,BaseResult.class,ChartSet);
    }

    /**
     删除标签成员

     请求说明

     Https请求方式: POST

     https://qyapi.weixin.qq.com/cgi-bin/tag/deltagusers?access_token=ACCESS_TOKEN
     */
    public static BaseResult delTagUser(String token,TagUserReq user){
        String json = JsonUtil.toJSONString(user);
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setUri(BASE_URI + "/cgi-bin/tag/deltagusers")
                .addParameter(ACCESS_TOKEN, token)
                .setEntity(new StringEntity(json, Charset.forName("utf-8")))
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest,BaseResult.class,ChartSet);
    }
    /**
     获取标签列表

     请求说明

     Https请求方式: GET

     https://qyapi.weixin.qq.com/cgi-bin/tag/list?access_token=ACCESS_TOKEN
      */
    public static TagResult getTagList(String token){
        HttpUriRequest httpUriRequest = RequestBuilder.get()
                .setUri(BASE_URI + "/cgi-bin/tag/list")
                .addParameter(ACCESS_TOKEN, token)
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest,TagResult.class,ChartSet);
    }

    /**
     邀请成员关注

     接口说明

     请参考(邀请成员关注)的接口说明

     请求说明

     Https请求方式: POST

     https://qyapi.weixin.qq.com/cgi-bin/batch/inviteuser?access_token=ACCESS_TOKEN
     */
    public static UserResult inviteUser(String token,InviteUserReq user){
        String json = JsonUtil.toJSONString(user);
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setUri(BASE_URI + "/cgi-bin/batch/inviteuser")
                .addParameter(ACCESS_TOKEN, token)
                .setEntity(new StringEntity(json, Charset.forName("utf-8")))
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest,UserResult.class,ChartSet);
    }

    /**
     增量更新成员

     接口说明

     本接口以userid为主键，增量更新企业号通讯录成员。请先下载CSV模板(下载增量更新成员模版)，根据需求填写文件内容。

     注意事项：

     1.模板中的部门需填写部门ID，多个部门用分号分隔，部门ID必须为数字
     2.文件中存在、通讯录中也存在的成员，更新成员在文件中指定的字段值
     3.文件中存在、通讯录中不存在的成员，执行添加操作
     4.通讯录中存在、文件中不存在的成员，保持不变
     5.成员字段更新规则：文件中有指定的字段，以指定的字段值为准；文件中没指定的字段，不更新

     请求说明

     Https请求方式: POST

     https://qyapi.weixin.qq.com/cgi-bin/batch/syncuser?access_token=ACCESS_TOKEN
     */
    public static UserResult batchUpdateUser(String token,InviteUserReq user){
        String json = JsonUtil.toJSONString(user);
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setUri(BASE_URI + "/cgi-bin/batch/syncuser")
                .addParameter(ACCESS_TOKEN, token)
                .setEntity(new StringEntity(json, Charset.forName("utf-8")))
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest,UserResult.class,ChartSet);
    }


    /**
     全量覆盖成员

     接口说明

     本接口以userid为主键，全量覆盖企业号通讯录成员，任务完成后企业号通讯录成员与提交的文件完全保持一致。请先下载CSV文件(下载全量覆盖成员模版)，根据需求填写文件内容。
     注意事项：
     1.模板中的部门需填写部门ID，多个部门用分号分隔，部门ID必须为数字
     2.文件中存在、通讯录中也存在的成员，完全以文件为准
     3.文件中存在、通讯录中不存在的成员，执行添加操作
     4.通讯录中存在、文件中不存在的成员，执行删除操作。出于安全考虑，如果:
     a) 需要删除的成员多于50人，且多于现有人数的20%以上
     b) 需要删除的成员少于50人，且多于现有人数的80%以上
     系统将中止导入并返回相应的错误码
     5.成员字段更新规则：文件中有指定的字段，以指定的字段值为准；文件中没指定的字段，不更新

     请求说明

     Https请求方式: POST

     https://qyapi.weixin.qq.com/cgi-bin/batch/replaceuser?access_token=ACCESS_TOKEN
     */
    public static UserResult batchReplaceUser(String token,InviteUserReq user){
        String json = JsonUtil.toJSONString(user);
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setUri(BASE_URI + "/cgi-bin/batch/replaceuser")
                .addParameter(ACCESS_TOKEN, token)
                .setEntity(new StringEntity(json, Charset.forName("utf-8")))
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest,UserResult.class,ChartSet);
    }


    /**
     全量覆盖部门

     接口说明

     本接口以partyid为键，全量覆盖企业号通讯录组织架构，任务完成后企业号通讯录组织架构与提交的文件完全保持一致。请先下载CSV文件(下载全量覆盖部门模版)，根据需求填写文件内容。
     注意事项：
     1.文件中存在、通讯录中也存在的部门，执行修改操作
     2.文件中存在、通讯录中不存在的部门，执行添加操作
     3.文件中不存在、通讯录中存在的部门，当部门下没有任何成员或子部门时，执行删除操作
     4.CSV文件中，部门名称、部门ID、父部门ID为必填字段，部门ID必须为数字；排序为可选字段，置空或填0不修改排序

     请求说明

     Https请求方式: POST

     https://qyapi.weixin.qq.com/cgi-bin/batch/replaceparty?access_token=ACCESS_TOKEN
     */
    public static UserResult batchReplaceParty(String token,InviteUserReq user){
        String json = JsonUtil.toJSONString(user);
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setUri(BASE_URI + "/cgi-bin/batch/replaceparty")
                .addParameter(ACCESS_TOKEN, token)
                .setEntity(new StringEntity(json, Charset.forName("utf-8")))
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest,UserResult.class,ChartSet);
    }

    /**
     *
     获取异步任务结果

     请求说明

     Https请求方式: GET

     https://qyapi.weixin.qq.com/cgi-bin/batch/getresult?access_token=ACCESS_TOKEN&jobid=JOBID
     */
    public static JobResult batchGetResule(String token,String jobid){
        HttpUriRequest httpUriRequest = RequestBuilder.get()
                .setUri(BASE_URI + "/cgi-bin/batch/getresult")
                .addParameter(ACCESS_TOKEN, token)
                .addParameter("jobid", jobid)
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest,JobResult.class,ChartSet);
    }
}

