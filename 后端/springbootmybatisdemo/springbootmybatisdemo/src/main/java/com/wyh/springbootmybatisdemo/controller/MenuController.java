package com.wyh.springbootmybatisdemo.controller;

import com.alibaba.fastjson.JSON;
import com.wyh.springbootmybatisdemo.mapper.MenuMapper;
import com.wyh.springbootmybatisdemo.pojo.MainMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class MenuController {
    @Autowired
    private MenuMapper menuMapper;

    @RequestMapping("/menus")
    public String getAllMenu(){
//        System.out.println("返回菜单");
        HashMap<String,Object> data = new HashMap<>();
        int flag = 404;//错误404 成功200

        List<MainMenu> menu = menuMapper.getMenus();

        if (menu!=null){
            flag =200;
        }
//        存入map
        data.put("menus",menu);
        data.put("flag",flag);
//        转为json，返回
        String reJson = JSON.toJSONString(data);
//        System.out.println(reJson);

        return reJson;
    }
}
