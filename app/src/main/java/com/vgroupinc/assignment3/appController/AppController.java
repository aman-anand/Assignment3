package com.vgroupinc.assignment3.appController;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.vgroupinc.assignment3.login.bean.LoggedInUser;

import org.acra.ACRA;
import org.acra.annotation.ReportsCrashes;

@ReportsCrashes(
        mailTo = "aman.anandx3@gmail.com"
)
public class AppController extends Application {
    private static AppController singleton;
    public LoggedInUser loggedInUser = null;
    public Boolean loginSuccess = false;


    public String version;

    public AppController() throws PackageManager.NameNotFoundException {
    }

    public static AppController getInstance() {
        return singleton;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        singleton = this;
        try {
            PackageInfo info = getPackageManager().getPackageInfo(
                    this.getPackageName(), 0);
            version = info.versionName;
            ACRA.init(this);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

    public LoggedInUser getLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(LoggedInUser loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

}
