package com.baidu.mybatis.junit;

import com.baidu.mybatis.mapper_proxy.UserMap;
import com.baidu.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;

public class MybatisMapTest {
    @Test
     public  void testMapper() throws Exception{
        //加载核心配置文件
        String resource = "sqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        //创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        //创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 用sqlSession生成一个实现类，给接口UserMap
        UserMap userMap = sqlSession.getMapper(UserMap.class);

        User user = userMap.findUserById(10);
        System.out.print(user);
    }
}
