package com.vgroupinc.assignment3.dashboard.bean.UserProfile;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Person {

    @SerializedName("userID")
    @Expose
    private Integer userID;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("phoneNumber")
    @Expose
    private Object phoneNumber;
    @SerializedName("city")
    @Expose
    private Object city;
    @SerializedName("state")
    @Expose
    private Object state;
    @SerializedName("country")
    @Expose
    private Object country;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("age")
    @Expose
    private Integer age;
    @SerializedName("sex")
    @Expose
    private String sex;
    @SerializedName("latLong")
    @Expose
    private String latLong;
    @SerializedName("imageKey")
    @Expose
    private String imageKey;
    @SerializedName("messagingSetting")
    @Expose
    private Boolean messagingSetting;
    @SerializedName("mailSetting")
    @Expose
    private Boolean mailSetting;
    @SerializedName("loginType")
    @Expose
    private Object loginType;
    @SerializedName("imageUrl")
    @Expose
    private Object imageUrl;
    @SerializedName("teamIcon")
    @Expose
    private String teamIcon;
    @SerializedName("teamIconPC")
    @Expose
    private Object teamIconPC;
    @SerializedName("pgcustId")
    @Expose
    private String pgcustId;

    /**
     * No args constructor for use in serialization
     */
    public Person() {
    }

    /**
     * @param messagingSetting
     * @param sex
     * @param imageUrl
     * @param location
     * @param state
     * @param loginType
     * @param city
     * @param country
     * @param userID
     * @param username
     * @param imageKey
     * @param phoneNumber
     * @param name
     * @param age
     * @param teamIconPC
     * @param pgcustId
     * @param mailSetting
     * @param latLong
     * @param teamIcon
     */
    public Person(Integer userID, String username, String name, Object phoneNumber, Object city, Object state, Object country, String location, Integer age, String sex, String latLong, String imageKey, Boolean messagingSetting, Boolean mailSetting, Object loginType, Object imageUrl, String teamIcon, Object teamIconPC, String pgcustId) {
        super();
        this.userID = userID;
        this.username = username;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.city = city;
        this.state = state;
        this.country = country;
        this.location = location;
        this.age = age;
        this.sex = sex;
        this.latLong = latLong;
        this.imageKey = imageKey;
        this.messagingSetting = messagingSetting;
        this.mailSetting = mailSetting;
        this.loginType = loginType;
        this.imageUrl = imageUrl;
        this.teamIcon = teamIcon;
        this.teamIconPC = teamIconPC;
        this.pgcustId = pgcustId;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public Person withUserID(Integer userID) {
        this.userID = userID;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Person withUsername(String username) {
        this.username = username;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person withName(String name) {
        this.name = name;
        return this;
    }

    public Object getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Object phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Person withPhoneNumber(Object phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public Object getCity() {
        return city;
    }

    public void setCity(Object city) {
        this.city = city;
    }

    public Person withCity(Object city) {
        this.city = city;
        return this;
    }

    public Object getState() {
        return state;
    }

    public void setState(Object state) {
        this.state = state;
    }

    public Person withState(Object state) {
        this.state = state;
        return this;
    }

    public Object getCountry() {
        return country;
    }

    public void setCountry(Object country) {
        this.country = country;
    }

    public Person withCountry(Object country) {
        this.country = country;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Person withLocation(String location) {
        this.location = location;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Person withAge(Integer age) {
        this.age = age;
        return this;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Person withSex(String sex) {
        this.sex = sex;
        return this;
    }

    public String getLatLong() {
        return latLong;
    }

    public void setLatLong(String latLong) {
        this.latLong = latLong;
    }

    public Person withLatLong(String latLong) {
        this.latLong = latLong;
        return this;
    }

    public String getImageKey() {
        return imageKey;
    }

    public void setImageKey(String imageKey) {
        this.imageKey = imageKey;
    }

    public Person withImageKey(String imageKey) {
        this.imageKey = imageKey;
        return this;
    }

    public Boolean getMessagingSetting() {
        return messagingSetting;
    }

    public void setMessagingSetting(Boolean messagingSetting) {
        this.messagingSetting = messagingSetting;
    }

    public Person withMessagingSetting(Boolean messagingSetting) {
        this.messagingSetting = messagingSetting;
        return this;
    }

    public Boolean getMailSetting() {
        return mailSetting;
    }

    public void setMailSetting(Boolean mailSetting) {
        this.mailSetting = mailSetting;
    }

    public Person withMailSetting(Boolean mailSetting) {
        this.mailSetting = mailSetting;
        return this;
    }

    public Object getLoginType() {
        return loginType;
    }

    public void setLoginType(Object loginType) {
        this.loginType = loginType;
    }

    public Person withLoginType(Object loginType) {
        this.loginType = loginType;
        return this;
    }

    public Object getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(Object imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Person withImageUrl(Object imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public String getTeamIcon() {
        return teamIcon;
    }

    public void setTeamIcon(String teamIcon) {
        this.teamIcon = teamIcon;
    }

    public Person withTeamIcon(String teamIcon) {
        this.teamIcon = teamIcon;
        return this;
    }

    public Object getTeamIconPC() {
        return teamIconPC;
    }

    public void setTeamIconPC(Object teamIconPC) {
        this.teamIconPC = teamIconPC;
    }

    public Person withTeamIconPC(Object teamIconPC) {
        this.teamIconPC = teamIconPC;
        return this;
    }

    public String getPgcustId() {
        return pgcustId;
    }

    public void setPgcustId(String pgcustId) {
        this.pgcustId = pgcustId;
    }

    public Person withPgcustId(String pgcustId) {
        this.pgcustId = pgcustId;
        return this;
    }

}
