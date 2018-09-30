package com.lee.demo.bean;

public class QueryVO {

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "QueryVO{" +
                "user=" + user +
                '}';
    }
}
