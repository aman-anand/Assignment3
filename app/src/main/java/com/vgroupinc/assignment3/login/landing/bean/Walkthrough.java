package com.vgroupinc.assignment3.login.landing.bean;

/**
 * Created by DELL on 11/30/2017.
 */

public class Walkthrough {
    private String title, des;
    private Integer image, pageNumber;

    public Walkthrough() {
    }

    public Walkthrough(String title, String des, Integer image, Integer pageNumber) {
        this.title = title;
        this.des = des;
        this.image = image;
        this.pageNumber = pageNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }
}
