package com.baidu.mybatis.junit;
/**
 * 注意：map文件已经更改了，要重新写测试方法
 */

import com.baidu.mybatis.dao.UserDao;
import com.baidu.mybatis.dao.UserDaoImp;
import com.baidu.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

public class MyBatisDaoTest {
    public SqlSessionFactory sqlSessionFactory;
    @Before
    public void before() throws Exception {
        //加载核心配置文件
        String resource = "sqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        //创建SqlSessionFactory
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
    }
    @Test
    public void testDao()throws Exception{
        UserDaoImp userDaoImp = new UserDaoImp(sqlSessionFactory);
        User user = userDaoImp.selectUserById(37);
        System.out.println(user);
    }

}
