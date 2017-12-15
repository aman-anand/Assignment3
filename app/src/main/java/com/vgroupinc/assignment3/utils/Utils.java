package com.vgroupinc.assignment3.utils;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.support.annotation.NonNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by DELL on 10/3/2017.
 */

public class Utils {
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

        dateResult += date.getDay() + ", ";
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

        dateResult += String.valueOf(week) + " weeks";
        return dateResult;
    }
}
