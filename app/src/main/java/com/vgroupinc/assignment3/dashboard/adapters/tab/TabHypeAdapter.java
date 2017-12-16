package com.vgroupinc.assignment3.dashboard.adapters.tab;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;
import com.vgroupinc.assignment3.Network.NetworkConfig;
import com.vgroupinc.assignment3.R;
import com.vgroupinc.assignment3.dashboard.bean.HypeSearch.HypeSearchBean;
import com.vgroupinc.assignment3.utils.Utils;

/**
 * Created by DELL on 12/15/2017.
 */
public class TabHypeAdapter extends RecyclerView.Adapter<TabHypeAdapter.ViewHolder> {
    int count = 0;
    private HypeSearchBean searchBean;
    private Activity activity;
    private LayoutInflater inflater;

    public TabHypeAdapter(HypeSearchBean searchBean, Context context) {
        this.searchBean = searchBean;
        this.inflater = LayoutInflater.from(context);
        this.activity = (Activity) context;
    }

    @Override
    public TabHypeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.tab_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final TabHypeAdapter.ViewHolder holder, int position) {
        String date = Utils.formatDate(searchBean.getList().get(position).getStartDate());
        holder.nameTv.setText(searchBean.getList().get(position).getName());
        holder.dateTv.setText(date);
        if (!TextUtils.isEmpty(searchBean.getList().get(position).getImageKey())) {
            int color=getColor();
            Picasso.with(activity)
                    .load(NetworkConfig.IMAGE_DOWNLOAD_URL + searchBean.getList().get(position).getImageKey())
                    .placeholder(color)
                    .error(color)
                    .placeholder(color)
                    .into(new Target() {
                        @Override
                        public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                            holder.imageView.setBackground(new BitmapDrawable(activity.getResources(), bitmap));
                        }

                        @Override
                        public void onBitmapFailed(Drawable errorDrawable) {
                            holder.imageView.setBackground(errorDrawable);
                        }

                        @Override
                        public void onPrepareLoad(Drawable placeHolderDrawable) {
                            holder.imageView.setBackground(placeHolderDrawable);
                        }
                    });

        } else {
            int color=getColor();
            Picasso.with(activity)
                    .load(color)
                    .placeholder(color)
                    .error(color)
                    .into(new Target() {
                        @Override
                        public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                            holder.imageView.setBackground(new BitmapDrawable(activity.getResources(), bitmap));
                        }

                        @Override
                        public void onBitmapFailed(Drawable errorDrawable) {
                            holder.imageView.setBackground(errorDrawable);
                        }

                        @Override
                        public void onPrepareLoad(Drawable placeHolderDrawable) {
                            holder.imageView.setBackground(placeHolderDrawable);
                        }
                    });

        }
        switch (searchBean.getList().get(position).getHypableType()) {
            case "EVENT":
                holder.imageView.setImageResource(R.drawable.hype_border_blue);
                break;
            case "TOURNAMENT":
                holder.imageView.setImageResource(R.drawable.hype_border);
                break;
        }

    }

    @Override
    public int getItemCount() {
        return searchBean.getList().size();
    }

    private int getColor() {
        if (count > 11) {
            count = 0;
        }
        int color=Utils.getColor(count);
        count++;
        return color;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
         TextView nameTv, dateTv;
         ImageView imageView;

         ViewHolder(View itemView) {
            super(itemView);
            nameTv = itemView.findViewById(R.id.tournamentName);
            dateTv = itemView.findViewById(R.id.date01);
            imageView = itemView.findViewById(R.id.bg_image);

        }

    }

}