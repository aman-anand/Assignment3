package com.vgroupinc.assignment3.base.Network;

import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.vgroupinc.assignment3.appController.AppController;
import com.vgroupinc.assignment3.login.bean.LoggedInUser;
import com.vgroupinc.assignment3.login.bean.User;
import com.vgroupinc.assignment3.login.callback.ShareLoginStatus;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by DELL on 11/30/2017.
 */
public class NetworkRequest {
    private static final String TAG = NetworkRequest.class.getSimpleName();
    private static NetworkRequest mInstance;
    private  Context mCtx;

    private static ShareLoginStatus shareLoginStatus;


    private RequestQueue mRequestQueue;
    //    private ImageLoader mImageLoader;
    private Gson gson = new Gson();

    private NetworkRequest(Context context) {
        mCtx = context;
        mRequestQueue = getRequestQueue();

    }

    public static synchronized NetworkRequest getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new NetworkRequest(context);
        }

        return mInstance;
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(mCtx.getApplicationContext());
        }
        return mRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }

    public void login(final String username, final String pass) throws JSONException {
        shareLoginStatus = (ShareLoginStatus) mCtx;
        final Map<String, String> params = new HashMap<>();
        params.put("username", username);
        params.put("password", pass);
        final JSONObject object = new JSONObject(params);
        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.POST, NetworkConfig.BASE_URL + NetworkConfig.LOGIN, object, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(final JSONObject response) {
                        parseResponse(response);

                        shareLoginStatus.onLoginSuccess(gson.fromJson(response.toString(), LoggedInUser.class), new User(username, pass, true));
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO Auto-generated method stub
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
                            shareLoginStatus.onLoginFail(errorMessage);
                            Log.e("error", str);
                        }
                    }
                }

                ) {
            @Override
            public String getPostBodyContentType() {
                return "application/json";
            }


            @Override
            public String getBodyContentType() {
                return "application/json";
            }

            @Override
            public byte[] getBody() {
                return object.toString().getBytes();
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("api-version", "TE_Android_" + AppController.getInstance().version);

                return headers;
            }


        };

        int socketTimeout = 180000;//30 seconds - change to what you want
        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        jsObjRequest.setRetryPolicy(policy);
// Access the RequestQueue through your singleton class.
        addToRequestQueue(jsObjRequest);

    }

    private void parseResponse(JSONObject response) {
        LoggedInUser inUser = gson.fromJson(response.toString(), LoggedInUser.class);
        AppController.getInstance().setLoggedInUser(inUser);

    }
}