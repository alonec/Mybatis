package com.baidu.mybatis.junit;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.List;

import com.baidu.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

/**
 * 注意：map文件已经更改了，要重新写测试方法
 */
public class MyBatisFirstTest {
    @Test
    public void testfindUserById() {
        //加载核心配置文件
        String resource = "sqlMapConfig.xml";
        InputStream in = null;
        try {
            in = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        //创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //执行Sql语句
        User user = sqlSession.selectOne("test.findUserById", 10);

        System.out.println(user);
        sqlSession.close();
    }

    // 通过用户名模糊查询用户信息
    @Test
    public void testfindUserByUsername() {
        //加载核心配置文件
        String resource = "sqlMapConfig.xml";
        InputStream in = null;
        try {
            in = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        //创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //执行Sql语句
        List<User> users = sqlSession.selectList("test.findUserByUsername", "五");
        for (User user2 : users) {
            System.out.println(user2);
        }
        sqlSession.close();
    }
    // 添加信息
    @Test
    public void testInsertUser() {
        //加载核心配置文件
        String resource = "sqlMapConfig.xml";
        InputStream in = null;
        try {
            in = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        //创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //执行Sql语句
        User user = new User();
        user.setUsername("曾志伟");
        user.setBirthday(new Date(8099));
        user.setSex("1");
        user.setAddress("ane45678912");

        int i = sqlSession.insert("test.InserUser", user);
        System.out.println(i);// 影响了几行
        // 提交事务。只有提交了事务，数据库中表才能更新
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void testInserUserAndReturnId() {
        //加载核心配置文件
        String resource = "sqlMapConfig.xml";
        InputStream in = null;
        try {
            in = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        //创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //执行Sql语句
        User user = new User();
        user.setUsername("何炅");
        user.setBirthday(new Date(8099));
        user.setSex("1");
        user.setAddress("bbb");

        int i = sqlSession.insert("test.InserUserAndReturnId", user);

        // 提交事务。只有提交了事务，数据库中表才能更新
        sqlSession.commit();
        System.out.println(i);// 影响了几行
        System.out.println(user.getId());
        sqlSession.close();
    }

}
