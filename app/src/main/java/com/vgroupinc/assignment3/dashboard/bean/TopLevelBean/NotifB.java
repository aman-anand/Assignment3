package com.vgroupinc.assignment3.dashboard.bean.TopLevelBean;

import com.vgroupinc.assignment3.dashboard.bean.notifications.Notifications;

/**
 * Created by DELL on 12/14/2017.
 */
public class NotifB {
    private Notifications notifications = new Notifications();
    private int pageNumber = 0;
    private Boolean loadMore = true;
    private Boolean isFirstLoad = true;

    public Boolean getFirst() {
        return isFirstLoad;
    }

    public void setFirst(Boolean first) {
        isFirstLoad = first;
    }

    public Notifications getNotifications() {
        return notifications;
    }

    public void setNotifications(Notifications notifications) {
        this.notifications = notifications;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Boolean getLoadMore() {
        return loadMore;
    }

    public void setLoadMore(Boolean loadMore) {
        this.loadMore = loadMore;
    }
}