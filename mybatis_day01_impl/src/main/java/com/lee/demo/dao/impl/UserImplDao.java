package com.lee.demo.dao.impl;

import com.lee.demo.dao.UserDao;
import com.lee.demo.domain.User;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UserImplDao implements UserDao {

    private SqlSession sqlSession;

    public UserImplDao(SqlSession sqlSession){
        this.sqlSession=sqlSession;
    }


    public List<User> findAll() {
        return sqlSession.selectList("com.lee.demo.dao.UserDao.findAll");
    }
}
