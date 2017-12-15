package com.vgroupinc.assignment3.login.bean;

/**
 * Created by DELL on 12/5/2017.
 */

public class User {
    private String username, password;
    private boolean loginStatus;

    public User(String username, String password, boolean loginStatus) {
        this.username = username;
        this.password = password;
        this.loginStatus = loginStatus;
    }

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.loginStatus = false;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(boolean loginStatus) {
        this.loginStatus = loginStatus;
    }
}
