package com.wyh.springbootmybatisdemo.controller;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonAlias;

import com.wyh.springbootmybatisdemo.mapper.SportUserMapper;
import com.wyh.springbootmybatisdemo.pojo.QueryInfo;
import com.wyh.springbootmybatisdemo.pojo.SportUser;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;

@RestController
public class LoginController {

//自动装配
    @Autowired
    private SportUserMapper sportUserMapper;



    @RequestMapping("/login")
//    @RequestBody 前端只能用post方法  如果是用requestparam，则都可以使用
    public String login(@RequestBody SportUser sportuser){
//        查询结果标志，查询成功则改为ok
        String flag = "error";
//        System.out.println("login");

//        前端向后端传的值
//        System.out.println(sportuser.toString());

//        查询数据库，返回查询到的数据
        SportUser user = sportUserMapper.checkUser(sportuser.getUsername(),sportuser.getPassword());
//        return user.toString();

        if (user!=null){
            flag = "ok";
        }
//        创建map ，把数据添加进去
        HashMap<String,Object> res = new HashMap<>();
        res.put("flag",flag);
        res.put("user",user);

        String res_json = JSON.toJSONString(res);

//        System.out.println(res_json);
        return res_json;
    }


}
