package com.lee.demo.mapper;

import com.lee.demo.bean.QueryVO;
import com.lee.demo.bean.User;
import org.omg.PortableInterceptor.USER_EXCEPTION;

import java.util.List;

public interface UserMapper {
    public List<User> findAll();

    public void saveUser(User user);

    public void updateUser(User user);

    public void deleteUser(Integer userId);

    public User findOne(Integer userId);

    public List<User> findUserByUsername(String username);

    public Integer findTotal();

    public List<User> getUserByQueryVo(QueryVO vo);


    public List<User> getUserByEXample(User user);


    public List<User> getUserByIds(List<Integer> ids);

    public List<User> getUserByQueryVOIds(QueryVO queryVO);

}
