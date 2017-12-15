package com.vgroupinc.assignment3.dashboard.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.vgroupinc.assignment3.R;
import com.vgroupinc.assignment3.dashboard.bean.notifications.Notifications;
import com.vgroupinc.assignment3.utils.Utils;

/**
 * Created by DELL on 12/13/2017.
 */

public class NotificationAdapter extends BaseAdapter {
    private Notifications notifications;
    private LayoutInflater inflater;
    private Context context;

    public NotificationAdapter(Notifications notifications, Context context) {
        this.notifications = notifications;
        this.context = context;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return notifications.getList().size();
    }

    @Override
    public Object getItem(int position) {
        return notifications.getList().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = inflater.inflate(R.layout.notification_item, null);
        TextView tv = view.findViewById(R.id.text);
        String string = Utils.getWeeks(notifications.getList().get(position).getDate());
        tv.setText(notifications.getList().get(position).getNotificationHeader() + " " + string);
        return view;
    }
}
