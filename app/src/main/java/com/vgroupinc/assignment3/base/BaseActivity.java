package com.vgroupinc.assignment3.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.android.volley.NetworkResponse;
import com.android.volley.VolleyError;
import com.vgroupinc.assignment3.R;
import com.vgroupinc.assignment3.alerts.AlertBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by DELL on 11/30/2017.
 */

public abstract class BaseActivity extends AppCompatActivity {

    protected boolean isTab = false;

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
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getResources().getBoolean(R.bool.isTablet)) {
            isTab = true;
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE);
        } else {
            isTab = false;
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
    }

    public void makeToast(String message) {
//        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public void handleError(VolleyError error, Context context) {
        NetworkResponse response = error.networkResponse;
        if (response != null) {
            String str = new String(response.data);
            String errorMessage = new String(response.data);

            try {
                JSONObject jsonObject = new JSONObject(str);
                JSONArray jsonArray = jsonObject.getJSONArray("errorMessages");
                errorMessage = (String) jsonArray.get(0);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            showAlert((Activity) context, errorMessage, 1);
            Log.e("error", str);
        }
    }
}

