package com.baidu.mybatis.mapper_proxy;

import com.baidu.mybatis.pojo.User;

public interface UserMap {
    /*
        mybatis动态代理四大原则:
        1.接口方法名 == User.xml文件中的id名一样
        2.返回值类型与Mapper.xml文件中的返回值一致
        3.方法的入参类型要与Mapper.xml中的入参类型一致
        4.命名空间要绑定此接口
     */

    public User findUserById(Integer id);
}
