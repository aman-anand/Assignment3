package com.vgroupinc.assignment3.dashboard.bean.notifications;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Action {

    @SerializedName("action")
    @Expose
    private String action;
    @SerializedName("callbackURL")
    @Expose
    private String callbackURL;

    /**
     * No args constructor for use in serialization
     */
    public Action() {
    }

    /**
     * @param action
     * @param callbackURL
     */
    public Action(String action, String callbackURL) {
        super();
        this.action = action;
        this.callbackURL = callbackURL;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Action withAction(String action) {
        this.action = action;
        return this;
    }

    public String getCallbackURL() {
        return callbackURL;
    }

    public void setCallbackURL(String callbackURL) {
        this.callbackURL = callbackURL;
    }

    public Action withCallbackURL(String callbackURL) {
        this.callbackURL = callbackURL;
        return this;
    }

}
