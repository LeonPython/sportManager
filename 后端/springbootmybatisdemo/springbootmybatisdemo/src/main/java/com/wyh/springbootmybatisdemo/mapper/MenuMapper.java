package com.wyh.springbootmybatisdemo.mapper;

import com.wyh.springbootmybatisdemo.pojo.MainMenu;

import java.util.List;

public interface MenuMapper {
    //获取菜单
    List<MainMenu> getMenus();
}
