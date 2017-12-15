package com.vgroupinc.assignment3.dashboard.bean.HypeSearch;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class List {

    @SerializedName("guid")
    @Expose
    private String guid;
    @SerializedName("hypableType")
    @Expose
    private String hypableType;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("game")
    @Expose
    private String game;
    @SerializedName("venue")
    @Expose
    private String venue;
    @SerializedName("imageKey")
    @Expose
    private Object imageKey;
    @SerializedName("startDate")
    @Expose
    private String startDate;
    @SerializedName("endDate")
    @Expose
    private String endDate;
    @SerializedName("hypeType")
    @Expose
    private String hypeType;
    @SerializedName("hypes")
    @Expose
    private Integer hypes;
    @SerializedName("hits")
    @Expose
    private Integer hits;
    @SerializedName("adminDetails")
    @Expose
    private AdminDetails adminDetails;
    @SerializedName("timestamp")
    @Expose
    private String timestamp;
    @SerializedName("creatorUserId")
    @Expose
    private Integer creatorUserId;

    /**
     * No args constructor for use in serialization
     */
    public List() {
    }

    /**
     * @param startDate
     * @param hypes
     * @param hypableType
     * @param endDate
     * @param game
     * @param venue
     * @param timestamp
     * @param guid
     * @param id
     * @param creatorUserId
     * @param hypeType
     * @param hits
     * @param imageKey
     * @param adminDetails
     * @param name
     */
    public List(String guid, String hypableType, Integer id, String name, String game, String venue, Object imageKey, String startDate, String endDate, String hypeType, Integer hypes, Integer hits, AdminDetails adminDetails, String timestamp, Integer creatorUserId) {
        super();
        this.guid = guid;
        this.hypableType = hypableType;
        this.id = id;
        this.name = name;
        this.game = game;
        this.venue = venue;
        this.imageKey = imageKey;
        this.startDate = startDate;
        this.endDate = endDate;
        this.hypeType = hypeType;
        this.hypes = hypes;
        this.hits = hits;
        this.adminDetails = adminDetails;
        this.timestamp = timestamp;
        this.creatorUserId = creatorUserId;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public List withGuid(String guid) {
        this.guid = guid;
        return this;
    }

    public String getHypableType() {
        return hypableType;
    }

    public void setHypableType(String hypableType) {
        this.hypableType = hypableType;
    }

    public List withHypableType(String hypableType) {
        this.hypableType = hypableType;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List withId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List withName(String name) {
        this.name = name;
        return this;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public List withGame(String game) {
        this.game = game;
        return this;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public List withVenue(String venue) {
        this.venue = venue;
        return this;
    }

    public Object getImageKey() {
        return imageKey;
    }

    public void setImageKey(Object imageKey) {
        this.imageKey = imageKey;
    }

    public List withImageKey(Object imageKey) {
        this.imageKey = imageKey;
        return this;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public List withStartDate(String startDate) {
        this.startDate = startDate;
        return this;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public List withEndDate(String endDate) {
        this.endDate = endDate;
        return this;
    }

    public String getHypeType() {
        return hypeType;
    }

    public void setHypeType(String hypeType) {
        this.hypeType = hypeType;
    }

    public List withHypeType(String hypeType) {
        this.hypeType = hypeType;
        return this;
    }

    public Integer getHypes() {
        return hypes;
    }

    public void setHypes(Integer hypes) {
        this.hypes = hypes;
    }

    public List withHypes(Integer hypes) {
        this.hypes = hypes;
        return this;
    }

    public Integer getHits() {
        return hits;
    }

    public void setHits(Integer hits) {
        this.hits = hits;
    }

    public List withHits(Integer hits) {
        this.hits = hits;
        return this;
    }

    public AdminDetails getAdminDetails() {
        return adminDetails;
    }

    public void setAdminDetails(AdminDetails adminDetails) {
        this.adminDetails = adminDetails;
    }

    public List withAdminDetails(AdminDetails adminDetails) {
        this.adminDetails = adminDetails;
        return this;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public List withTimestamp(String timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public Integer getCreatorUserId() {
        return creatorUserId;
    }

    public void setCreatorUserId(Integer creatorUserId) {
        this.creatorUserId = creatorUserId;
    }

    public List withCreatorUserId(Integer creatorUserId) {
        this.creatorUserId = creatorUserId;
        return this;
    }

    @Override
    public String toString() {
        return "List{" +
                "guid='" + guid + '\'' +
                ", hypableType='" + hypableType + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", game='" + game + '\'' +
                ", venue='" + venue + '\'' +
                ", imageKey=" + imageKey +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", hypeType='" + hypeType + '\'' +
                ", hypes=" + hypes +
                ", hits=" + hits +
                ", adminDetails=" + adminDetails +
                ", timestamp='" + timestamp + '\'' +
                ", creatorUserId=" + creatorUserId +
                '}';
    }
}
