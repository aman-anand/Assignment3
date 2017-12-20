package com.vgroupinc.assignment3.dashboard.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.vgroupinc.assignment3.base.Network.NetworkConfig;
import com.vgroupinc.assignment3.R;
import com.vgroupinc.assignment3.dashboard.bean.HypeSearch.HypeSearchBean;
import com.vgroupinc.assignment3.base.picasso.PicassoImp;
import com.vgroupinc.assignment3.utils.Utils;

/**
 * Created by DELL on 12/13/2017.
 */

public class HypeAdapter extends BaseAdapter {
    private HypeSearchBean hypeSearch;
    private ViewHolder holder;
    private Activity activity;
    private LayoutInflater inflater;
//    private boolean hypable = false;

    public HypeAdapter(Context context, HypeSearchBean hypeSearch) {
        this.hypeSearch = hypeSearch;
        activity = (Activity) context;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return hypeSearch.getList().size();
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
        holder = new ViewHolder();
        convertView = inflater.inflate(R.layout.list_item_hype, null);
        String str = hypeSearch.getList().get(position).getHypableType();
        if (str.equals("TOURNAMENT")) {
            holder.imageView = convertView.findViewById(R.id.bg_image);
            holder.name = convertView.findViewById(R.id.tournamentName);
            holder.location = convertView.findViewById(R.id.location);
            holder.game = convertView.findViewById(R.id.game);
            holder.date = convertView.findViewById(R.id.date01);

            holder.name.setText(hypeSearch.getList().get(position).getName());
            holder.game.setText(hypeSearch.getList().get(position).getGame());
            holder.location.setText(hypeSearch.getList().get(position).getVenue());
            holder.date.setText(Utils.formatDate(hypeSearch.getList().get(position).getStartDate()));
        } else {
            holder.imageView = convertView.findViewById(R.id.bg_image);
            holder.name = convertView.findViewById(R.id.tournamentName);
            holder.location = convertView.findViewById(R.id.location);
            holder.game = convertView.findViewById(R.id.game);
            holder.date = convertView.findViewById(R.id.date01);
            holder.location.setVisibility(View.GONE);
            holder.game.setVisibility(View.GONE);
            holder.name.setText(hypeSearch.getList().get(position).getName());
//            String date = Utils.formatDate(hypeSearch.getList().get(position).getStartDate());
            holder.date.setText(Utils.formatDate(hypeSearch.getList().get(position).getStartDate()));
        }

        PicassoImp.getInstance().setImageBackground(hypeSearch.getList().get(position).getHypableType(),
                NetworkConfig.IMAGE_DOWNLOAD_URL + hypeSearch.getList().get(position).getImageKey(),
                activity,
                position,
                holder.imageView);

        return convertView;
    }

    @Override
    public int getItemViewType(int position) {

        return super.getItemViewType(position);
    }

    private class ViewHolder {
        ImageView imageView = null;
        TextView name = null, date = null, game = null, location = null;
    }
}
