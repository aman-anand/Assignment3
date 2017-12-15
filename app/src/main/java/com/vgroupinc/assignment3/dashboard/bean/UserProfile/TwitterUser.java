package com.vgroupinc.assignment3.dashboard.bean.UserProfile;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TwitterUser {

    @SerializedName("recordId")
    @Expose
    private Integer recordId;
    @SerializedName("personIdref")
    @Expose
    private Integer personIdref;
    @SerializedName("tournamentIds")
    @Expose
    private String tournamentIds;
    @SerializedName("twitterHandle")
    @Expose
    private String twitterHandle;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("twitterLink")
    @Expose
    private String twitterLink;
    @SerializedName("followersCount")
    @Expose
    private Integer followersCount;
    @SerializedName("friendsCount")
    @Expose
    private Integer friendsCount;
    @SerializedName("favouritesCount")
    @Expose
    private Integer favouritesCount;
    @SerializedName("imageKey")
    @Expose
    private String imageKey;

    /**
     * No args constructor for use in serialization
     */
    public TwitterUser() {
    }

    /**
     * @param recordId
     * @param friendsCount
     * @param imageKey
     * @param location
     * @param twitterLink
     * @param twitterHandle
     * @param personIdref
     * @param favouritesCount
     * @param name
     * @param followersCount
     * @param tournamentIds
     */
    public TwitterUser(Integer recordId, Integer personIdref, String tournamentIds, String twitterHandle, String name, String location, String twitterLink, Integer followersCount, Integer friendsCount, Integer favouritesCount, String imageKey) {
        super();
        this.recordId = recordId;
        this.personIdref = personIdref;
        this.tournamentIds = tournamentIds;
        this.twitterHandle = twitterHandle;
        this.name = name;
        this.location = location;
        this.twitterLink = twitterLink;
        this.followersCount = followersCount;
        this.friendsCount = friendsCount;
        this.favouritesCount = favouritesCount;
        this.imageKey = imageKey;
    }

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public TwitterUser withRecordId(Integer recordId) {
        this.recordId = recordId;
        return this;
    }

    public Integer getPersonIdref() {
        return personIdref;
    }

    public void setPersonIdref(Integer personIdref) {
        this.personIdref = personIdref;
    }

    public TwitterUser withPersonIdref(Integer personIdref) {
        this.personIdref = personIdref;
        return this;
    }

    public String getTournamentIds() {
        return tournamentIds;
    }

    public void setTournamentIds(String tournamentIds) {
        this.tournamentIds = tournamentIds;
    }

    public TwitterUser withTournamentIds(String tournamentIds) {
        this.tournamentIds = tournamentIds;
        return this;
    }

    public String getTwitterHandle() {
        return twitterHandle;
    }

    public void setTwitterHandle(String twitterHandle) {
        this.twitterHandle = twitterHandle;
    }

    public TwitterUser withTwitterHandle(String twitterHandle) {
        this.twitterHandle = twitterHandle;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TwitterUser withName(String name) {
        this.name = name;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public TwitterUser withLocation(String location) {
        this.location = location;
        return this;
    }

    public String getTwitterLink() {
        return twitterLink;
    }

    public void setTwitterLink(String twitterLink) {
        this.twitterLink = twitterLink;
    }

    public TwitterUser withTwitterLink(String twitterLink) {
        this.twitterLink = twitterLink;
        return this;
    }

    public Integer getFollowersCount() {
        return followersCount;
    }

    public void setFollowersCount(Integer followersCount) {
        this.followersCount = followersCount;
    }

    public TwitterUser withFollowersCount(Integer followersCount) {
        this.followersCount = followersCount;
        return this;
    }

    public Integer getFriendsCount() {
        return friendsCount;
    }

    public void setFriendsCount(Integer friendsCount) {
        this.friendsCount = friendsCount;
    }

    public TwitterUser withFriendsCount(Integer friendsCount) {
        this.friendsCount = friendsCount;
        return this;
    }

    public Integer getFavouritesCount() {
        return favouritesCount;
    }

    public void setFavouritesCount(Integer favouritesCount) {
        this.favouritesCount = favouritesCount;
    }

    public TwitterUser withFavouritesCount(Integer favouritesCount) {
        this.favouritesCount = favouritesCount;
        return this;
    }

    public String getImageKey() {
        return imageKey;
    }

    public void setImageKey(String imageKey) {
        this.imageKey = imageKey;
    }

    public TwitterUser withImageKey(String imageKey) {
        this.imageKey = imageKey;
        return this;
    }

}
