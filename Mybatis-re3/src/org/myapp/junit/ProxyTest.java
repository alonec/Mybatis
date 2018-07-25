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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    /**
     * 通过Map更新用户---------测试set
     */
    @Test
    public void testDeleteUserByIDList(){

        // 2. 创建SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            // 3. 获得mapper动态代理对象
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            // 4. 执行sql
            List<Integer> list = new ArrayList<Integer>();
            list.add(27);
            list.add(28);
            mapper.deleteUserByIDList(list);
            sqlSession.commit();
        }finally {
            // 4. 关闭资源
            sqlSession.close();
        }
    }
    /**
     * 通过Map更新用户---------测试set
     */
    @Test
    public void testUpdateUserByMap(){

        // 2. 创建SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            // 3. 获得mapper动态代理对象
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            // 4. 执行sql
            Map<String,Object> map = new HashMap();
            User user = new User("柯基",null,"1",null);
            user.setId(27);
            map.put("user",user);
            mapper.updateUserByMap(map);

            sqlSession.commit();
        }finally {
            // 4. 关闭资源
            sqlSession.close();
        }
    }

    /**
     * 通过Map添加用户---------测试trim
     */
    @Test
    public void testInsertUserByMap(){

        // 2. 创建SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            // 3. 获得mapper动态代理对象
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            // 4. 执行sql
            Map<String,Object> map = new HashMap();
            User user = new User("哈士奇",null,"1",null);
            map.put("user",user);
            mapper.insertUserByMap(map);

            sqlSession.commit();
        }finally {
            // 4. 关闭资源
            sqlSession.close();
        }
    }
}