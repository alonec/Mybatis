package org.myapp.junit;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.myapp.bean.User_Order;
import org.myapp.mapper.User_OrderMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class SecondTest {
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
    /**
     * 一对多关联查询
     */
    @Test
    public void testQueryUserAndOrder(){

        // 2. 创建SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            // 3. 获得mapper动态代理对象
            User_OrderMapper mapper = sqlSession.getMapper(User_OrderMapper.class);
            // 4. 进行查询，获取结果User
            List<User_Order> user_orders = mapper.queryUserOrder();
            for(User_Order userOrder : user_orders){
                System.out.println(userOrder);
                System.out.println("------------------");
            }
        }finally {
            // 4. 关闭资源
            sqlSession.close();
        }
    }
}
