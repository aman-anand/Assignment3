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
import com.vgroupinc.assignment3.dashboard.bean.Tournaments.ActiveTournaments;
import com.vgroupinc.assignment3.dashboard.callbacks.OnLoadMoreListener;
import com.vgroupinc.assignment3.utils.Utils;

/**
 * Created by DELL on 12/15/2017.
 */

public class TabTournamentAdapter extends RecyclerView.Adapter<TabTournamentAdapter.ViewHolder> {
    private ActiveTournaments tournaments;
    private Activity activity;
    private LayoutInflater inflater;
    private int count = 0;
    private RecyclerView mRecyclerView;
    private int visibleThreshold = 5;
    private int lastVisibleItem, totalItemCount;
    private boolean loading;
    private OnLoadMoreListener onLoadMoreListener;

    public TabTournamentAdapter(ActiveTournaments tournaments, Context context, RecyclerView mRecyclerView) {
        this.activity = (Activity) context;
        this.tournaments = tournaments;
        this.inflater = LayoutInflater.from(context);
        this.mRecyclerView=mRecyclerView;
    }

    @Override
    public TabTournamentAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.tab_list_item, parent, false);
        return new ViewHolder(view);
//        if (mRecyclerView.getLayoutManager() instanceof GridLayoutManager) {
//            final GridLayoutManager layoutManager = (GridLayoutManager) mRecyclerView.getLayoutManager();
//            mRecyclerView
//                    .addOnScrollListener(new RecyclerView.OnScrollListener() {
//                        @Override
//                        public void onScrolled(RecyclerView recyclerView,
//                                               int dx, int dy) {
//                            super.onScrolled(recyclerView, dx, dy);
//
//
//                            totalItemCount = layoutManager.getItemCount();
//                            lastVisibleItem = layoutManager.findLastVisibleItemPosition();
//                            if (!loading
//                                    && totalItemCount <= (lastVisibleItem + visibleThreshold)) {
//                                // End has been reached
//                                // Do something
//                                if (onLoadMoreListener != null) {
//                                    onLoadMoreListener.onLoadMore();
//                                }
//                                loading = true;
//                            }
//                        }
//                    });
//        }
    }

    @Override
    public void onBindViewHolder(final TabTournamentAdapter.ViewHolder holder, int position) {
        String date = Utils.formatDate(tournaments.getList().get(position).getStartDate());
        holder.nameTv.setText(tournaments.getList().get(position).getName());
        holder.dateTv.setText(date);
        if (!TextUtils.isEmpty((CharSequence) tournaments.getList().get(position).getImageKey())) {
            int color = getColor();
            Picasso.with(activity)
                    .load(NetworkConfig.IMAGE_DOWNLOAD_URL + tournaments.getList().get(position).getImageKey())
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
            int color = getColor();
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
    }

    @Override
    public int getItemCount() {
        return tournaments.getList().size();
    }

    private int getColor() {
        if (count > 11) {
            count = 0;
        }
        int color = Utils.getColor(count);
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
