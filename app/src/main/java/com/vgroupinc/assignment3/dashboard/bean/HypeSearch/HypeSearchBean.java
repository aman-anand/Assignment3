package com.vgroupinc.assignment3.dashboard.bean.HypeSearch;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HypeSearchBean {

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
    public HypeSearchBean() {
    }

    /**
     * @param count
     * @param list
     * @param inactiveCount
     */
    public HypeSearchBean(Integer count, Integer inactiveCount, java.util.List<List> list) {
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

    public HypeSearchBean withCount(Integer count) {
        this.count = count;
        return this;
    }

    public Integer getInactiveCount() {
        return inactiveCount;
    }

    public void setInactiveCount(Integer inactiveCount) {
        this.inactiveCount = inactiveCount;
    }

    public HypeSearchBean withInactiveCount(Integer inactiveCount) {
        this.inactiveCount = inactiveCount;
        return this;
    }

    public java.util.List<List> getList() {
        return list;
    }

    public void setList(java.util.List<List> list) {
        this.list = list;
    }

    public HypeSearchBean withList(java.util.List<List> list) {
        this.list = list;
        return this;
    }

}
