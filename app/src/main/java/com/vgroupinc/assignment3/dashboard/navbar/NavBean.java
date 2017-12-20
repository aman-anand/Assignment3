package com.vgroupinc.assignment3.dashboard.navbar;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by DELL on 12/15/2017.
 */

public class NavBean {
    private String imageKey, userName;
    private String name;
    private ArrayList<String> nav_items = new ArrayList<String>(Arrays.asList("Tournaments", "Events", "Seasons", "My Teams", "Following", "Settings", "Logout"));//{"Tournaments", "Events", "Seasons", "My Teams", "Following", "Settings", "Logout"};

    public String getImageKey() {
        return imageKey;
    }

    public void setImageKey(String imageKey) {
        this.imageKey = imageKey;

    }

    public ArrayList<String> getNav_items() {
        return nav_items;
    }

    public String getNavItem(int position) {
        String str = "";
        if (position >= 0 && position < nav_items.size()) {
            str = nav_items.get(position);
        }
        return str;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
