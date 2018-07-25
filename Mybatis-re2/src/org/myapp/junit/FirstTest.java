package org.myapp.junit;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.myapp.bean.Order;
import org.myapp.bean.User;
import org.myapp.bean.User_Order;
import org.myapp.mapper.OrderMapper;
import org.myapp.mapper.UserMapper;
import org.myapp.mapper.User_OrderMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

public class FirstTest {
    private SqlSessionFactory sqlSessionFactory = null;
    // SqlSessionFactory应该在应用程序执行期间一直存在（即只被创建一次）
    @Before
    public void before(){
        // 1. 创建 SqlSessionFactory工厂
        InputStream in = null;
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        try {
            in = Resources.getResourceAsStream("org/data/config/SqlMapConfig.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSessionFactory = sqlSessionFactoryBuilder.build(in);
    }
    @Test
    public void testQueryOrderByChoose(){

        // 2. 创建SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            // 3. 获得mapper动态代理对象
            OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
            // 4. 进行查询，获取结果User
            HashMap<String, Object> map = new HashMap();
            map.put("id",3);
            List<Order> orders = mapper.queryOrderByChoose(map);
            for(Order order1 : orders){
                System.out.println(order1);
                System.out.println("------------------");
            }
        }finally {
            // 4. 关闭资源
            sqlSession.close();
        }
    }

    @Test
    public void testQueryOrderByCont(){

        // 2. 创建SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            // 3. 获得mapper动态代理对象
            OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
            // 4. 进行查询，获取结果User
            HashMap<String, Object> map = new HashMap();
            Order order = new Order();
            order.setId(3);
            // map.put("id",3);
            map.put("order",order);
            List<Order> orders = mapper.queryOrderByCont(map);
            for(Order order1 : orders){
                System.out.println(order1);
                System.out.println("------------------");
            }
        }finally {
            // 4. 关闭资源
            sqlSession.close();
        }
    }


    @Test
    public void testFindUserByID(){

        // 2. 创建SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            // 3. 获得mapper动态代理对象
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            // 4. 进行查询，获取结果User
            User user = mapper.queryUserById(1);
            System.out.println(user);
        }finally {
            // 4. 关闭资源
            sqlSession.close();
        }
    }
}
