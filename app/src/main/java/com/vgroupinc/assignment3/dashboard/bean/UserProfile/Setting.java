package com.vgroupinc.assignment3.dashboard.bean.UserProfile;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Setting {

    @SerializedName("setting")
    @Expose
    private String setting;
    @SerializedName("value")
    @Expose
    private Boolean value;

    /**
     * No args constructor for use in serialization
     */
    public Setting() {
    }

    /**
     * @param setting
     * @param value
     */
    public Setting(String setting, Boolean value) {
        super();
        this.setting = setting;
        this.value = value;
    }

    public String getSetting() {
        return setting;
    }

    public void setSetting(String setting) {
        this.setting = setting;
    }

    public Setting withSetting(String setting) {
        this.setting = setting;
        return this;
    }

    public Boolean getValue() {
        return value;
    }

    public void setValue(Boolean value) {
        this.value = value;
    }

    public Setting withValue(Boolean value) {
        this.value = value;
        return this;
    }

}
