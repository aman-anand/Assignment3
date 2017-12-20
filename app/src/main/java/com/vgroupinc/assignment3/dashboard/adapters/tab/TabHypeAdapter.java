package com.vgroupinc.assignment3.dashboard.adapters.tab;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.vgroupinc.assignment3.base.Network.NetworkConfig;
import com.vgroupinc.assignment3.R;
import com.vgroupinc.assignment3.dashboard.bean.HypeSearch.HypeSearchBean;
import com.vgroupinc.assignment3.base.picasso.PicassoImp;
import com.vgroupinc.assignment3.utils.Utils;

/**
 * Created by DELL on 12/15/2017.
 */
public class TabHypeAdapter extends RecyclerView.Adapter<TabHypeAdapter.ViewHolder> {
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
        View view = inflater.inflate(R.layout.tab_list_item_hype, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final TabHypeAdapter.ViewHolder holder, int position) {
        holder.nameTv.setText(searchBean.getList().get(position).getName());
        holder.dateTv.setText(Utils.formatDate(searchBean.getList().get(position).getStartDate()));
        String str = searchBean.getList().get(position).getHypableType();
        if (str.equals("TOURNAMENT")) {

            holder.gameTv.setText(searchBean.getList().get(position).getGame());
            holder.venueTv.setText(searchBean.getList().get(position).getVenue());
        } else {
            holder.venueTv.setVisibility(View.GONE);
            holder.gameTv.setVisibility(View.GONE);
        }
        PicassoImp.getInstance().setImageBackground(searchBean.getList().get(position).getHypableType(),
                NetworkConfig.IMAGE_DOWNLOAD_URL + searchBean.getList().get(position).getImageKey(),
                activity,
                position,
                holder.imageView);
    }

    @Override
    public int getItemCount() {
        return searchBean.getList().size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameTv, dateTv, gameTv, venueTv;
        ImageView imageView;

        ViewHolder(View itemView) {
            super(itemView);
            nameTv = itemView.findViewById(R.id.tournamentName);
            dateTv = itemView.findViewById(R.id.date01);
            gameTv = itemView.findViewById(R.id.game);
            venueTv = itemView.findViewById(R.id.location);
            imageView = itemView.findViewById(R.id.bg_image);

        }

    }

}