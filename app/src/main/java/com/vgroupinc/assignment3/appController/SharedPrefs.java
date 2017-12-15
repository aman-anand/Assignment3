package com.vgroupinc.assignment3.appController;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.vgroupinc.assignment3.login.bean.User;

/**
 * Created by DELL on 12/5/2017.
 */

public class SharedPrefs {

    private static final String USER_NAME = "username";
    private static final String PASSWORD = "password";
    private static final String LOGIN_STATUS = "loginStatus";

    static SharedPreferences getSharedPreferences(Context ctx) {
        return PreferenceManager.getDefaultSharedPreferences(ctx);
    }

    public static void setUserData(Context ctx, String userName, String password, boolean loginStatus) {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.putString(USER_NAME, userName);
        editor.putString(PASSWORD, password);
        editor.putBoolean(LOGIN_STATUS, loginStatus);
        editor.apply();
//            editor.commit();
    }


    public static User getUserData(Context ctx) {
        return new User(getSharedPreferences(ctx).getString(USER_NAME, ""),
                getSharedPreferences(ctx).getString(PASSWORD, ""),
                getSharedPreferences(ctx).getBoolean(LOGIN_STATUS, false));
    }

    public static void clearData(Context ctx) {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();

        editor.putString(USER_NAME, "");
        editor.putString(PASSWORD, "");
        editor.putBoolean(LOGIN_STATUS, false);
        editor.apply();
    }

}
