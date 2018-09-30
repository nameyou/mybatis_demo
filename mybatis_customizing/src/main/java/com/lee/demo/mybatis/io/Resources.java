package com.lee.demo.mybatis.io;

import java.io.InputStream;

/**
 * 读取配置文件
 */
public class Resources {


    /**
     * 读取配置文件
     *
     * @param resource
     * @return
     */
    public static InputStream getResourceAsStream(String resource) {
        return Resources.class.getClassLoader().getResourceAsStream(resource);
    }
}
