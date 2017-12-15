package com.vgroupinc.assignment3.login.bean;

/**
 * Created by DELL on 12/4/2017.
 */

public class LoggedInUser {

    private int userID;

    private String name;

    private String username;

    private String email;

    private boolean loggedIn;

    private String loginType;

    private String key;

    private int userSubscription;

    private String authLevel;

    private boolean validUserName;

    public LoggedInUser() {
    }

    public LoggedInUser(int userID, String name, String username, String email, boolean loggedIn, String loginType, String key, int userSubscription, String authLevel, boolean validUserName) {
        this.userID = userID;
        this.name = name;
        this.username = username;
        this.email = email;
        this.loggedIn = loggedIn;
        this.loginType = loginType;
        this.key = key;
        this.userSubscription = userSubscription;
        this.authLevel = authLevel;
        this.validUserName = validUserName;
    }

    public int getUserID() {
        return this.userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean getLoggedIn() {
        return this.loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public String getLoginType() {
        return this.loginType;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getUserSubscription() {
        return this.userSubscription;
    }

    public void setUserSubscription(int userSubscription) {
        this.userSubscription = userSubscription;
    }

    public String getAuthLevel() {
        return this.authLevel;
    }

    public void setAuthLevel(String authLevel) {
        this.authLevel = authLevel;
    }

    public boolean getValidUserName() {
        return this.validUserName;
    }

    public void setValidUserName(boolean validUserName) {
        this.validUserName = validUserName;
    }
}
