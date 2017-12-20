package com.vgroupinc.assignment3.utils;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.vgroupinc.assignment3.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by DELL on 10/3/2017.
 */

public class Utils {
    public static int[] color_array = new int[]{R.color.a, R.color.b, R.color.c, R.color.d, R.color.e, R.color.f, R.color.g, R.color.h, R.color.i, R.color.j, R.color.k, R.color.l};

    public static boolean checkInternet(Activity context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null;
    }

    @NonNull
    public static String formatDate(String dateString) {

//            String dtStart = "11/08/2013 08:48:10";
        Date date = new Date();
        String dateResult = "";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        try {
            date = format.parse(dateString);//2017-11-10T17:13:07Z   MM/dd/yyyy HH:mm:ss

        } catch (ParseException e) {
            e.printStackTrace();
        }
        switch (date.getMonth()) {
            case 0:
                dateResult += "Jan ";
                break;
            case 1:
                dateResult += "Feb ";
                break;
            case 2:
                dateResult += "Mar ";
                break;
            case 3:
                dateResult += "Apr ";
                break;
            case 4:
                dateResult += "May ";
                break;
            case 5:
                dateResult += "Jun ";
                break;
            case 6:
                dateResult += "Jul ";
                break;
            case 7:
                dateResult += "Aug ";
                break;
            case 8:
                dateResult += "Sep ";
                break;
            case 9:
                dateResult += "Oct ";
                break;
            case 10:
                dateResult += "Nov ";
                break;
            case 11:
                dateResult += "Dec ";
                break;

        }
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar2.clear();
        calendar2.setTime(date);


        calendar.getTimeInMillis();

        dateResult += date.getDate() + ", ";
        dateResult += date.toString().substring(date.toString().length() - 4);
        return dateResult;
    }

    public static String getWeeks(String dateString) {

//            String dtStart = "11/08/2013 08:48:10";
        Date date = new Date();
        String dateResult = "";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        try {
            date = format.parse(dateString);//2017-11-10T17:13:07Z   MM/dd/yyyy HH:mm:ss

        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar2.clear();
        calendar2.setTime(date);
        calendar.getTimeInMillis();

        long diff = calendar.getTimeInMillis() - calendar2.getTimeInMillis();

        float dayCount = (float) diff / (24 * 60 * 60 * 1000);

        int week = (int) (dayCount / 7);
//        System.out.println(week);
        if (week > 0) {
            dateResult += String.valueOf(week) + " weeks";

        } else {
            dayCount = Math.round(dayCount);
//            int d= (int) dayCount;
            dateResult += String.valueOf((int) dayCount) + " days";
        }
        return dateResult;
    }

//    public static int getColor(int count) {
//        if (count > 11) {
//            count = 0;
//        }
//        switch (count) {
//            case 0:
////                count++;
//                return R.color.a;
//            case 1:
////                count++;
//                return R.color.b;
//            case 2:
////                count++;
//                return R.color.c;
//            case 3:
////                count++;
//                return R.color.d;
//            case 4:
////                count++;
//                return R.color.e;
//            case 5:
////                count++;
//                return R.color.f;
//            case 6:
////                count++;
//                return R.color.g;
//            case 7:
////                count++;
//                return R.color.h;
//            case 8:
////                count++;
//                return R.color.i;
//            case 9:
////                count++;
//                return R.color.j;
//            case 10:
////                count++;
//                return R.color.k;
//            case 11:
////                count++;
//                return R.color.l;
//            default:
////                count++;
//                return R.color.c;
//        }
//
//
//    }

    public static int getColorPosition(int position) {
        return position % color_array.length;
    }

    public static void hideKeyboard(View view, Context context) {

        InputMethodManager imm = (InputMethodManager) context.getApplicationContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null) {
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}
