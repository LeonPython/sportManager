package com.wyh.springbootmybatisdemo.mapper;

import com.wyh.springbootmybatisdemo.pojo.SportUser;
import com.wyh.springbootmybatisdemo.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SportUserMapper {
//    通过用户名和密码，查询用户
    SportUser checkUser(@Param("username") String username, @Param("password") String password);
//    查询所有用户 模糊查询 参数：用户名，页的开始和一页最大多少个
    List<SportUser> getAllUser(@Param("username")String username,@Param("pagestart")int pagestart,@Param("pagesize")int pagesize);
//返回这个查询规则下的用户数量
    int getUserCounts(@Param("username")String username);
//    更新状态值 返回的是数值0/1
    int updateState(int id,boolean state);
    //添加新用户 返回的是数值0/1
    int addNewUser(@Param("username")String username,
                   @Param("password")String password,
                   @Param("email")String email,
                   @Param("role")String role,
                   @Param("state")Boolean state);
    //删除某个用户
    int deleteUser(int id);
//    编辑用户
    int editUser(@Param("username")String username,
                 @Param("password")String password,
                 @Param("email")String email,
                 @Param("id")int id);
}

