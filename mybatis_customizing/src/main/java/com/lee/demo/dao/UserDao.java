package com.lee.demo.dao;

import com.lee.demo.domain.User;

import java.util.List;

public interface UserDao {
    /**
     * 查询所有用户
     *
     * @return
     */
    public List<User> findAll();
}
