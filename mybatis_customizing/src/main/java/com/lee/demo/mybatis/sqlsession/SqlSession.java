package com.lee.demo.mybatis.sqlsession;

import java.sql.SQLException;

public interface SqlSession {

    /**
     * 创建代理对象
     *
     * @param <T>
     * @param classInterface
     * @return
     */
    public <T> T getMapper(Class<T> classInterface);

    /**
     * 释放资源
     */
    void close() throws SQLException;
}
