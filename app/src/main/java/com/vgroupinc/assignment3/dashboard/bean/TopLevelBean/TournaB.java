package com.vgroupinc.assignment3.dashboard.bean.TopLevelBean;

import com.vgroupinc.assignment3.dashboard.bean.Tournaments.ActiveTournaments;

/**
 * Created by DELL on 12/14/2017.
 */
public class TournaB {
    private ActiveTournaments tournaments = new ActiveTournaments();
    private int pageNumber = 0;
    private Boolean loadMore = true;
    private Boolean isFirstLoad = true;

    public Boolean getFirst() {
        return isFirstLoad;
    }

    public void setFirst(Boolean first) {
        isFirstLoad = first;
    }

    public ActiveTournaments getTournaments() {
        return tournaments;
    }

    public void setTournaments(ActiveTournaments tournaments) {
        this.tournaments = tournaments;
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