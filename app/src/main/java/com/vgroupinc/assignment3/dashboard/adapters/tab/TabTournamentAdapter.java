package com.vgroupinc.assignment3.dashboard.adapters.tab;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.vgroupinc.assignment3.R;
import com.vgroupinc.assignment3.dashboard.bean.Tournaments.ActiveTournaments;
import com.vgroupinc.assignment3.picasso.PicassoImp;
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

    public TabTournamentAdapter(ActiveTournaments tournaments, Context context, RecyclerView mRecyclerView) {
        this.activity = (Activity) context;
        this.tournaments = tournaments;
        this.inflater = LayoutInflater.from(context);
        this.mRecyclerView = mRecyclerView;
    }

    @Override
    public TabTournamentAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.tab_list_item, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(final TabTournamentAdapter.ViewHolder holder, int position) {
        String date = Utils.formatDate(tournaments.getList().get(position).getStartDate());
        holder.nameTv.setText(tournaments.getList().get(position).getName());
        holder.dateTv.setText(date);
        PicassoImp.getInstance().setImage(tournaments.getList().get(position).getImageKey(), activity, position, holder.imageView);


    }

    @Override
    public int getItemCount() {
        return tournaments.getList().size();
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
