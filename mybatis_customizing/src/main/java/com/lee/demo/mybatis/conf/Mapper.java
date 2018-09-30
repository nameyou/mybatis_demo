package com.lee.demo.mybatis.conf;

/**
 * 封装查询的结果和sql
 */
public class Mapper {
    private String queryString; //sql
    private String resultType; //查询结果

    public String getQueryString() {
        return queryString;
    }

    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }
}
