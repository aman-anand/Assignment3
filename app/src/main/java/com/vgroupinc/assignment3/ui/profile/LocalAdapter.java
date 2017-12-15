package com.vgroupinc.assignment3.ui.profile;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.vgroupinc.assignment3.R;

import java.util.ArrayList;

/**
 * Created by DELL on 11/20/2017.
 */

public class LocalAdapter extends BaseAdapter {
    Activity activity;
    LayoutInflater inflater;
    ArrayList<Tournament> tournamentArrayList;
    ViewHolder holder;

    public LocalAdapter(Activity activity, ArrayList<Tournament> ArrayList) {

        this.activity = activity;
        this.tournamentArrayList = ArrayList;
        inflater = LayoutInflater.from(activity);
    }

    @Override
    public int getCount() {
        return tournamentArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return tournamentArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        holder = new ViewHolder();
        convertView = inflater.inflate(R.layout.list_item, null);
        holder.imageView = convertView.findViewById(R.id.bg_image);
        holder.name = convertView.findViewById(R.id.tournamentName);
        holder.date = convertView.findViewById(R.id.date01);
        holder.name.setText(tournamentArrayList.get(position).getName());
        holder.date.setText(tournamentArrayList.get(position).getDate());
        holder.imageView.setImageDrawable(activity.getResources().getDrawable(tournamentArrayList.get(position).getImageName()));


        return convertView;
    }

    private class ViewHolder {
        ImageView imageView = null;
        TextView name = null, date = null;
    }
}
