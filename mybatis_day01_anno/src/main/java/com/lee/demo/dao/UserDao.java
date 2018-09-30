package com.lee.demo.dao;

import com.lee.demo.domain.User;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface UserDao {
    /**
     * 查询所有用户
     *
     * @return
     */
    @Select("select * from user")
    public List<User> findAll();

    @Select("select * from user where id=#{userId}")
    @Results(value = {@Result(id = true, property = "userId", column = "user_id"),
            @Result(property = "username", column = "user_name"),
            @Result(property = "sex", column = "sex"),
            @Result(property = "birthday", column = "birthday"),
            @Result(property = "address", column = "address")
    })
    public User findUserById(Integer userId);


    /**
     * 一对多查询
     *
     * @return
     */
    @Select("select * from user")
    @Results(value = {
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "user_name"),
            @Result(property = "sex", column = "sex"),
            @Result(property = "birthday", column = "birthday"),
            @Result(property = "accounts", column = "id",
                    many = @Many(select = "com.lee.demo.dao.AccountDAO.findAccountById", fetchType = FetchType.LAZY))
    })
    public List<User> findUserandAccoutn();

}
