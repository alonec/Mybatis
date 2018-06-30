package com.baidu.mybatis.junit;

import com.baidu.mybatis.mapper_proxy.UserMap;
import com.baidu.mybatis.pojo.QueryVo;
import com.baidu.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class MybatisMapTest {
    // 通过id查询用户信息 : 传递简单类型
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
        // mybatis和spring整合，整合之后，交给spring管理
        sqlSession.close();
    }
    // 添加信息：传递pojo对象
    @Test
    public  void testinsertUser() throws Exception{
        //加载核心配置文件
        String resource = "sqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        //创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        //创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 用sqlSession生成一个实现类，给接口UserMap
        UserMap userMap = sqlSession.getMapper(UserMap.class);
        User user = new User();
        user.setUsername("成龙");
        user.setSex("1");
        userMap.insertUser(user);
        // 提交事务
        sqlSession.commit();
       // mybatis和spring整合，整合之后，交给spring管理
        sqlSession.close();
    }
    // 通过用户名模糊查询：传递pojo包装对象
    @Test
    public  void testfindUserByUsername() throws Exception{
        //加载核心配置文件
        String resource = "sqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        //创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        //创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 用sqlSession生成一个实现类，给接口UserMap
        UserMap userMap = sqlSession.getMapper(UserMap.class);
        User user = new User();
        user.setUsername("五");
        QueryVo vo = new QueryVo();
        vo.setUser(user);

        List<User> list = userMap.findUserByUsername(vo);
        for (User users:list) {
            System.out.println(users);
        }
        // mybatis和spring整合，整合之后，交给spring管理
        sqlSession.close();
    }
    // 输出用户表的数据条数：输出类型（integer）
    @Test
    public  void queryUsercount() throws Exception{
        //加载核心配置文件
        String resource = "sqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        //创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        //创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 用sqlSession生成一个实现类，给接口UserMap
        UserMap userMap = sqlSession.getMapper(UserMap.class);

        Integer i = userMap.queryUsercount();
        System.out.println(i);
        // mybatis和spring整合，整合之后，交给spring管理
        sqlSession.close();
    }
}
