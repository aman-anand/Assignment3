package com.vgroupinc.assignment3.ui.landing.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.vgroupinc.assignment3.R;
import com.vgroupinc.assignment3.ui.landing.bean.Walkthrough;

import java.util.ArrayList;

/**
 * Created by DELL on 11/30/2017.
 */

public class PageAdapter extends PagerAdapter {
    Activity activity;
    ArrayList<Walkthrough> image_arraylist;
    LayoutInflater layoutInflater;
    ViewHolder holder;

    public PageAdapter(Activity activity, ArrayList<Walkthrough> image_arraylist) {
        this.activity = activity;
        this.image_arraylist = image_arraylist;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view;
        if (activity.getResources().getBoolean(R.bool.isTablet)) {
            view = layoutInflater.inflate(R.layout.tab_layout_slider, container, false);
        } else {
            view = layoutInflater.inflate(R.layout.layout_slider, container, false);
        }
        if (holder == null) {
            holder = new ViewHolder();
        }
        holder.imageView = (ImageView) view.findViewById(R.id.im_slider);
        holder.title = view.findViewById(R.id.heading);
        holder.des = view.findViewById(R.id.description);
        holder.title.setText(image_arraylist.get(position).getTitle());
        holder.imageView.setImageResource(image_arraylist.get(position).getImage());
        holder.des.setText("" + image_arraylist.get(position).getDes());


        container.addView(view);

        return view;
    }

    @Override
    public int getCount() {
        return image_arraylist.size();
    }


    @Override
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view = (View) object;
        container.removeView(view);
    }

    class ViewHolder {
        private ImageView imageView = null;
        private TextView title = null, des = null;
    }
}
