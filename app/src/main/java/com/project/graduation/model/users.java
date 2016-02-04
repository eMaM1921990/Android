package com.project.graduation.model;

import java.io.Serializable;

/**
 * Created by emam on 2/4/16.
 */
public class users implements Serializable{
    private String userName,password;
    private long id;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
