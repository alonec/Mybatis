package com.baidu.mybatis.dao;

import com.baidu.mybatis.pojo.User;

public interface UserDao {
    // 通过用户ID查询用户信息
    User selectUserById(Integer id);
}
