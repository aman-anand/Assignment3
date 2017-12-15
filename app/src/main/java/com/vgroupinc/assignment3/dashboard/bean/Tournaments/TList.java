package com.vgroupinc.assignment3.dashboard.bean.Tournaments;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TList {

    @SerializedName("tournamentID")
    @Expose
    private Integer tournamentID;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("game")
    @Expose
    private String game;
    @SerializedName("tournamentTypeName")
    @Expose
    private String tournamentTypeName;
    @SerializedName("imageKey")
    @Expose
    private Object imageKey;
    @SerializedName("webURL")
    @Expose
    private String webURL;
    @SerializedName("startDate")
    @Expose
    private String startDate;
    @SerializedName("endDate")
    @Expose
    private String endDate;
    @SerializedName("lastUpdatedAt")
    @Expose
    private String lastUpdatedAt;
    @SerializedName("started")
    @Expose
    private Boolean started;
    @SerializedName("completed")
    @Expose
    private Boolean completed;
    @SerializedName("hype")
    @Expose
    private Boolean hype;
    @SerializedName("venue")
    @Expose
    private String venue;
    @SerializedName("latLong")
    @Expose
    private String latLong;
    @SerializedName("preRegister")
    @Expose
    private Boolean preRegister;

    /**
     * No args constructor for use in serialization
     */
    public TList() {
    }

    /**
     * @param lastUpdatedAt
     * @param startDate
     * @param tournamentID
     * @param imageKey
     * @param preRegister
     * @param name
     * @param webURL
     * @param tournamentTypeName
     * @param hype
     * @param endDate
     * @param started
     * @param game
     * @param venue
     * @param latLong
     * @param completed
     */
    public TList(Integer tournamentID, String name, String game, String tournamentTypeName, Object imageKey, String webURL, String startDate, String endDate, String lastUpdatedAt, Boolean started, Boolean completed, Boolean hype, String venue, String latLong, Boolean preRegister) {
        super();
        this.tournamentID = tournamentID;
        this.name = name;
        this.game = game;
        this.tournamentTypeName = tournamentTypeName;
        this.imageKey = imageKey;
        this.webURL = webURL;
        this.startDate = startDate;
        this.endDate = endDate;
        this.lastUpdatedAt = lastUpdatedAt;
        this.started = started;
        this.completed = completed;
        this.hype = hype;
        this.venue = venue;
        this.latLong = latLong;
        this.preRegister = preRegister;
    }

    public Integer getTournamentID() {
        return tournamentID;
    }

    public void setTournamentID(Integer tournamentID) {
        this.tournamentID = tournamentID;
    }

    public TList withTournamentID(Integer tournamentID) {
        this.tournamentID = tournamentID;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TList withName(String name) {
        this.name = name;
        return this;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public TList withGame(String game) {
        this.game = game;
        return this;
    }

    public String getTournamentTypeName() {
        return tournamentTypeName;
    }

    public void setTournamentTypeName(String tournamentTypeName) {
        this.tournamentTypeName = tournamentTypeName;
    }

    public TList withTournamentTypeName(String tournamentTypeName) {
        this.tournamentTypeName = tournamentTypeName;
        return this;
    }

    public Object getImageKey() {
        return imageKey;
    }

    public void setImageKey(Object imageKey) {
        this.imageKey = imageKey;
    }

    public TList withImageKey(Object imageKey) {
        this.imageKey = imageKey;
        return this;
    }

    public String getWebURL() {
        return webURL;
    }

    public void setWebURL(String webURL) {
        this.webURL = webURL;
    }

    public TList withWebURL(String webURL) {
        this.webURL = webURL;
        return this;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public TList withStartDate(String startDate) {
        this.startDate = startDate;
        return this;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public TList withEndDate(String endDate) {
        this.endDate = endDate;
        return this;
    }

    public String getLastUpdatedAt() {
        return lastUpdatedAt;
    }

    public void setLastUpdatedAt(String lastUpdatedAt) {
        this.lastUpdatedAt = lastUpdatedAt;
    }

    public TList withLastUpdatedAt(String lastUpdatedAt) {
        this.lastUpdatedAt = lastUpdatedAt;
        return this;
    }

    public Boolean getStarted() {
        return started;
    }

    public void setStarted(Boolean started) {
        this.started = started;
    }

    public TList withStarted(Boolean started) {
        this.started = started;
        return this;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public TList withCompleted(Boolean completed) {
        this.completed = completed;
        return this;
    }

    public Boolean getHype() {
        return hype;
    }

    public void setHype(Boolean hype) {
        this.hype = hype;
    }

    public TList withHype(Boolean hype) {
        this.hype = hype;
        return this;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public TList withVenue(String venue) {
        this.venue = venue;
        return this;
    }

    public String getLatLong() {
        return latLong;
    }

    public void setLatLong(String latLong) {
        this.latLong = latLong;
    }

    public TList withLatLong(String latLong) {
        this.latLong = latLong;
        return this;
    }

    public Boolean getPreRegister() {
        return preRegister;
    }

    public void setPreRegister(Boolean preRegister) {
        this.preRegister = preRegister;
    }

    public TList withPreRegister(Boolean preRegister) {
        this.preRegister = preRegister;
        return this;
    }

}
