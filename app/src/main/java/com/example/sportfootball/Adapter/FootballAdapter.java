package com.example.sportfootball.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TextView;

import com.example.sportfootball.R;
import com.example.sportfootball.Model.StandingModel.TableItem;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class FootballAdapter extends RecyclerView.Adapter<FootballAdapter.ViewHolder> {
    private ArrayList<TableItem> tables = new ArrayList<>();

    public Context context;

    public FootballAdapter(Context context) {
        this.context = context;
    }

    public void setData(ArrayList<TableItem> items) {
        tables.clear();
        tables.addAll(items);
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public FootballAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_standings, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FootballAdapter.ViewHolder holder, int position) {
        int pos = position+1;
        holder.tvRank.setText(String.valueOf(pos));
        pos ++;
        holder.tvNama.setText(tables.get(position).getName());
        holder.tvW.setText(String.valueOf(tables.get(position).getWin()));
        holder.tvD.setText(String.valueOf(tables.get(position).getDraw()));
        holder.tvL.setText(String.valueOf(tables.get(position).getLoss()));
        holder.tvGd.setText(String.valueOf(tables.get(position).getGoalsdifference()));
        holder.tvPoints.setText(String.valueOf(tables.get(position).getTotal()));

    }

    @Override
    public int getItemCount() {
        return tables.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNama, tvW, tvD, tvL,  tvGd, tvPoints,tvRank;
        TableLayout tableItemlist;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.tv_nama);
            tvD= itemView.findViewById(R.id.tv_d);
            tvW=itemView.findViewById(R.id.tv_w);
            tvL=itemView.findViewById(R.id.tv_l);
            tvGd=itemView.findViewById(R.id.tv_gd);
            tvPoints=itemView.findViewById(R.id.tv_pts);
            tvRank=itemView.findViewById(R.id.tv_rank);
            tableItemlist = itemView.findViewById(R.id.table_itemlist);
        }
    }
}
