package com.lee.test;

import com.lee.demo.bean.Role;
import com.lee.demo.bean.User;
import com.lee.demo.mapper.RoleMapper;
import com.lee.demo.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.InputStream;
import java.util.List;

public class TestDemo {
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

    @Test
    public void testAA() {
        sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userl = mapper.findAll();
        for (User user : userl) {
            System.out.println("员工=" + user);
            System.out.println("角色=" + user.getRoles());
        }
    }

    @Test
    public void testUserManyRole() {
        sqlSession = sqlSessionFactory.openSession();
        RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
        List<Role> roleList = mapper.findAll();
        for (Role role : roleList) {
            System.out.println(role);
            System.out.println(role.getUser());
        }
    }
}
