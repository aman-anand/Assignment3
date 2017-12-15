package com.vgroupinc.assignment3.dashboard.bean.HypeSearch;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AdminDetails {

    @SerializedName("imageKey")
    @Expose
    private String imageKey;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("username")
    @Expose
    private String username;

    /**
     * No args constructor for use in serialization
     */
    public AdminDetails() {
    }

    /**
     * @param username
     * @param imageKey
     * @param name
     */
    public AdminDetails(String imageKey, String name, String username) {
        super();
        this.imageKey = imageKey;
        this.name = name;
        this.username = username;
    }

    public String getImageKey() {
        return imageKey;
    }

    public void setImageKey(String imageKey) {
        this.imageKey = imageKey;
    }

    public AdminDetails withImageKey(String imageKey) {
        this.imageKey = imageKey;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AdminDetails withName(String name) {
        this.name = name;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public AdminDetails withUsername(String username) {
        this.username = username;
        return this;
    }

}
