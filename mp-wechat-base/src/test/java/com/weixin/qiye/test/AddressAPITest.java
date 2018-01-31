package com.weixin.qiye.test;

import com.weixin.common.bean.BaseResult;
import com.weixin.qiye.api.AddressAPI;
import com.weixin.qiye.bean.address.*;

import java.io.UnsupportedEncodingException;

/**
 * Created by sdyang on 2016/4/20.
 */
public class AddressAPITest {
    private static String  accessToken = "IJwOsIbY0PNGM74JW0OexVS3cW2VXwtvTKoac0XPSJbt3jO8s2FsKTnu8fdKSnUE";

    public static void main(String[] args) throws UnsupportedEncodingException {

        //创建部门
//        DeptReq dept = new DeptReq();
//        dept.setName("测试");
//        dept.setParentid("1");
//        CreateDepartmentResult result = AddressAPI.createDepartment(accessToken, dept);

        //更新部门
//        DeptReq dept = new DeptReq();
//        dept.setId("2");
//        dept.setName("测试1");
//        BaseResult result = AddressAPI.updateDepartment(accessToken, dept);

        //删除部门
//        BaseResult result = AddressAPI.deleteDepartment(accessToken, "3");


        //获取部门列表   中文乱码
//        DepartmentsResult result = AddressAPI.listDepartment(accessToken,"1");
//        for(DeptReq r:result.getDepartment()){
//            System.out.println(r.getName());
//        }

        //创建成员
//        MemberUser user = new MemberUser();
//        user.setUserid("test2");
//        user.setDepartment(new String[]{"1"});
//        user.setName("测试2");
//        user.setEmail("125612@qq.com");
//        BaseResult result = AddressAPI.createUser(accessToken, user);

        //更新成员
//        BaseResult result = AddressAPI.updateUser(accessToken, user);

        //删除成员
//        BaseResult result = AddressAPI.deleteUser(accessToken,"test");

        //批量删除成员
//        BaseResult result = AddressAPI.deleteUser(accessToken,new String[]{"test1","test2"});

        //获取成员  中文乱码
          MemberUser result =  AddressAPI.getUser(accessToken, "02223");
          System.out.println(result.getName());

        //获取部门成员
//        MemberUsers result = AddressAPI.simplelistUser(accessToken,"1","0","0");

        //获取部门成员(详情)
//        MemberUsers result = AddressAPI.listUser(accessToken,"1","0","0");

        //创建标签
//        Tag tag = new Tag();
//        tag.setTagid("3");
//        tag.setTagname("测试3");
//        TagResult result = AddressAPI.createTag(accessToken,tag);
//        System.out.println(String.format("tagid:%s",result.getTagid()));

        //更新标签
//        TagResult result = AddressAPI.updateTag(accessToken, tag);

        //删除标签
//        BaseResult result = AddressAPI.deleteTag(accessToken, "1");

        //获取标签成员
//        MemberUsers result = AddressAPI.getMembers(accessToken,"2");

        //增加标签成员
//        TagUserReq user = new TagUserReq();
//        user.setTagid("2");
//        user.setUserlist(new String[]{"3sf"});
//        BaseResult result = AddressAPI.addTagUser(accessToken, user);

        //删除标签成员
//        BaseResult result = AddressAPI.delTagUser(accessToken, user);

        //获取标签列表
//        TagResult result = AddressAPI.getTagList(accessToken);

        //邀请成员关注  报错：api forbidden
//        BaseResult result = AddressAPI.invite(accessToken, "3sf");

        //二次验证   报错：user status invalid
//        BaseResult result = AddressAPI.authsucc(accessToken,"3sf");


        //----------------异步任务接口测试------------------//
        System.out.println(result.getErrmsg());
    }
}
