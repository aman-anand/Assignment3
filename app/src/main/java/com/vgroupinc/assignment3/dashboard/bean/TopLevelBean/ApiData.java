package com.vgroupinc.assignment3.dashboard.bean.TopLevelBean;

import com.vgroupinc.assignment3.dashboard.bean.HypeSearch.HypeSearchBean;
import com.vgroupinc.assignment3.dashboard.bean.Tournaments.ActiveTournaments;
import com.vgroupinc.assignment3.dashboard.bean.notifications.Notifications;

/**
 * Created by DELL on 12/14/2017.
 */

public class ApiData {
    private HypeB hypeB = new HypeB();
    private NotifB notifB = new NotifB();
    private TournaB tournaB = new TournaB();

//    public ApiData(HypeSearchBean hype, Notifications notifications, ActiveTournaments tournaments) {
//        this.hypeB.hypeSearch = hype;
//        this.notifB.notifications = notifications;
//        this.tournaB.setTournaments(tournaments);//tournaments = tournaments;
//    }

    public ApiData() {
    }

    public void addtoHypeList(HypeSearchBean hypeSearchBean, int page) {
        for (int i = 0; i < hypeSearchBean.getList().size(); i++) {
            this.hypeB.getHypeSearch().getList().add(hypeSearchBean.getList().get(i));
        }
//        this.hypeB.getHypeSearch().getList().add((List) hypeSearchBean.getList());
        this.hypeB.setPageNumber(page);
    }

    public void addtoNotificationsList(Notifications notifications, int page) {
        for (int i = 0; i < notifications.getList().size(); i++) {
            this.notifB.getNotifications().getList().add(notifications.getList().get(i));
        }
//        this.notifB.getNotifications().getList().add((com.vgroupinc.assignment3.dashboard.bean.notifications.List) notifications.getList());
        this.notifB.setPageNumber(page);
    }

    public void addTournaments(ActiveTournaments tournaments, int page) {
        for (int i = 0; i < tournaments.getList().size(); i++) {
            this.tournaB.getTournaments().getList().add(tournaments.getList().get(i));
        }
//        this.tournaB.getTournaments().getList().add((TList) tournaments.getList());
        this.tournaB.setPageNumber(page);
    }

    public HypeB getHype() {
        return hypeB;
    }

    public void setHype(HypeSearchBean hypeSearch) {
        this.hypeB.setHypeSearch(hypeSearch);
    }

    public NotifB getNotifB() {
        return notifB;
    }

    public void setNotifB(Notifications notifications) {
        this.notifB.setNotifications(notifications);
    }

    public TournaB getTournaB() {
        return tournaB;
    }

    public void setTournaB(ActiveTournaments tournaments) {
        this.tournaB.setTournaments(tournaments);
    }


}
