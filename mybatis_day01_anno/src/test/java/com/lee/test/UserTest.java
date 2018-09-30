package com.lee.test;

import com.lee.demo.dao.AccountDAO;
import com.lee.demo.dao.UserDao;
import com.lee.demo.domain.Account;
import com.lee.demo.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class UserTest {

    @Test
    public void testFindAll() throws IOException {
        //1. 读取配置文件
        InputStream inputStream = Resources.getResourceAsStream("SqlMapperConfig.xml");
        //2. 创建SqlSessionFactoryBuild对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        // 3. 创建SqlSessionFactory对象
        SqlSessionFactory sessionFactory = builder.build(inputStream);
        // 4. 创建SqlSession对象
        SqlSession sqlSession = sessionFactory.openSession();
        // 5. 创建UserDao的代理对象
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        AccountDAO accountDAO = sqlSession.getMapper(AccountDAO.class);
        // 6. 执行查询
//        List<User> users = userDao.findAll();
//        for (User user : users) {
//            System.out.println(user);
//        }

        System.out.println("=========一对多================");
        List<Account> accountAndUser = accountDAO.findAccountAndUser();
        for (Account account : accountAndUser) {
            System.out.println(account);
            System.out.println(account.getUser());
        }


        System.out.println("============根据id查询用户信息===============");
        User userById = userDao.findUserById(10);
        System.out.println(userById);
        System.out.println("============根据id查询z账户===============");
        Account accountById = accountDAO.findAccountById(24);
        System.out.println(accountById);

        System.out.println("-========一对多==============");
        List<User> userandAccoutn = userDao.findUserandAccoutn();
        for (User user : userandAccoutn) {
            System.out.println(user);
            System.out.println(user.getAccounts());
        }
        Map.Entry map= (Map.Entry) new HashMap();
        map.setValue("d");

        map.getKey();

        List list=new ArrayList();


        //

        // 7. 释放链接
        sqlSession.close();
        inputStream.close();
    }
}
