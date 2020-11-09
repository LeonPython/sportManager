package com.wyh.springbootmybatisdemo.controller;


import com.alibaba.fastjson.JSON;
import com.wyh.springbootmybatisdemo.mapper.SportUserMapper;
import com.wyh.springbootmybatisdemo.pojo.QueryInfo;
import com.wyh.springbootmybatisdemo.pojo.SportUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class SportUserController {
    @Autowired
    SportUserMapper sportUserMapper;

    @RequestMapping("/test")
    public String test(){
        int a = sportUserMapper.getUserCounts("admin");
        List<SportUser> b = sportUserMapper.getAllUser("%admin%", 1, 5);
//        return a+"";
        return b.toString();
    }


    @RequestMapping("/alluser")
    public String getUserList(QueryInfo queryInfo){

        //获取满足查询要求的用户数量，%表示任意0个或多个字符，模糊查询
        int numbers = sportUserMapper.getUserCounts("%" + queryInfo.getQuery() + "%");
        //当前页开始的数字
        int pageStart = (queryInfo.getPageNum() - 1)*queryInfo.getPageSize();

//        查询用户列表
        List<SportUser> users = sportUserMapper.getAllUser("%" + queryInfo.getQuery() + "%", pageStart, queryInfo.getPageSize());

        HashMap<String,Object> res = new HashMap<>();
        res.put("numbers",numbers);
        res.put("data",users);

        String res_string = JSON.toJSONString(res);

        return res_string;
    };
//    更新用户状态
    @RequestMapping("/updatestate")
    public String updateUserState(@RequestParam("id")int id,@RequestParam("state")boolean state){
//        修改数据库，并返回修改结果，1表示成功，0表示失败
        int updateFlag = sportUserMapper.updateState(id, state);
//        System.out.println(updateFlag);
        return updateFlag+"";
    };
//    新增用户
    @RequestMapping("/adduser")
    public String addUser(@RequestBody SportUser sportUser){
        int addFlag = sportUserMapper.addNewUser(sportUser.getUsername(),sportUser.getPassword(),sportUser.getEmail(),sportUser.getRole(),sportUser.getState());
//        int addFlag = sportUserMapper.addNewUser("leon111","1234","qqmail","普通用户",true);

        return addFlag+"";
    }
//    删除用户
    @RequestMapping("/deleteuser")
    public String deleteUser(@RequestParam("id")int id){

        int deleteFlag = sportUserMapper.deleteUser(id);
//        System.out.println(deleteFlag);
        return deleteFlag+"";

    }
    //编辑用户
    @RequestMapping("/edituser")
    public String editUser(@RequestBody SportUser sportUser){

        int editFlag = sportUserMapper.editUser(sportUser.getUsername(),sportUser.getPassword(),sportUser.getEmail(),sportUser.getId());
        return editFlag+"";

    }



}
