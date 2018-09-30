package com.lee.demo.mybatis.sqlsession;

import com.lee.demo.mybatis.conf.Configuration;

public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    /**
     * c创建执行操作数据库的对象
     *
     * @return
     */
    public SqlSession openSession() {
        return new DefaultSqlSession(configuration);
    }
}
