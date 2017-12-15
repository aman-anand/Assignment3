package com.vgroupinc.assignment3.dashboard;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.vgroupinc.assignment3.Network.CustomRequest;
import com.vgroupinc.assignment3.Network.NetworkConfig;
import com.vgroupinc.assignment3.Network.NetworkRequest;
import com.vgroupinc.assignment3.R;
import com.vgroupinc.assignment3.appController.AppController;
import com.vgroupinc.assignment3.base.BaseActivity;
import com.vgroupinc.assignment3.dashboard.bean.HypeSearch.HypeSearchBean;
import com.vgroupinc.assignment3.dashboard.bean.Tournaments.ActiveTournaments;
import com.vgroupinc.assignment3.dashboard.bean.UserProfile.UserProfileBean;
import com.vgroupinc.assignment3.dashboard.bean.notifications.Notifications;
import com.vgroupinc.assignment3.login.bean.LoggedInUser;
import com.vgroupinc.assignment3.login.bean.User;
import com.vgroupinc.assignment3.login.callback.ShareLoginStatus;

import java.util.HashMap;
import java.util.Map;

public class BaseDashboard extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener, ShareLoginStatus {
    private Context context;
    private UserProfileBean userProfile;
    private HypeSearchBean hypeSearch;
    private ActiveTournaments tournaments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_dashboard);
        context = this;
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
//                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//        drawer.addDrawerListener(toggle);
//        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        init();

        networkcall();
    }

    private void init() {
        userProfile = new UserProfileBean();
    }

    private void networkcall() {
        Map<String, String> headers = new HashMap<>();
        headers.put(NetworkConfig.HEADER_API_VERSION, NetworkConfig.HEADER_API_VERSION_VALUE + AppController.getInstance().version);
        headers.put(NetworkConfig.HEADER_AUTH, AppController.getInstance().loggedInUser.getKey());
        Response.Listener listener = new Response.Listener() {
            @Override
            public void onResponse(Object response) {
                userProfile = (UserProfileBean) response;
            }
        };
        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        };
        Response.Listener notification_listener = new Response.Listener() {
            @Override
            public void onResponse(Object response) {
                hypeSearch = (HypeSearchBean) response;
            }
        };
        Response.ErrorListener notification_errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        };
        Response.Listener hype_listener = new Response.Listener() {
            @Override
            public void onResponse(Object response) {
                hypeSearch = (HypeSearchBean) response;
            }
        };
        Response.ErrorListener hype_errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        };
        Response.Listener tournament_listener = new Response.Listener() {
            @Override
            public void onResponse(Object response) {
                tournaments = (ActiveTournaments) response;
            }
        };
        Response.ErrorListener tournament_errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        };
        //profile
        CustomRequest profileRequest = new CustomRequest(true, NetworkConfig.BASE_URL + NetworkConfig.PROFILE, UserProfileBean.class, headers, listener, errorListener);
        //hype
        CustomRequest hypeRequest = new CustomRequest(true, NetworkConfig.BASE_URL + NetworkConfig.HYPESEARCH, HypeSearchBean.class, headers, hype_listener, hype_errorListener);
        //tournaments
        CustomRequest tournamentRequest = new CustomRequest(true, NetworkConfig.BASE_URL + NetworkConfig.GETACTIVETOURNAMENT + AppController.getInstance().loggedInUser.getUserID(), ActiveTournaments.class, headers, tournament_listener, tournament_errorListener);
        //notifications
        CustomRequest notificationRequest = new CustomRequest(true, NetworkConfig.BASE_URL + NetworkConfig.NOTIFICATIONLIST, Notifications.class, headers, notification_listener, notification_errorListener);
        NetworkRequest.getInstance(context).addToRequestQueue(tournamentRequest);
        NetworkRequest.getInstance(context).addToRequestQueue(hypeRequest);
        NetworkRequest.getInstance(context).addToRequestQueue(profileRequest);
        NetworkRequest.getInstance(context).addToRequestQueue(notificationRequest);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.base_dashboard, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        }
// else if (id == R.id.nav_share) {
//
//        } else if (id == R.id.nav_send) {
//
//        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onLoginSuccess(LoggedInUser loggedInUser, User userData) {

    }

    @Override
    public void onLoginFail(String status) {

    }
}
