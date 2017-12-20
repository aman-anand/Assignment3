package com.vgroupinc.assignment3.ui.landing;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.vgroupinc.assignment3.R;
import com.vgroupinc.assignment3.base.BaseActivity;
import com.vgroupinc.assignment3.login.LoginActivity;
import com.vgroupinc.assignment3.ui.landing.adapter.PageAdapter;
import com.vgroupinc.assignment3.ui.landing.bean.Walkthrough;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class LandingPage extends BaseActivity {

    int livePage = 0;
    private RelativeLayout rootLayout;
    private LinearLayout rootLayout_mobile;
    private ImageView[] bullets = new ImageView[5];
    private int[] gallery_bg_tab = new int[]{R.drawable.tab1, R.drawable.tab2, R.drawable.tab3, R.drawable.tab4, R.drawable.tab5};
    private int[] gallery_bg = new int[]{R.drawable.wt1, R.drawable.wt2, R.drawable.wt3, R.drawable.wt4, R.drawable.wt5};
    private ViewPager vp_slider;
    private TextView loginBtn;
    private ArrayList<Walkthrough> slider_image_list, slider_image_list_tab;
    private PageAdapter sliderPagerAdapter;

    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getResources().getBoolean(R.bool.isTablet)) {
            setContentView(R.layout.tab_landing_page);
        } else {
            setContentView(R.layout.landing_page);
        }
        init();

    }


    private void init() {

        if (getResources().getBoolean(R.bool.isTablet)) {
            rootLayout = findViewById(R.id.rootLayout);
        } else {
            rootLayout_mobile = findViewById(R.id.rootLayout);
        }

        vp_slider = (ViewPager) findViewById(R.id.vp_slider);

        bullets[0] = findViewById(R.id.bullet1);
        bullets[1] = findViewById(R.id.bullet2);
        bullets[2] = findViewById(R.id.bullet3);
        bullets[3] = findViewById(R.id.bullet4);
        bullets[4] = findViewById(R.id.bullet5);
        bullets[0].setImageResource(R.drawable.selected_bullet);
        loginBtn = findViewById(R.id.loginBtn);

        if (getResources().getBoolean(R.bool.isTablet)) {
            slider_image_list_tab = new ArrayList<>();

            slider_image_list_tab.add(new Walkthrough(getString(R.string.title_1), getString(R.string.des_1), R.drawable.tab_banner_1, 1));
            slider_image_list_tab.add(new Walkthrough(getString(R.string.title_2), getString(R.string.des_2), R.drawable.tab_banner_2, 2));
            slider_image_list_tab.add(new Walkthrough(getString(R.string.title_3), getString(R.string.des_3), R.drawable.tab_banner_3, 3));
            slider_image_list_tab.add(new Walkthrough(getString(R.string.title_4), getString(R.string.des_4), R.drawable.tab_banner_4, 4));
            slider_image_list_tab.add(new Walkthrough(getString(R.string.title_5), getString(R.string.des_5), R.drawable.tab_banner_5, 5));
            sliderPagerAdapter = new PageAdapter(LandingPage.this, slider_image_list_tab);

        } else {
            slider_image_list = new ArrayList<>();
            slider_image_list.add(new Walkthrough(getString(R.string.title_1), getString(R.string.des_1), R.drawable.walk_banner_1, 1));
            slider_image_list.add(new Walkthrough(getString(R.string.title_2), getString(R.string.des_2), R.drawable.walk_banner_2, 2));
            slider_image_list.add(new Walkthrough(getString(R.string.title_3), getString(R.string.des_3), R.drawable.walk_banner_3, 3));
            slider_image_list.add(new Walkthrough(getString(R.string.title_4), getString(R.string.des_4), R.drawable.walk_banner_4, 4));
            slider_image_list.add(new Walkthrough(getString(R.string.title_5), getString(R.string.des_5), R.drawable.walk_banner_5, 5));
            sliderPagerAdapter = new PageAdapter(LandingPage.this, slider_image_list);
        }
        vp_slider.setAdapter(sliderPagerAdapter);

        vp_slider.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                livePage = position;
                if (getResources().getBoolean(R.bool.isTablet)) {
                    rootLayout.setBackgroundResource(gallery_bg_tab[position]);
                } else {

                    rootLayout_mobile.setBackgroundResource(gallery_bg[position]);
                }
            }

            @Override
            public void onPageSelected(int position) {
                for (int j = 0; j < 5; j++) {
                    if (j == position) {
                        bullets[j].setImageResource(R.drawable.selected_bullet);
                    } else {
                        bullets[j].setImageResource(R.drawable.bullet);
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LandingPage.this, LoginActivity.class));
            }
        });
        bullets[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vp_slider.setCurrentItem(0, true);
            }
        });
        bullets[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vp_slider.setCurrentItem(1, true);
            }
        });
        bullets[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vp_slider.setCurrentItem(2, true);
            }
        });
        bullets[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vp_slider.setCurrentItem(3, true);
            }
        });
        bullets[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vp_slider.setCurrentItem(4, true);
            }
        });
        final Runnable Update = new Runnable() {
            public void run() {
                if (livePage == 5) {
                    livePage = 0;
                }
                vp_slider.setCurrentItem(livePage++, true);
            }
        };
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 80, 4500);


    }

    @Override
    public void onBackPressed() {
        finishNoTransition();
    }

}

