package com.lee.demo.bean;

import java.util.List;

public class QueryVO {

    private User user;

    private List<Integer> ids;

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

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
                ", ids=" + ids +
                '}';
    }
}
