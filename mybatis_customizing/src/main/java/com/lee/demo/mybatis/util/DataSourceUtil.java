package com.lee.demo.mybatis.util;

import com.lee.demo.mybatis.conf.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataSourceUtil {

    public static Connection getConnection(Configuration configuration) {
        try {
            Class.forName(configuration.getDriver());

            return DriverManager.getConnection(configuration.getUrl(), configuration.getUsername(), configuration.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
