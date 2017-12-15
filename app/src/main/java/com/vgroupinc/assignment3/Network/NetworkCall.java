package com.vgroupinc.assignment3.Network;

import android.content.Context;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.vgroupinc.assignment3.login.bean.User;

import org.json.JSONException;

/**
 * Created by DELL on 12/5/2017.
 */

public class NetworkCall {
    public static Response.Listener listener = new Response.Listener() {
        @Override
        public void onResponse(Object response) {

        }
    };
    public static Response.ErrorListener errorListener = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {

        }
    };

    public static void login(Context context, User user) throws JSONException {
        NetworkRequest.getInstance(context).login(user.getUsername(), user.getPassword());
    }
}
