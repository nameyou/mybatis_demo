package com.lee.demo.mybatis.sqlsession;

import com.lee.demo.mybatis.conf.Configuration;
import com.lee.demo.mybatis.conf.Mapper;
import com.lee.demo.mybatis.util.DataSourceUtil;
import com.lee.demo.mybatis.util.Executor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Map;

public class ProxMapper implements InvocationHandler {

    public Map<String, Mapper> mappers;
    private Connection connection;

    public ProxMapper(Map<String, Mapper> mappers, Connection connection) {
        this.mappers = mappers;
        this.connection = connection;
    }

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
        Mapper mapper = mappers.get(key);
        if (mapper == null) {
            throw new RuntimeException("参数有误。。。");
        }
        //执行查询方法
        return new Executor().selectList(mapper, connection);
    }
}
