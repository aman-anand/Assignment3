package com.vgroupinc.assignment3.dashboard.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.vgroupinc.assignment3.R;
import com.vgroupinc.assignment3.base.picasso.PicassoImp;
import com.vgroupinc.assignment3.dashboard.bean.Tournaments.ActiveTournaments;
import com.vgroupinc.assignment3.utils.Utils;

/**
 * Created by DELL on 12/13/2017.
 */

public class TournamentAdapter extends BaseAdapter {
    ViewHolder holder;
    int count = 0;
    private ActiveTournaments tournament;
    private LayoutInflater inflater;
    private Context activity;
    //    private int[] color_array;
    //    private int color;
    private int color;

    public TournamentAdapter(ActiveTournaments tournament, Context context) {
        this.tournament = tournament;
        this.activity = context;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
}


    @Override
    public int getCount() {
        return tournament.getList().size();
    }

    @Override
    public Object getItem(int position) {
        return tournament.getList().get(position);
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
        holder.name.setText(tournament.getList().get(position).getName());
        String date = Utils.formatDate(tournament.getList().get(position).getStartDate());
        holder.date.setText(date);
        if (tournament.getList().get(position).getHype()) {
            PicassoImp.getInstance().setImageBackground("Tournament",tournament.getList().get(position).getImageKey(),activity,position,holder.imageView);
        }else{
            PicassoImp.getInstance().setImage(tournament.getList().get(position).getImageKey(), activity, position, holder.imageView);
        }
        return convertView;
    }

    private static class ViewHolder {
        ImageView imageView = null;
        TextView name = null, date = null;
    }

}
