package com.lee.demo.mapper;


import com.lee.demo.bean.Account;
import com.lee.demo.bean.User;

import java.util.List;

public interface UserMapper {

    public List<Account> findAccoutAndUser();

    public List<User> findUserAndAccount();

}
