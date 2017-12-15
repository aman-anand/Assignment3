package com.vgroupinc.assignment3.dashboard.bean.UserProfile;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Accolade {

    @SerializedName("tournament")
    @Expose
    private Tournament tournament;
    @SerializedName("position")
    @Expose
    private Integer position;

    /**
     * No args constructor for use in serialization
     */
    public Accolade() {
    }

    /**
     * @param position
     * @param tournament
     */
    public Accolade(Tournament tournament, Integer position) {
        super();
        this.tournament = tournament;
        this.position = position;
    }

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }

    public Accolade withTournament(Tournament tournament) {
        this.tournament = tournament;
        return this;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Accolade withPosition(Integer position) {
        this.position = position;
        return this;
    }

}
