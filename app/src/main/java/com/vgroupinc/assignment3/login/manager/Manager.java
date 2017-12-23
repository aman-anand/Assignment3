package com.vgroupinc.assignment3.login.manager;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;

import com.vgroupinc.assignment3.R;
import com.vgroupinc.assignment3.base.BaseActivity;

/**
 * Created by DELL on 12/5/2017.
 */

public abstract class Manager extends BaseActivity {


    public void toggleView(Context context, final RelativeLayout view, final RelativeLayout alter_screen) {
        switch (view.getVisibility()) {
            case View.VISIBLE:
                Animation slide_out = AnimationUtils.loadAnimation(context, R.anim.slide_out_bottom);
                slide_out.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        alter_screen.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        view.setVisibility(View.INVISIBLE);
                    }
                });
                view.startAnimation(slide_out);
                break;
            case View.INVISIBLE:
                Animation slide_in = AnimationUtils.loadAnimation(context, R.anim.slide_in_bottom);
                slide_in.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                        view.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        alter_screen.setVisibility(View.INVISIBLE);
                    }
                });

                view.startAnimation(slide_in);
                break;
            default:
                break;

        }
    }

}
