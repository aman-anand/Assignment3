package com.vgroupinc.assignment3.dashboard.bean.UserProfile;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Tournament {

    @SerializedName("tournamentID")
    @Expose
    private Integer tournamentID;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("webURL")
    @Expose
    private String webURL;

    /**
     * No args constructor for use in serialization
     */
    public Tournament() {
    }

    /**
     * @param tournamentID
     * @param name
     * @param webURL
     */
    public Tournament(Integer tournamentID, String name, String webURL) {
        super();
        this.tournamentID = tournamentID;
        this.name = name;
        this.webURL = webURL;
    }

    public Integer getTournamentID() {
        return tournamentID;
    }

    public void setTournamentID(Integer tournamentID) {
        this.tournamentID = tournamentID;
    }

    public Tournament withTournamentID(Integer tournamentID) {
        this.tournamentID = tournamentID;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Tournament withName(String name) {
        this.name = name;
        return this;
    }

    public String getWebURL() {
        return webURL;
    }

    public void setWebURL(String webURL) {
        this.webURL = webURL;
    }

    public Tournament withWebURL(String webURL) {
        this.webURL = webURL;
        return this;
    }

}
