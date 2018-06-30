package com.baidu.mybatis.dao;

import com.baidu.mybatis.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UserDaoImp implements UserDao{
    private SqlSessionFactory sqlSessionFactory;

    // 注入
    public UserDaoImp(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }
    // 通过用户ID查询一个用户
    @Override
    public User selectUserById(Integer id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession.selectOne("test.findUserById",id);
    }
}
