package com.vgroupinc.assignment3.dashboard.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.vgroupinc.assignment3.base.Network.CustomRequest;
import com.vgroupinc.assignment3.base.Network.NetworkConfig;
import com.vgroupinc.assignment3.base.Network.NetworkRequest;
import com.vgroupinc.assignment3.R;
import com.vgroupinc.assignment3.appController.AppController;
import com.vgroupinc.assignment3.appController.SharedPrefs;
import com.vgroupinc.assignment3.base.BaseActivity;
import com.vgroupinc.assignment3.dashboard.adapters.HypeAdapter;
import com.vgroupinc.assignment3.dashboard.adapters.NotificationAdapter;
import com.vgroupinc.assignment3.dashboard.adapters.TournamentAdapter;
import com.vgroupinc.assignment3.dashboard.adapters.tab.TabHypeAdapter;
import com.vgroupinc.assignment3.dashboard.adapters.tab.TabTournamentAdapter;
import com.vgroupinc.assignment3.dashboard.bean.HypeSearch.HypeSearchBean;
import com.vgroupinc.assignment3.dashboard.bean.TopLevelBean.ApiData;
import com.vgroupinc.assignment3.dashboard.bean.Tournaments.ActiveTournaments;
import com.vgroupinc.assignment3.dashboard.bean.UserProfile.UserProfileBean;
import com.vgroupinc.assignment3.dashboard.bean.notifications.Notifications;
import com.vgroupinc.assignment3.dashboard.navbar.NavAdapter;
import com.vgroupinc.assignment3.dashboard.navbar.NavBean;
import com.vgroupinc.assignment3.login.ui.LoginActivity;
import com.vgroupinc.assignment3.base.picasso.PicassoImp;
import com.vgroupinc.assignment3.utils.OnSwipeTouchListener;
import com.vgroupinc.assignment3.utils.Utils;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class ProfileActivity extends BaseActivity {
    private final int NOTIF = 0, HYPE = 1, TOURNA = 2, PROFILE = 3;
    private Map<String, String> headers;
    private ProgressBar progressBar;
    private int pastVisiblesItems, visibleItemCount;
    private boolean canSwipeUp = true, canSwipeLeft = true, canSwipeRight = false, canSwipeDown = false;
    private boolean tournamentSelected = false, hypeSelected = false, notifSelected = false, loadMore = false;
    private Context context;
    private UserProfileBean userProfile;
    private HypeSearchBean hypeSearch;
    private ActiveTournaments tournaments;
    private Notifications notifications;
    private RelativeLayout profileLayout, listLayout;
    private ImageView navBtn, profile_image, dashLeft, dashRight;
    private TextView playerName, email, social_id, notification, hype, tournament, messageFollowers, syncToServer, playerName_drawer, location_drawer;
    private ListView listView, listView_drawer;
    private NavBean navBean;
    private HypeAdapter hypeAdapter;
    private NotificationAdapter notificationAdapter;
    private TournamentAdapter tournamentAdapter;
    private EditText messageEditText;
    private ApiData apiData = new ApiData();
    private int totalCount = 0;
    private Typeface normal, bold;
    private DrawerLayout drawer;
    private LinearLayout socialContainer, options, scrollIndicator,mainView;
    private RelativeLayout.LayoutParams fullParams = new RelativeLayout.LayoutParams(0, 0);
    private RelativeLayout.LayoutParams swipeParams = new RelativeLayout.LayoutParams(0, 0);
    private NavAdapter navAdapter;
    private ActionBarDrawerToggle mDrawerToggle;

    //Tab
    private RecyclerView mRecyclerView;
    private GridLayoutManager mLayoutManager;
    private RelativeLayout messageFollowersLayout;
    private RecyclerView.Adapter tab_tourna_adapter, tab_hype_adapter;
    private int totalItemCount;


    public static boolean deleteDir(File dir) {
        if (dir != null && dir.isDirectory()) {
            String[] children = dir.list();
            for (String aChildren : children) {
                boolean success = deleteDir(new File(dir, aChildren));
                if (!success) {
                    return false;
                }
            }
        }
        return dir.delete();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        if (isTab) {
            setContentView(R.layout.tab_drawer);
        } else {
            setContentView(R.layout.drawer);

        }
        context = this;

        init();
        networkcallToApi(PROFILE, 0);
        networkcallToApi(TOURNA, 0);
        networkcallToApi(NOTIF, 0);
        networkcallToApi(HYPE, 0);
        initSwipe();
    }

    private void init() {
        userProfile = new UserProfileBean();
        hypeSearch = new HypeSearchBean();
        tournaments = new ActiveTournaments();
        notifications = new Notifications();
        navBean = new NavBean();
        headers = new HashMap<>();
        headers.put(NetworkConfig.HEADER_API_VERSION, NetworkConfig.HEADER_API_VERSION_VALUE + AppController.getInstance().version);
        headers.put(NetworkConfig.HEADER_AUTH, AppController.getInstance().loggedInUser.getKey());
        normal = Typeface.createFromAsset(getAssets(), "fonts/futura_tee.ttf");
        bold = Typeface.createFromAsset(getAssets(), "fonts/futura_tee_bold.ttf");

        //bindings views to objects/variables
        mainView = findViewById(R.id.mainView);
        progressBar = findViewById(R.id.progress);
        listView = findViewById(R.id.listView);
        listView_drawer = findViewById(R.id.list_drawer);
        syncToServer = findViewById(R.id.syncToServer);
        playerName_drawer = findViewById(R.id.playerName_drawer);
        location_drawer = findViewById(R.id.location_drawer);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        socialContainer = findViewById(R.id.socialContainer);
        options = findViewById(R.id.options);
        scrollIndicator = findViewById(R.id.scrollIndicator);
        dashLeft = findViewById(R.id.dashLeft);
        dashRight = findViewById(R.id.dashRight);
        messageEditText = findViewById(R.id.messageEditText);
        messageFollowers = findViewById(R.id.messageFollowers);
        profileLayout = findViewById(R.id.profileLayout);
        listLayout = findViewById(R.id.listLayout);
        navBtn = findViewById(R.id.navBtn);
        profile_image = findViewById(R.id.profile_image);
        playerName = findViewById(R.id.playerName);
        email = findViewById(R.id.email);
        social_id = findViewById(R.id.social_id);
        notification = findViewById(R.id.notification);
        hype = findViewById(R.id.hype);
        tournament = findViewById(R.id.tournament);
        listView = findViewById(R.id.listView);
        progressBar.setVisibility(View.GONE);
        messageFollowers.setVisibility(View.GONE);
        socialContainer.setVisibility(View.INVISIBLE);
        messageEditText.setVisibility(View.GONE);
        drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        if (isTab) {
            mRecyclerView = mainView.findViewById(R.id.recyclerView);
            mLayoutManager = new GridLayoutManager(context, getResources().getInteger(R.integer.spanCount), GridLayoutManager.HORIZONTAL, false);
            mRecyclerView.setLayoutManager(mLayoutManager);
            messageFollowersLayout = findViewById(R.id.messageFollowersLayout);
            messageFollowersLayout.setVisibility(View.GONE);
            tab_hype_adapter = new TabHypeAdapter(apiData.getHype().getHypeSearch(), context);
            tab_tourna_adapter = new TabTournamentAdapter(apiData.getTournaB().getTournaments(), context, mRecyclerView);
            mRecyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
                @Override
                public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                    super.onScrollStateChanged(recyclerView, newState);
                }

                @Override
                public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                    super.onScrolled(recyclerView, dx, dy);
                    if (dx < 0) //check for scroll down
                    {
                        return;
                    }
                    visibleItemCount = mLayoutManager.getChildCount();
                    totalItemCount = mLayoutManager.getItemCount();
                    pastVisiblesItems = mLayoutManager.findFirstVisibleItemPosition();

                    if (totalCount < totalItemCount) {
                        totalCount = totalItemCount;
                        loadMore = true;
                    }
                    if (loadMore && (visibleItemCount + pastVisiblesItems) >= totalItemCount) {
                        int page;
                        loadMore = false;

                        if (tournamentSelected && apiData.getTournaB().getLoadMore()) {
                            showProgress();
                            page = apiData.getTournaB().getPageNumber();
                            page++;
                            networkcallToApi(TOURNA, page);
                        } else if (notifSelected && apiData.getNotifB().getLoadMore()) {
                            showProgress();
                            page = apiData.getNotifB().getPageNumber();
                            page++;
                            networkcallToApi(NOTIF, page);

                        } else if (hypeSelected && apiData.getHype().getLoadMore()) {
                            showProgress();
                            page = apiData.getHype().getPageNumber();
                            page++;
                            networkcallToApi(HYPE, page);
                        }
                    }
                }
            });

        } else {
            fullParams = (RelativeLayout.LayoutParams) profile_image.getLayoutParams();
            swipeParams = new RelativeLayout.LayoutParams(profile_image.getLayoutParams());
            swipeParams.width /= 1.5;
            swipeParams.height /= 1.5;
            swipeParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
            swipeParams.topMargin = fullParams.topMargin;

        }
        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if (totalItemCount > totalCount) {
                    totalCount = totalItemCount;
                    loadMore = true;
                }
                if (firstVisibleItem + visibleItemCount == totalItemCount && loadMore) {
                    int page;
                    loadMore = false;

                    if (tournamentSelected && apiData.getTournaB().getLoadMore() && !isTab) {
                        showProgress();
                        page = apiData.getTournaB().getPageNumber();
                        page++;
                        networkcallToApi(TOURNA, page);
                    } else if (notifSelected && apiData.getNotifB().getLoadMore()) {
                        showProgress();
                        page = apiData.getNotifB().getPageNumber();
                        page++;
                        networkcallToApi(NOTIF, page);

                    } else if (hypeSelected && apiData.getHype().getLoadMore() && !isTab) {
                        showProgress();
                        page = apiData.getHype().getPageNumber();
                        page++;
                        networkcallToApi(HYPE, page);
                    }
                }

            }
        });

        tournament.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (apiData.getTournaB().getTournaments().getList().size()>0) {
                    totalCount = 0;
                    changeUI(tournament);
                    setData(TOURNA);
                }else{
                    changeUI(tournament);
                }

            }
        });
        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (apiData.getNotifB().getNotifications().getList().size()>0) {
                    totalCount = 0;
                    changeUI(notification);
                    setData(NOTIF);
                }else {
                    changeUI(notification);

                }
            }
        });
        hype.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (apiData.getHype().getHypeSearch().getList().size()>0){
                    totalCount = 0;
                    changeUI(hype);
                    setData(HYPE);
                }else {
                    changeUI(hype);
                }
            }
        });
        navBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utils.hideKeyboard(profileLayout, context);
                if (drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);
                } else {
                    drawer.openDrawer(GravityCompat.START);
                }
            }
        });
        syncToServer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeToast("sync To server");
            }
        });
        mDrawerToggle = new ActionBarDrawerToggle(this, drawer, null, R.string.app_name, R.string.app_name) {
            public void onDrawerClosed(View view) {
                supportInvalidateOptionsMenu();
            }

            public void onDrawerOpened(View drawerView) {
                supportInvalidateOptionsMenu();
            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                mainView.setTranslationX(slideOffset * drawerView.getWidth());
                drawer.bringChildToFront(drawerView);
                drawer.requestLayout();
            }
        };
        drawer.setDrawerListener(mDrawerToggle);
        listView_drawer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        makeToast("drawer-profile-image clicked");
                        break;
                    case 1:
                        if (view.getId() == R.id.playerName_drawer) {
                            makeToast("player Name clicked");
                        } else if (view.getId() == R.id.location_drawer) {
                            makeToast("player-handle-clicked");
                        }
                        break;
                    default:
                        makeToast(navBean.getNavItem(position - 2) + " clicked");
                        if (navBean.getNavItem(position - 2).equals(getString(R.string.logout_123))) {
                            SharedPrefs.clearData(context);
                            clearApplicationData();
                            startActivity(new Intent(context, LoginActivity.class));
                            finish();
                        }
                }

            }
        });
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            finishNoTransition();
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    private void initSwipe() {
        messageEditText.setOnTouchListener(new OnSwipeTouchListener(context) {
            @Override
            public void onSwipeRight() {
                super.onSwipeRight();
                Utils.hideKeyboard(profileLayout, context);
                if (canSwipeRight) {
                    swipeRight();
                }
            }

            @Override
            public void onSwipeLeft() {

            }
        });
        profileLayout.setOnTouchListener(new OnSwipeTouchListener(context) {

            @Override
            public void onSwipeRight() {
                super.onSwipeRight();
                Utils.hideKeyboard(profileLayout, context);
                makeToast("Swipe Right");
                if (canSwipeRight) {
                    swipeRight();
                }
            }

            @Override
            public void onSwipeLeft() {
                super.onSwipeLeft();
                if (canSwipeLeft) {
                    swipeLeft();
                }
                makeToast("Swipe LEft");
            }

            @Override
            public void onSwipeTop() {
                super.onSwipeTop();
                if (canSwipeUp && !isTab) {
                    swipeUp();
                }
                makeToast("Swipe Top");
            }

            @Override
            public void onSwipeBottom() {
                super.onSwipeBottom();
                if (canSwipeDown && !isTab) {
                    swipeDown();
                }
                makeToast("Swipe Bottom");
            }
        });
    }

    private void swipeLeft() {

        dashLeft.setImageResource(R.color.grey);
        dashRight.setImageResource(R.color.cyan_400);
        profile_image.setVisibility(View.GONE);
        playerName.setVisibility(View.GONE);
        email.setVisibility(View.GONE);
        socialContainer.setVisibility(View.GONE);
        options.setVisibility(View.GONE);
        listView.setVisibility(View.GONE);
        if (isTab) {
            mRecyclerView.setVisibility(View.GONE);
            messageFollowersLayout.setVisibility(View.VISIBLE);
        }
        messageFollowers.setVisibility(View.VISIBLE);
        messageEditText.setVisibility(View.VISIBLE);
        messageEditText.requestFocus();
        hideProgress();
        canSwipeLeft = false;
        canSwipeRight = true;
        canSwipeUp = false;
        canSwipeDown = false;
    }

    private void swipeRight() {
        messageEditText.clearFocus();
        dashLeft.setImageResource(R.color.cyan_400);
        dashRight.setImageResource(R.color.grey);
        profile_image.setVisibility(View.VISIBLE);
        playerName.setVisibility(View.VISIBLE);
        email.setVisibility(View.VISIBLE);
        messageEditText.setText("");
        messageEditText.setVisibility(View.GONE);
        messageFollowers.setVisibility(View.GONE);
        socialContainer.setVisibility(View.VISIBLE);
        options.setVisibility(View.VISIBLE);

        if (isTab) {
            messageFollowersLayout.setVisibility(View.GONE);
            if (notifSelected) {
                listView.setVisibility(View.VISIBLE);
            } else if (tournamentSelected || hypeSelected) {
                mRecyclerView.setVisibility(View.VISIBLE);
            }
        } else {
            listView.setVisibility(View.VISIBLE);
        }
        canSwipeLeft = true;
        canSwipeRight = false;
        canSwipeUp = true;
        canSwipeDown = false;
    }

    private void swipeUp() {
        profile_image.setVisibility(View.VISIBLE);
        playerName.setVisibility(View.VISIBLE);
        email.setVisibility(View.GONE);
        scrollIndicator.setVisibility(View.GONE);
        profileLayout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0, 0.6f));
        listLayout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0, 1.4f));
//        Log.e("Swipe UP", "params " + fullParams.height + "    " + fullParams.width);
        profile_image.setLayoutParams(swipeParams);
//        profile_image.setLayoutParams(new LinearLayout.LayoutParams());
        canSwipeLeft = false;
        canSwipeRight = false;
        canSwipeUp = false;
        canSwipeDown = true;
    }

    private void swipeDown() {
        profile_image.setVisibility(View.VISIBLE);
        playerName.setVisibility(View.VISIBLE);
        email.setVisibility(View.VISIBLE);
        scrollIndicator.setVisibility(View.VISIBLE);
//        profile_image.setLayoutParams(new RelativeLayout.LayoutParams(fullParams.width,fullParams.height));
        profile_image.setLayoutParams(fullParams);
        profileLayout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0, 0.9f));
        listLayout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0, 1.1f));
        canSwipeLeft = true;
        canSwipeRight = false;
        canSwipeUp = true;
        canSwipeDown = false;
    }

    private void changeUI(TextView textView) {
        switch (textView.getId()) {
            case R.id.tournament:
                hypeSelected = false;
                notifSelected = false;
                tournamentSelected = true;
                tournament.setTextColor(getResources().getColor(R.color.white));
                notification.setTextColor(getResources().getColor(R.color.grey));
                hype.setTextColor(getResources().getColor(R.color.grey));
                if (isTab) {
                    listView.setVisibility(View.GONE);
                    mRecyclerView.setVisibility(View.GONE);
                    tournament.setTypeface(bold);
                    notification.setTypeface(normal);
                    hype.setTypeface(normal);
                }
                break;
            case R.id.notification:
                tournamentSelected = false;
                hypeSelected = false;
                notifSelected = true;
                tournament.setTextColor(getResources().getColor(R.color.grey));
                notification.setTextColor(getResources().getColor(R.color.white));
                hype.setTextColor(getResources().getColor(R.color.grey));
                if (isTab) {
                    tournament.setTypeface(normal);
                    notification.setTypeface(bold);
                    hype.setTypeface(normal);
                    mRecyclerView.setVisibility(View.GONE);
                }
                break;
            case R.id.hype:
                tournamentSelected = false;
                notifSelected = false;
                hypeSelected = true;

                tournament.setTextColor(getResources().getColor(R.color.grey));
                notification.setTextColor(getResources().getColor(R.color.grey));
                hype.setTextColor(getResources().getColor(R.color.white));
                if (isTab) {
                    listView.setVisibility(View.GONE);
                    mRecyclerView.setVisibility(View.GONE);
                    tournament.setTypeface(normal);
                    notification.setTypeface(normal);
                    hype.setTypeface(bold);
                }
                break;
        }
    }

    private void networkcallToApi(int choice, final int page) {
        headers.put("pagenumber", String.valueOf(page));
        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                handleError(error, context);
            }
        };
        if (Utils.checkInternet((Activity) context)) {
            switch (choice) {
                case PROFILE:

                    Response.Listener listener = new Response.Listener() {
                        @Override
                        public void onResponse(Object response) {
                            userProfile = (UserProfileBean) response;
                            setApiData(PROFILE, userProfile, page);
                        }
                    };
                    CustomRequest profileRequest = new CustomRequest(true, NetworkConfig.BASE_URL + NetworkConfig.PROFILE, UserProfileBean.class, headers, listener, errorListener);
                    NetworkRequest.getInstance(context).addToRequestQueue(profileRequest);

                    break;
                case NOTIF:
                    Response.Listener notification_listener = new Response.Listener() {
                        @Override
                        public void onResponse(Object response) {
                            notifications = (Notifications) response;
                            if (notifications.getList().size() > 0) {
                                setApiData(NOTIF, notifications, page);
                            } else {
                                hideProgress();
                                apiData.getNotifB().setLoadMore(false);
                            }
                        }
                    };
                    CustomRequest notificationRequest = new CustomRequest(true, NetworkConfig.BASE_URL + NetworkConfig.NOTIFICATIONLIST, Notifications.class, headers, notification_listener, errorListener);
                    NetworkRequest.getInstance(context).addToRequestQueue(notificationRequest);

                    break;

                case HYPE:
                    Response.Listener hype_listener = new Response.Listener() {
                        @Override
                        public void onResponse(Object response) {
                            hypeSearch = (HypeSearchBean) response;
                            if (hypeSearch.getList().size() > 0) {
                                setApiData(HYPE, hypeSearch, page);
                            } else {
                                hideProgress();
                                apiData.getHype().setLoadMore(false);
                            }
                        }
                    };
                    CustomRequest hypeRequest = new CustomRequest(true, NetworkConfig.BASE_URL + NetworkConfig.HYPESEARCH, HypeSearchBean.class, headers, hype_listener, errorListener);
                    NetworkRequest.getInstance(context).addToRequestQueue(hypeRequest);
                    break;
                case TOURNA:
                    Response.Listener tournament_listener = new Response.Listener() {
                        @Override
                        public void onResponse(Object response) {
                            tournaments = (ActiveTournaments) response;
                            if (tournaments.getList().size() > 0) {
                                setApiData(TOURNA, tournaments, page);
                            } else {
                                hideProgress();
                                apiData.getTournaB().setLoadMore(false);
                            }
                        }
                    };
                    CustomRequest tournamentRequest = new CustomRequest(true, NetworkConfig.BASE_URL + NetworkConfig.GETACTIVETOURNAMENT + AppController.getInstance().loggedInUser.getUserID(), ActiveTournaments.class, headers, tournament_listener, errorListener);
                    NetworkRequest.getInstance(context).addToRequestQueue(tournamentRequest);
                    break;
            }
        } else {
            showAlert((Activity) context, "NO Internet", 3);
        }
    }

    /**
     *
     * @param choice integer value denoting choice of request {@link TournamentAdapter}
     * @param object
     * @param page
     */
    private void setApiData(int choice, Object object, int page) {
        switch (choice) {
            case PROFILE:
                UserProfileBean bean = (UserProfileBean) object;
                playerName.setText(bean.getPerson().getName());
                PicassoImp.getInstance().setImage(NetworkConfig.IMAGE_DOWNLOAD_URL + bean.getPerson().getImageKey(),
                        (Activity) context,
                        profile_image,
                        R.drawable.user_profile_icon);
                email.setText(bean.getEmail());
                socialContainer.setVisibility(View.VISIBLE);
                social_id.setText(bean.getTwitterUser().getTwitterHandle());
                listView.setVisibility(View.VISIBLE);
                navBean.setName(bean.getPerson().getName());
                navBean.setImageKey(NetworkConfig.IMAGE_DOWNLOAD_URL + bean.getPerson().getImageKey());
                navBean.setUserName(bean.getPerson().getUsername());
                navAdapter = new NavAdapter(navBean, (Activity) context);
                listView_drawer.setAdapter(navAdapter);
                break;
            case NOTIF:
                Notifications notifications = (Notifications) object;
                if (apiData.getNotifB().getFirst()) {
                    apiData.setNotifB(notifications);
                } else {
                    apiData.addtoNotificationsList(notifications, page);
                    notificationAdapter.notifyDataSetChanged();
                    hideProgress();
                }
                break;
            case HYPE:
                if (apiData.getHype().getFirst()) {
                    apiData.setHype((HypeSearchBean) object);

                } else {
                    apiData.addtoHypeList((HypeSearchBean) object, page);
                    if (isTab) {
                        tab_hype_adapter.notifyItemInserted(totalCount);

                    } else {
                        hypeAdapter.notifyDataSetChanged();
                    }
                    hideProgress();
                }

                break;
            case TOURNA:
                if (apiData.getTournaB().getFirst()) {
                    apiData.setTournaB((ActiveTournaments) object);
                    setData(TOURNA);
                } else {
                    apiData.addTournaments((ActiveTournaments) object, page);
                    if (isTab) {
                        tab_tourna_adapter.notifyItemInserted(totalCount);
                    } else {
                        tournamentAdapter.notifyDataSetChanged();
                    }
                    hideProgress();
                }
                break;
        }
    }


    private void setData(int choice) {
        if (canSwipeRight){
            return;
        }
        switch (choice) {
            case NOTIF:
                listView.setDividerHeight(1);
                if (apiData.getNotifB().getFirst()) {
                    notificationAdapter = new NotificationAdapter(apiData.getNotifB().getNotifications(), context);
                    listView.setAdapter(notificationAdapter);
                    apiData.getNotifB().setFirst(false);
                } else {
                    hideProgress();
                    listView.setAdapter(notificationAdapter);
                }
                if (messageEditText.getVisibility() != View.VISIBLE) {
                    listView.setVisibility(View.VISIBLE);
                }
                break;
            case HYPE:
                if (isTab) {
                    if (apiData.getHype().getFirst()) {
                        tab_hype_adapter = new TabHypeAdapter(apiData.getHype().getHypeSearch(), context);
                        mRecyclerView.setAdapter(tab_hype_adapter);
                        apiData.getHype().setFirst(false);
                    } else {
                        hideProgress();
                        mRecyclerView.setAdapter(tab_hype_adapter);

                    }
                    mRecyclerView.setVisibility(View.VISIBLE);
                } else {
                    listView.setDividerHeight(0);
                    if (apiData.getHype().getFirst()) {
                        hypeAdapter = new HypeAdapter(context, apiData.getHype().getHypeSearch());
                        listView.setAdapter(hypeAdapter);
                        apiData.getHype().setFirst(false);
                    } else {
                        hideProgress();
                        listView.setAdapter(hypeAdapter);

                    }
                    listView.setVisibility(View.VISIBLE);
                }

                break;
            case TOURNA:

                if (isTab) {
                    if (apiData.getTournaB().getFirst()) {
                        tab_tourna_adapter = new TabTournamentAdapter(apiData.getTournaB().getTournaments(), context, mRecyclerView);
                        mRecyclerView.setAdapter(tab_tourna_adapter);
                        changeUI(tournament);
                        apiData.getTournaB().setFirst(false);
                    } else {
                        hideProgress();

                        mRecyclerView.setAdapter(tab_tourna_adapter);

                    }
                    mRecyclerView.setVisibility(View.VISIBLE);
                } else {
                    listView.setDividerHeight(0);
                    if (apiData.getTournaB().getFirst()) {
                        tournamentAdapter = new TournamentAdapter(apiData.getTournaB().getTournaments(), context);
                        listView.setAdapter(tournamentAdapter);
                        changeUI(tournament);
                        apiData.getTournaB().setFirst(false);
                    } else {
                        hideProgress();
                        listView.setAdapter(tournamentAdapter);

                    }
                    listView.setVisibility(View.VISIBLE);
                }
                break;
        }
    }

    private void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    private void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }


    public void clearApplicationData() {
        File cache = getCacheDir();
        File appDir = new File(cache.getParent());
        if (appDir.exists()) {
            String[] children = appDir.list();
            for (String s : children) {
                if (!s.equals("lib")) {
                    deleteDir(new File(appDir, s));
                    Log.i("TAG", "**************** File /data/data/APP_PACKAGE/" + s + " DELETED *******************");
                }
            }
        }
    }

}
