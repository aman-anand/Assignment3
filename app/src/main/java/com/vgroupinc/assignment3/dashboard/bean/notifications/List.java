package com.vgroupinc.assignment3.dashboard.bean.notifications;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class List {

    @SerializedName("notificationID")
    @Expose
    private String notificationID;
    @SerializedName("user")
    @Expose
    private String user;
    @SerializedName("originator")
    @Expose
    private String originator;
    @SerializedName("notificationHeader")
    @Expose
    private String notificationHeader;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("actions")
    @Expose
    private java.util.List<Action> actions = null;
    @SerializedName("notificationType")
    @Expose
    private String notificationType;
    @SerializedName("map")
    @Expose
    private Map map;

    /**
     * No args constructor for use in serialization
     */
    public List() {
    }

    /**
     * @param notificationID
     * @param notificationType
     * @param map
     * @param date
     * @param notificationHeader
     * @param originator
     * @param user
     * @param actions
     */
    public List(String notificationID, String user, String originator, String notificationHeader, String date, java.util.List<Action> actions, String notificationType, Map map) {
        super();
        this.notificationID = notificationID;
        this.user = user;
        this.originator = originator;
        this.notificationHeader = notificationHeader;
        this.date = date;
        this.actions = actions;
        this.notificationType = notificationType;
        this.map = map;
    }

    public String getNotificationID() {
        return notificationID;
    }

    public void setNotificationID(String notificationID) {
        this.notificationID = notificationID;
    }

    public List withNotificationID(String notificationID) {
        this.notificationID = notificationID;
        return this;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public List withUser(String user) {
        this.user = user;
        return this;
    }

    public String getOriginator() {
        return originator;
    }

    public void setOriginator(String originator) {
        this.originator = originator;
    }

    public List withOriginator(String originator) {
        this.originator = originator;
        return this;
    }

    public String getNotificationHeader() {
        return notificationHeader;
    }

    public void setNotificationHeader(String notificationHeader) {
        this.notificationHeader = notificationHeader;
    }

    public List withNotificationHeader(String notificationHeader) {
        this.notificationHeader = notificationHeader;
        return this;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List withDate(String date) {
        this.date = date;
        return this;
    }

    public java.util.List<Action> getActions() {
        return actions;
    }

    public void setActions(java.util.List<Action> actions) {
        this.actions = actions;
    }

    public List withActions(java.util.List<Action> actions) {
        this.actions = actions;
        return this;
    }

    public String getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(String notificationType) {
        this.notificationType = notificationType;
    }

    public List withNotificationType(String notificationType) {
        this.notificationType = notificationType;
        return this;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public List withMap(Map map) {
        this.map = map;
        return this;
    }

}
