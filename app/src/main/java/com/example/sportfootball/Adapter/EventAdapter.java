package com.example.sportfootball.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.sportfootball.Model.MatchModel.EventsItem;
import com.example.sportfootball.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder> {

    private ArrayList<EventsItem> Event = new ArrayList<>();
    //mengizinkan untuk mengakses sumber dan class khusus
    public Context context;

    public EventAdapter(Context context) {
        this.context = context;
    }

    public void setEvent(ArrayList<EventsItem> event) {
        Event.clear();
        Event.addAll(event);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_itemlist, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.tvTeam1.setText(String.valueOf(Event.get(position).getStrHomeTeam()));
        holder.tvTeam2.setText(String.valueOf(Event.get(position).getStrAwayTeam()));
        holder.tvTanggal.setText(String.valueOf(Event.get(position).getDateEvent()));
        holder.tvTime.setText(String.valueOf(Event.get(position).getStrTime()));
        holder.btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                String clubName = "Jangan lupa saksikan event " + Event.get(position).getStrHomeTeam() + " VS "
                        + Event.get(position).getStrAwayTeam() + " pada tanggal "
                        + Event.get(position).getDateEvent() + " pukul "
                        + Event.get(position).getStrTime() + " di channel TV olahraga kesukaanmu"
                        + " STAY SAFE STAY AT HOME ";
                intent.putExtra(Intent.EXTRA_TEXT, clubName);
                context.startActivity(Intent.createChooser(intent, "Share Using"));
            }
        });
    }

    @Override
    public int getItemCount() {
        return Event.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTeam1, tvTeam2, tvTanggal, tvTime;
        Button btnShare;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTanggal = itemView.findViewById(R.id.tv_tanggal);
            tvTeam1 = itemView.findViewById(R.id.tv_team1_eventlist);
            tvTeam2 = itemView.findViewById(R.id.tv_team2_eventlist);
            tvTime = itemView.findViewById(R.id.tv_time);
            btnShare = itemView.findViewById(R.id.btn_event_share);
        }
    }
}
