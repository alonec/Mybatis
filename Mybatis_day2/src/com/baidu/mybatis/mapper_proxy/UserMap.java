package com.baidu.mybatis.mapper_proxy;

import com.baidu.mybatis.pojo.Orders;
import com.baidu.mybatis.pojo.QueryVo;
import com.baidu.mybatis.pojo.User;

import java.util.List;

public interface UserMap {
    /*
        mybatis动态代理四大原则:
        1.接口方法名 == User.xml文件中的id名一样
        2.返回值类型与Mapper.xml文件中的返回值一致
        3.方法的入参类型要与Mapper.xml中的入参类型一致
        4.命名空间要绑定此接口
     */
    // 通过id查询用户信息
    public User findUserById(Integer id);

    // 添加信息：传递pojo对象
    public  void insertUser(User user);

    //  通过用户名模糊查询：传递pojo包装对象
    public List<User> findUserByUsername(QueryVo vo);

    // 输出用户表的数据条数：输出类型（integer）
    public Integer queryUsercount();


}
