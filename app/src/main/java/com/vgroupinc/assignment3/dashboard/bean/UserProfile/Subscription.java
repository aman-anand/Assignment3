package com.vgroupinc.assignment3.dashboard.bean.UserProfile;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Subscription {

    @SerializedName("subscriptionType")
    @Expose
    private String subscriptionType;
    @SerializedName("startDate")
    @Expose
    private String startDate;
    @SerializedName("endDate")
    @Expose
    private String endDate;
    @SerializedName("cancelled")
    @Expose
    private Boolean cancelled;
    @SerializedName("showTeamIcon")
    @Expose
    private Boolean showTeamIcon;

    /**
     * No args constructor for use in serialization
     */
    public Subscription() {
    }

    /**
     * @param startDate
     * @param showTeamIcon
     * @param cancelled
     * @param subscriptionType
     * @param endDate
     */
    public Subscription(String subscriptionType, String startDate, String endDate, Boolean cancelled, Boolean showTeamIcon) {
        super();
        this.subscriptionType = subscriptionType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.cancelled = cancelled;
        this.showTeamIcon = showTeamIcon;
    }

    public String getSubscriptionType() {
        return subscriptionType;
    }

    public void setSubscriptionType(String subscriptionType) {
        this.subscriptionType = subscriptionType;
    }

    public Subscription withSubscriptionType(String subscriptionType) {
        this.subscriptionType = subscriptionType;
        return this;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public Subscription withStartDate(String startDate) {
        this.startDate = startDate;
        return this;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Subscription withEndDate(String endDate) {
        this.endDate = endDate;
        return this;
    }

    public Boolean getCancelled() {
        return cancelled;
    }

    public void setCancelled(Boolean cancelled) {
        this.cancelled = cancelled;
    }

    public Subscription withCancelled(Boolean cancelled) {
        this.cancelled = cancelled;
        return this;
    }

    public Boolean getShowTeamIcon() {
        return showTeamIcon;
    }

    public void setShowTeamIcon(Boolean showTeamIcon) {
        this.showTeamIcon = showTeamIcon;
    }

    public Subscription withShowTeamIcon(Boolean showTeamIcon) {
        this.showTeamIcon = showTeamIcon;
        return this;
    }

}
