package org.myapp.junit;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.myapp.bean.User;
import org.myapp.proxy.UserMapper;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Auther: chenxin
 * @Date: 2018/7/19 23:23
 * @Description: 测试Mapper动态代理开发
 */
public class ProxyTest {
    private SqlSessionFactory sqlSessionFactory = null;
    // SqlSessionFactory应该在应用程序执行期间一直存在（即只被创建一次）
    @Before
    public void before(){
        // 1. 创建 SqlSessionFactory工厂
        InputStream in = null;
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        try {
            in = Resources.getResourceAsStream("org/data/SqlMapConfig.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSessionFactory = sqlSessionFactoryBuilder.build(in);
    }

    @Test
    public void testFindUserByID(){

        // 2. 创建SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            // 3. 获得mapper动态代理对象
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            // 4. 进行查询，获取结果User
            User user = mapper.findUserByID(1);
            System.out.println(user);
        }finally {
            // 4. 关闭资源
            sqlSession.close();
        }
    }
}