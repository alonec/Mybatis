package com.baidu.mybatis.pojo;

import java.util.List;

public class QueryVo {
    private User user;

    private List<Orders> idsList;

    private int[] ids;

    public List<Orders> getIdsList() {
        return idsList;
    }

    public void setIdsList(List<Orders> idsList) {
        this.idsList = idsList;
    }

    public int[] getIds() {
        return ids;
    }

    public void setIds(int[] ids) {
        this.ids = ids;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
