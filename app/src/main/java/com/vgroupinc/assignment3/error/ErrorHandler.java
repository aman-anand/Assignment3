package com.vgroupinc.assignment3.error;

import android.util.Log;

import com.android.volley.NetworkResponse;
import com.android.volley.VolleyError;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by DELL on 12/15/2017.
 */

public class ErrorHandler {
    public static void handleError(VolleyError error){
        NetworkResponse response = error.networkResponse;
        if (response != null) {
            String str = new String(response.data);
            String errorMessage = new String(response.data);

            try {
                JSONObject jsonObject=new JSONObject(str);
                JSONArray jsonArray=jsonObject.getJSONArray("errorMessages");
                errorMessage= (String) jsonArray.get(0);
            } catch (JSONException e) {
                e.printStackTrace();
            }

//            shareLoginStatus.onLoginFail(errorMessage);
            Log.e("error", str);
        }
    }
}
