package com.lee.demo.mybatis.sqlsession;

import com.lee.demo.mybatis.conf.Configuration;
import com.lee.demo.mybatis.conf.Mapper;
import com.lee.demo.mybatis.util.DataSourceUtil;
import com.lee.demo.mybatis.util.Executor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

public class DefaultSqlSession implements SqlSession {

    private Configuration configuration;
    private Connection connection;

    public DefaultSqlSession(Configuration configuration) {
        try {
            this.configuration = configuration;
            this.connection = DataSourceUtil.getConnection(configuration);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    /**
     * 创建代理对象
     *
     * @param <T>
     * @param classInterface
     * @return
     */
  /*  public <T> T getMapper(Class<T> classInterface) {
        return (T) Proxy.newProxyInstance(classInterface.getClassLoader(),
                new Class[]{classInterface}, new ProxMapper(configuration.getMappers(), connection));
    }*/
    @Override
    public <T> T getMapper(Class<T> classInterface) {
        return (T) Proxy.newProxyInstance(classInterface.getClassLoader(), new Class[]{classInterface}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //获取方法名
                String methodName = method.getName();
                //方法名所在类的名称
                String className = method.getDeclaringClass().getName();
                //组合key
                String key = className + "." + methodName;
                System.out.println(key);
                //获取mapper是种的mapper对象
                Mapper mapper = configuration.getMappers().get(key);
                if (mapper == null) {
                    throw new RuntimeException("参数有误。。。");
                }
                //执行查询方法
                return new Executor().selectList(mapper, connection);
            }
        });
    }

    /**
     * 释放资源
     */
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
