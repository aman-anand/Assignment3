package com.vgroupinc.assignment3.ui.profile;

/**
 * Created by DELL on 11/20/2017.
 */

public class Tournament {
    String name;
    String date;
    int imageName;

    public Tournament(String name, String date, int imageName) {
        this.name = name;
        this.date = date;
        this.imageName = imageName;
    }

    public Tournament() {

    }

    public Integer getImageName() {
        return imageName;
    }

    public void setImageName(int imageName) {
        this.imageName = imageName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
