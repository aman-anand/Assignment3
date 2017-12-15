package com.vgroupinc.assignment3.dashboard.bean.Tournaments;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ActiveTournaments {

    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("inactiveCount")
    @Expose
    private Integer inactiveCount;
    @SerializedName("list")
    @Expose
    private java.util.List<TList> list = null;

    /**
     * No args constructor for use in serialization
     */
    public ActiveTournaments() {
    }

    /**
     * @param count
     * @param list
     * @param inactiveCount
     */
    public ActiveTournaments(Integer count, Integer inactiveCount, java.util.List<TList> list) {
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

    public ActiveTournaments withCount(Integer count) {
        this.count = count;
        return this;
    }

    public Integer getInactiveCount() {
        return inactiveCount;
    }

    public void setInactiveCount(Integer inactiveCount) {
        this.inactiveCount = inactiveCount;
    }

    public ActiveTournaments withInactiveCount(Integer inactiveCount) {
        this.inactiveCount = inactiveCount;
        return this;
    }

    public java.util.List<TList> getList() {
        return list;
    }

    public void setList(java.util.List<TList> list) {
        this.list = list;
    }

    public ActiveTournaments withList(java.util.List<TList> list) {
        this.list = list;
        return this;
    }

}
