package com.vgroupinc.assignment3.dashboard.bean.notifications;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Notifications {

    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("inactiveCount")
    @Expose
    private Integer inactiveCount;
    @SerializedName("list")
    @Expose
    private java.util.List<List> list = null;

    /**
     * No args constructor for use in serialization
     */
    public Notifications() {
    }

    /**
     * @param count
     * @param list
     * @param inactiveCount
     */
    public Notifications(Integer count, Integer inactiveCount, java.util.List<List> list) {
        super();
        this.count = count;
        this.inactiveCount = inactiveCount;
        this.list = list;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Notifications withCount(Integer count) {
        this.count = count;
        return this;
    }

    public Integer getInactiveCount() {
        return inactiveCount;
    }

    public void setInactiveCount(Integer inactiveCount) {
        this.inactiveCount = inactiveCount;
    }

    public Notifications withInactiveCount(Integer inactiveCount) {
        this.inactiveCount = inactiveCount;
        return this;
    }

    public java.util.List<List> getList() {
        return list;
    }

    public void setList(java.util.List<List> list) {
        this.list = list;
    }

    public Notifications withList(java.util.List<List> list) {
        this.list = list;
        return this;
    }

}
