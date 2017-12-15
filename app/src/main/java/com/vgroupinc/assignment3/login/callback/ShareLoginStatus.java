package com.vgroupinc.assignment3.login.callback;

import com.vgroupinc.assignment3.login.bean.LoggedInUser;
import com.vgroupinc.assignment3.login.bean.User;

/**
 * Created by DELL on 12/5/2017.
 */

public interface ShareLoginStatus {
    void onLoginSuccess(LoggedInUser loggedInUser, User userData);

    void onLoginFail(String error);

}
