package com.baidu.mybatis.pojo;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<Orders> orders; // 用户的订单信息
    private int id;
    private String username;// 用户姓名
    private Date birthday;// 生日
    private String sex;// 性别
    private String address;// 地址

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    public int getId() { return id; }
    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "orders=" + orders +
                ", id=" + id +
                ", username='" + username + '\'' +
                ", birthday=" + birthday +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
