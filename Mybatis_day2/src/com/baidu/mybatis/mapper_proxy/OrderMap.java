package com.baidu.mybatis.mapper_proxy;

import com.baidu.mybatis.pojo.Orders;
import com.baidu.mybatis.pojo.QueryVo;
import com.baidu.mybatis.pojo.User;

import java.util.List;

public interface OrderMap {
    // 查询所有订单 : resultMap手动映射
    public List<Orders> queryOrderAll();

    //根据多个id查询用户信息 : 向sql传递数组或List，或包装数组，list，mybatis使用foreach解析
//    public List<Orders> foreachTest(QueryVo queryVo);
      public List<Orders> foreachTest(List list);

      // 一对一关联：使用resultMap查询所有用户订单
      public List<Orders> queryOrderUserResultMap();

      // 一对多关联：使用resultMap查询所有用户信息及用户关联的订单信息。
      public List<User> queryUserOrder();

}
