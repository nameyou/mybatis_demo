package com.lee.demo.mybatis.sqlsession;

import com.lee.demo.mybatis.conf.Configuration;
import com.lee.demo.mybatis.util.XMLConfigBuilder;

import java.io.InputStream;

/**
 * c创建工场对象
 */
public class SqlSessionFactoryBuilder {

    /**
     * @param inputStream
     * @return
     */
    public SqlSessionFactory build(InputStream inputStream) {
        Configuration configuration = XMLConfigBuilder.loadConfiguration(inputStream);

        return new DefaultSqlSessionFactory(configuration);
    }

}
