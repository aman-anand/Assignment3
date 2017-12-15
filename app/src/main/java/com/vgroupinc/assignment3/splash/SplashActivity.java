package com.vgroupinc.assignment3.splash;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.vgroupinc.assignment3.Network.NetworkCall;
import com.vgroupinc.assignment3.R;
import com.vgroupinc.assignment3.appController.AppController;
import com.vgroupinc.assignment3.appController.SharedPrefs;
import com.vgroupinc.assignment3.base.BaseActivity;
import com.vgroupinc.assignment3.dashboard.ProfileActivity;
import com.vgroupinc.assignment3.login.bean.LoggedInUser;
import com.vgroupinc.assignment3.login.bean.User;
import com.vgroupinc.assignment3.login.callback.ShareLoginStatus;
import com.vgroupinc.assignment3.ui.landing.LandingPage;

import org.json.JSONException;

public class SplashActivity extends BaseActivity implements ShareLoginStatus {
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getResources().getBoolean(R.bool.isTablet)) {
//            setContentView(R.layout.tab_landing_page);
        } else {
            setContentView(R.layout.splash);
        }


        context = this;


        User user = SharedPrefs.getUserData(SplashActivity.this);
        if (user.isLoginStatus()) {
            try {

                NetworkCall.login(SplashActivity.this, user);


            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            final Handler handler = new Handler();
            final Intent intent = new Intent(SplashActivity.this, LandingPage.class);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    //Do something after 100ms

                    startActivity(intent);
                    finish();

                }
            }, 2000);
        }

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

        Toast.makeText(context, "LOGIN SUCCESS from Splash ", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(context, ProfileActivity.class));
        finish();
    }

    @Override
    public void onLoginFail(String status) {
        showAlert((Activity) context,status,1);
        startActivity(new Intent(context, LandingPage.class));
        finish();
    }
}
