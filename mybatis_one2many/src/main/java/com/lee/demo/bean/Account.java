package com.lee.demo.bean;

public class Account {
    private Integer accoutId;
    private Integer userId;
    private Double money;

    //一对一的关系
    private User user;

    public Integer getAccoutId() {
        return accoutId;
    }

    public void setAccoutId(Integer accoutId) {
        this.accoutId = accoutId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accoutId=" + accoutId +
                ", userId=" + userId +
                ", money=" + money +
                ", user=" + user +
                '}';
    }
}
