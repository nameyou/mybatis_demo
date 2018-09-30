package com.lee.demo.mybatis.sqlsession;

import java.sql.SQLData;

/**
 * 创建session对象
 */
public interface SqlSessionFactory {
    public SqlSession openSession();
}
