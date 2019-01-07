package com.lee.demo.mapper;

import com.lee.demo.bean.QueryVO;
import com.lee.demo.bean.User;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

public interface UserMapper {
    public List<User> findAll();

//    @SelectProvider(type = "",method = )
    public void saveUser(User user);

    public void updateUser(User user);

    public void deleteUser(Integer userId);

    public User findOne(Integer userId);

    public List<User> findUserByUsername(String username);

    public Integer findTotal();

    public List<User> getUserByQueryVo(QueryVO vo);
}
