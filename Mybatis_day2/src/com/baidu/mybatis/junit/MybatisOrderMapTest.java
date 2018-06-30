package com.baidu.mybatis.junit;

import com.baidu.mybatis.mapper_proxy.OrderMap;
import com.baidu.mybatis.pojo.Orders;
import com.baidu.mybatis.pojo.QueryVo;
import com.baidu.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MybatisOrderMapTest {
    //查询所有订单 : resultMap手动映射
    @Test
    public void testqueryOrderAll() throws Exception {
        //加载核心配置文件
        String resource = "sqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        //创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        //创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 用sqlSession生成一个实现类，给接口UserMap
        OrderMap orderMap = sqlSession.getMapper(OrderMap.class);
        List<Orders> list = orderMap.queryOrderAll();
        for (Orders order: list) {
            System.out.println(order);
        }
        // mybatis和spring整合，整合之后，交给spring管理
        sqlSession.close();
    }
    //根据多个id查询用户信息 : 向sql传递数组或List，或包装数组，list，mybatis使用foreach解析
    @Test
    public void testforeachTest() throws Exception {
        //加载核心配置文件
        String resource = "sqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        //创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        //创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 用sqlSession生成一个实现类，给接口UserMap
        OrderMap orderMap = sqlSession.getMapper(OrderMap.class);
        int ids[] = {3,4,5};
        List<Integer> list = new ArrayList();
        list.add(3);
        list.add(4);
        list.add(5);
//        QueryVo queryVo = new QueryVo();
//        queryVo.setIds(ids);
        List<Orders> lists = orderMap.foreachTest(list);
        for (Orders order:lists) {
            System.out.println(order);
        }
        // mybatis和spring整合，整合之后，交给spring管理
        sqlSession.close();
    }
    // 一对一关联：使用resultMap查询所有用户订单
    @Test
    public void testqueryOrderUserResultMap() throws Exception {
        //加载核心配置文件
        String resource = "sqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        //创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        //创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 用sqlSession生成一个实现类，给接口UserMap
        OrderMap orderMap = sqlSession.getMapper(OrderMap.class);
        List<Orders> orders = orderMap.queryOrderUserResultMap();
        for (Orders order:orders
             ) {
            System.out.println(order);
        }
        // mybatis和spring整合，整合之后，交给spring管理
        sqlSession.close();
    }
    // 一对多关联：使用resultMap查询所有用户信息及用户关联的订单信息。
    @Test
    public void testqueryUserOrder() throws Exception {
        //加载核心配置文件
        String resource = "sqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        //创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        //创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 用sqlSession生成一个实现类，给接口UserMap
        OrderMap orderMap = sqlSession.getMapper(OrderMap.class);
        List<User> users = orderMap.queryUserOrder();

        for (User user:users
             ) {
            System.out.println(user);
        }
        // mybatis和spring整合，整合之后，交给spring管理
        sqlSession.close();
    }

}
