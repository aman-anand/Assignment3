package com.vgroupinc.assignment3.dashboard.navbar;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.vgroupinc.assignment3.R;

/**
 * Created by DELL on 12/15/2017.
 */

public class NavAdapter extends BaseAdapter {
    int count = 0;
    private NavBean mNavBean;
    private Activity activity;
    private LayoutInflater inflater;
    private ProfileImage profileImage;
    private UserInfo userInfo;
    private Menu menu;

    public NavAdapter(NavBean mNavBean, Activity activity) {
        this.mNavBean = mNavBean;
        this.activity = activity;
        this.inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return 9;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        switch (position) {
            case 0:
                View user_image;
                user_image = inflater.inflate(R.layout.nav_image, null);
                if (profileImage == null) {
                    profileImage = new ProfileImage();
                }
                profileImage.imageView = user_image.findViewById(R.id.profile_image_drawer);
                Picasso.with(activity).load(mNavBean.getImageKey()).placeholder(R.drawable.user_profile_icon).into(profileImage.imageView);
                return user_image;
            case 1:
                View player_info;
                player_info = inflater.inflate(R.layout.nav_player_info, null);
                if (userInfo == null) {
                    userInfo = new UserInfo();
                }
                userInfo.name = player_info.findViewById(R.id.playerName_drawer);
                userInfo.user_name = player_info.findViewById(R.id.location_drawer);
                userInfo.name.setText(mNavBean.getName());
                userInfo.user_name.setText("\u0040" + mNavBean.getUserName());
                return player_info;
            default:
                View menu_view;
                menu_view = inflater.inflate(R.layout.nav_menu_item, null);
                if (menu == null) {
                    menu = new Menu();
                }
                menu.menuItem = menu_view.findViewById(R.id.menuItem);
                menu.menuItem.setText(mNavBean.getNavItem(position - 2));
                count++;
                return menu_view;
        }
    }

    class ProfileImage {
        ImageView imageView = null;
    }

    class UserInfo {
        TextView name = null, user_name = null;
    }

    class Menu {
        TextView menuItem = null;
    }
}
