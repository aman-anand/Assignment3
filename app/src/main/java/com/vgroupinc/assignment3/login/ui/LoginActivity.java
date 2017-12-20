package com.vgroupinc.assignment3.login.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.vgroupinc.assignment3.base.Network.NetworkRequest;
import com.vgroupinc.assignment3.R;
import com.vgroupinc.assignment3.appController.AppController;
import com.vgroupinc.assignment3.appController.SharedPrefs;
import com.vgroupinc.assignment3.dashboard.ui.ProfileActivity;
import com.vgroupinc.assignment3.login.bean.LoggedInUser;
import com.vgroupinc.assignment3.login.bean.User;
import com.vgroupinc.assignment3.login.callback.ShareLoginStatus;
import com.vgroupinc.assignment3.login.manager.Manager;
import com.vgroupinc.assignment3.utils.Utils;

import org.json.JSONException;

/**
 * Created by DELL on 12/2/2017.
 */

public class LoginActivity extends Manager implements ShareLoginStatus {
    private ImageView header, header2_inflated;
    private TextView email, password, loginBtn;
    private Context context;
    private ProgressBar progressBar;
    private RelativeLayout inflated_options, alter_screen;
    private FrameLayout rootLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getResources().getBoolean(R.bool.isTablet)) {
            setContentView(R.layout.tab_login_page);
        } else {
            setContentView(R.layout.login_page);
        }

        context = this;
        init();
    }

    private void init() {
        rootLayout = findViewById(R.id.rootLayout);
        progressBar = findViewById(R.id.googleProgressBar);
        progressBar.setVisibility(View.INVISIBLE);
        email = findViewById(R.id.email_id);
        password = findViewById(R.id.password);
        loginBtn = findViewById(R.id.loginBtn);
        header = findViewById(R.id.headerImage);
        header2_inflated = findViewById(R.id.header2);
        inflated_options = findViewById(R.id.inflated_options);
        inflated_options.setVisibility(View.INVISIBLE);
        alter_screen = findViewById(R.id.alter_screen);
        header.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleView(context, inflated_options, alter_screen);
            }
        });
        header2_inflated.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleView(context, inflated_options, alter_screen);
            }
        });
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Utils.checkInternet((Activity) context)) {
                    User user = new User(email.getText().toString().trim(), password.getText().toString().trim());
                    if (verifydata(user)) {
                        try {
                            progressBar.setVisibility(View.VISIBLE);
                            NetworkRequest.getInstance(context).login(user.getUsername(), user.getPassword());

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    showAlert((Activity) context, getString(R.string.internetError), 3);
                }
            }
        });
        rootLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int id = v.getId();
                if (id == R.id.email_id || id == R.id.password || id == R.id.social ||
                        id == R.id.headerImage || id == R.id.loginBtn ||
                        id == R.id.inflated_options) {
                    return false;
                } else {
                    Utils.hideKeyboard(v, context);
                    return true;
                }
            }
        });

    }


    private boolean verifydata(User user) {
        boolean b = false;
        if (user.getUsername().equals("")) {
            showAlert((Activity) context, "Please enter username/email-id", 2);
        } else if (user.getPassword().equals("")) {
            showAlert((Activity) context, "Please enter password", 2);
        } else {
            b = true;
        }

        return b;
    }


    @Override
    public void onLoginSuccess(LoggedInUser loggedInUser, User userData) {
        SharedPrefs.setUserData(context, userData.getUsername(), userData.getPassword(), userData.isLoginStatus());
        AppController.getInstance().setLoggedInUser(loggedInUser);
        progressBar.setVisibility(View.INVISIBLE);
        Intent intent = new Intent(LoginActivity.this, ProfileActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    @Override
    public void onLoginFail(String error) {
        progressBar.setVisibility(View.INVISIBLE);
        showAlert((Activity) context, error, 1);

    }
}
