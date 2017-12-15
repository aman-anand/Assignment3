package com.vgroupinc.assignment3.base;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.vgroupinc.assignment3.R;
import com.vgroupinc.assignment3.alerts.AlertBuilder;

/**
 * Created by DELL on 11/30/2017.
 */

public abstract class BaseActivity extends AppCompatActivity {


    @Override
    public void finish() {
        super.finish();
        onLeaveThisActivity();
    }

    public void finishNoTransition() {
        super.finish();

    }

    protected void onLeaveThisActivity() {
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    // It's cleaner to animate the start of new activities the same way.
    // Override startActivity(), and call *overridePendingTransition*
    // right after the super, so every single activity transaction will be animated:

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
        onStartNewActivity();
    }

    @Override
    public void startActivity(Intent intent, Bundle options) {
        super.startActivity(intent, options);
        onStartNewActivity();
    }

    protected void onStartNewActivity() {
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    public void showAlert(Activity activity, String message, int title) {
        AlertBuilder.getInstance().getDialog(activity, message, title);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getResources().getBoolean(R.bool.isTablet)) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        } else {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
    }

    public void makeToast(String message) {
//        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}

