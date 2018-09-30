package com.lee.test;

import com.lee.demo.bean.Account;
import com.lee.demo.bean.User;
import com.lee.demo.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserTest {
    private SqlSessionFactory sqlSessionFactory;
    private InputStream inputStream;
    private SqlSession sqlSession;

    @Before //就是在执行@Test方法之前执行
    public void init() throws Exception {
        //1.读取配置文件
        inputStream = Resources.getResourceAsStream("sqlMapperConfig.xml");
        //2.创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        // 3. 创建sqlSessoinFactory对象
        sqlSessionFactory = builder.build(inputStream);
    }

    @After //执行@Test方法之后执行
    public void destory() throws Exception {
        // 7. 释放资源
        sqlSession.close();
        inputStream.close();
    }


    /**
     * 测试一对一
     */
    @Test
    public void testOne2One() {
        sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<Account> accoutAndUser = mapper.findAccoutAndUser();
        for (Account account : accoutAndUser) {
            System.out.println(account);
        }
    }

    @Test
    public void testOne2Many() {
        sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> accoutAndUser = mapper.findUserAndAccount();
        for (User user : accoutAndUser) {
            System.out.println(user.getId() + ":" + user.getUsername() + ":" + user.getSex());
            System.out.println(user.getAccounts());
        }
    }
}
