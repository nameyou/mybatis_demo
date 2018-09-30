package com.lee.demo.dao;

import com.lee.demo.domain.Account;
import com.lee.demo.domain.User;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface AccountDAO {


    @Select("select * from account")
    public List<Account> findAll();


    /**
     * 根据id查询用户
     *
     * @param userId
     * @return
     */
    @Select("select * from account where user_id=#{userId}")
    @Results(value = {@Result(id = true, property = "accountId", column = "account_id"),
            @Result(property = "money", column = "money"),
            @Result(property = "userId", column = "user_id")
    })
    public Account findAccountById(Integer userId);


    /**
     * 一对一查询
     *
     * @return
     */
    @Select("select * from account")
    @Results(value = {
            @Result(id = true, property = "accountId", column = "account_id"),
            @Result(property = "money", column = "money"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "user", column = "user_id", one = @One(select = "com.lee.demo.dao.UserDao.findUserById", fetchType = FetchType.EAGER))
    })
    public List<Account> findAccountAndUser();
}
