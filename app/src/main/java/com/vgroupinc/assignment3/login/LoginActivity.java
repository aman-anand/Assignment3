package com.vgroupinc.assignment3.login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.vgroupinc.assignment3.Network.NetworkCall;
import com.vgroupinc.assignment3.R;
import com.vgroupinc.assignment3.appController.AppController;
import com.vgroupinc.assignment3.appController.SharedPrefs;
import com.vgroupinc.assignment3.dashboard.ProfileActivity;
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
//                inflated_options.setVisibility(View.VISIBLE);
                toggleView(context, inflated_options, alter_screen);
            }
        });
        header2_inflated.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                inflated_options.setVisibility(View.GONE);
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
//                            NetworkRequest.getInstance(context).login(email.getText().toString().trim(), password.getText().toString().trim());
                            NetworkCall.login(context, user);


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    showAlert((Activity) context, "NO Internet, Please Connect to proceed", 3);
                }
            }
        });

//                    User user = new User(email.getText().toString().trim(), password.getText().toString().trim());
//                    HashMap<String, String> headers = new HashMap<String, String>();
//                    headers.put("api-version", "TE_Android_" + AppController.getInstance().version);
////                    headers.put("Content-Type", "application/json");
////                    headers.put("Accept", "application/json");
//                    headers.put("androidDeviceID", "");
//                    Response.Listener listener= new Response.Listener<String>() {
//                        @Override
//                        public void onResponse(String response) {
//                            Log.i("VOLLEY", response);
//                        }
//                    };
//                    Response.ErrorListener errorListener=new Response.ErrorListener() {
//                        @Override
//                        public void onErrorResponse(VolleyError error) {
//                            Log.e("VOLLEY", error.toString());
//                            NetworkResponse response = error.networkResponse;
//                            if (response != null) {
//                                String str = new String(response.data);
//
//                                Log.e("error", str);
//                            }
//                        }
//                    };
//                    CustomRequest request = new CustomRequest(NetworkConfig.LOGIN_URL,
//                            user,
//                            LoggedInUser.class,
//                            headers,
//                            listener,
//                            errorListener);
//                    NetworkRequest.getInstance(context).addToRequestQueue(request);
//                }
//            }
//        });
        email.setText("bhopal1");
        password.setText("123456");


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
        startActivity(new Intent(context, ProfileActivity.class));
        Toast.makeText(context, "LOGIN SUCCESS:: LOgin Activity", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginFail(String error) {

        showAlert((Activity) context,error,1);
        progressBar.setVisibility(View.INVISIBLE);

    }
}
