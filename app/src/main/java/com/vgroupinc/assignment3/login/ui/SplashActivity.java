package com.vgroupinc.assignment3.login.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.vgroupinc.assignment3.base.Network.NetworkRequest;
import com.vgroupinc.assignment3.R;
import com.vgroupinc.assignment3.appController.AppController;
import com.vgroupinc.assignment3.appController.SharedPrefs;
import com.vgroupinc.assignment3.base.BaseActivity;
import com.vgroupinc.assignment3.dashboard.ui.ProfileActivity;
import com.vgroupinc.assignment3.login.bean.LoggedInUser;
import com.vgroupinc.assignment3.login.bean.User;
import com.vgroupinc.assignment3.login.callback.ShareLoginStatus;
import com.vgroupinc.assignment3.utils.Utils;

import org.json.JSONException;

public class SplashActivity extends BaseActivity implements ShareLoginStatus {
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (isTab) {
            setContentView(R.layout.splash);
        } else {
            setContentView(R.layout.splash);
        }
        context = this;
        User user = SharedPrefs.getUserData(SplashActivity.this);
        if (user.isLoginStatus()&& Utils.checkInternet((Activity) context)) {
            try {
                NetworkRequest.getInstance(context).login(user.getUsername(), user.getPassword());
            } catch (JSONException e) {
                e.printStackTrace();
                gotoLanding();
            }
        } else {
            gotoLanding();
        }

    }

    private void gotoLanding() {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, LandingPage.class);
                startActivity(intent);
                finish();

            }
        }, 2000);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onLeaveThisActivity() {

    }

    @Override
    public void onLoginSuccess(LoggedInUser loggedInUser, User userData) {
        SharedPrefs.setUserData(context, userData.getUsername(), userData.getPassword(), userData.isLoginStatus());
        AppController.getInstance().setLoggedInUser(loggedInUser);
        Intent intent = new Intent(SplashActivity.this, ProfileActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    @Override
    public void onLoginFail(String status) {
        showAlert((Activity) context, status, 1);
        startActivity(new Intent(context, LandingPage.class));
        this.finish();
    }
}
