package com.vgroupinc.assignment3.dashboard.bean.notifications;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Map {

    @SerializedName("userinfo")
    @Expose
    private List<Userinfo> userinfo = null;

    /**
     * No args constructor for use in serialization
     */
    public Map() {
    }

    /**
     * @param userinfo
     */
    public Map(List<Userinfo> userinfo) {
        super();
        this.userinfo = userinfo;
    }

    public List<Userinfo> getUserinfo() {
        return userinfo;
    }

    public void setUserinfo(List<Userinfo> userinfo) {
        this.userinfo = userinfo;
    }

    public Map withUserinfo(List<Userinfo> userinfo) {
        this.userinfo = userinfo;
        return this;
    }

}
