package com.vgroupinc.assignment3.alerts;

import android.content.Context;
import android.os.Build;
import android.widget.ProgressBar;

/**
 * Created by DELL on 12/5/2017.
 */

public class ProgressBuilder {

    private static final ProgressBuilder ourInstance = new ProgressBuilder();
    private ProgressBar progressBar;


    private ProgressBuilder() {
    }

    public static ProgressBuilder getInstance() {
        return ourInstance;
    }

    public void showProgress(Context context) {
        progressBar = new ProgressBar(context);
        progressBar.setIndeterminate(true);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            progressBar.setElevation(25);
        }


//        progressBar;
//        progressBar.set
    }
}
