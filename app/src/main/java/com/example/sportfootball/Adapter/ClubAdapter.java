package com.example.sportfootball.Adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.sportfootball.Database.AppDatabase;
import com.example.sportfootball.Database.FootballData;
import com.example.sportfootball.Model.ClubModel.TeamsItem;
import com.example.sportfootball.R;
import com.example.sportfootball.View.Fragment.ClubFragment.ClubDetail;

import java.util.ArrayList;

public class ClubAdapter extends RecyclerView.Adapter<ClubAdapter.ViewHolder> {

    // private static String BASE_IMAGE_URL = "https:\\/\\/www.thesportsdb.com\\/images\\/media\\/team\\/logo\\/";
    public Context context;
    AppDatabase appDatabase;
    private ArrayList<TeamsItem> Club = new ArrayList<>();

    public ClubAdapter(Context context) {
        this.context = context;
    }

    public void setClub(ArrayList<TeamsItem> Club) {
        this.Club.clear();
        this.Club.addAll(Club);
        this.Club = Club;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.club_list, parent, false);
        return new ClubAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.bind(position);
        Glide.with(context).load(Club.get(position).getStrTeamBadge())
                .into(holder.ivIcon);
        holder.tvNama.setText(String.valueOf(Club.get(position).getStrTeam()));

        holder.cvClub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, Club.get(position).getStrTeam(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, ClubDetail.class);
                intent.putExtra("img_urlLogo", Club.get(position).getStrTeamBadge());
                intent.putExtra("detail_namaClub", Club.get(position).getStrTeam());
                intent.putExtra("detail_namaStadium", Club.get(position).getStrStadium());
                intent.putExtra("detail_deskripsi", Club.get(position).getStrDescriptionEN());
                intent.putExtra("img_urlstadium", Club.get(position).getStrStadiumThumb());
                intent.putExtra("detail_formyear", Club.get(position).getIntFormedYear());
                intent.putExtra("detail_kapasitas", Club.get(position).getIntStadiumCapacity());
                intent.putExtra("detail_descstadium", Club.get(position).getStrStadiumDescription());
                intent.putExtra("detail_Jersey", Club.get(position).getStrTeamJersey());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return Club.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNama;
        ImageView ivIcon;
        Button btnFav;
        CardView cvClub;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.tv_nama);
            ivIcon = itemView.findViewById(R.id.iv_img);
            btnFav = itemView.findViewById(R.id.btn_fav);
            cvClub = itemView.findViewById(R.id.cv_event);
            appDatabase = AppDatabase.iniDb(context);
        }

        public void bind(final int position) {
            btnFav.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    FootballData footballData = new FootballData();
//                    footballData.setIdTeam(Club.get(position).getIdTeam()); Ga kepake, pake ID database.
                    footballData.setStrTeamBadge(Club.get(position).getStrTeamBadge());
                    footballData.setStrTeam(Club.get(position).getStrTeam());
                    footballData.setStrCountry(Club.get(position).getStrCountry());
                    footballData.setIntFormedYear(Club.get(position).getIntFormedYear());
                    footballData.setStrStadium(Club.get(position).getStrStadium());
                    footballData.setStrStadiumLocation(Club.get(position).getStrStadiumLocation());
                    footballData.setIntStadiumCapacity(Club.get(position).getIntStadiumCapacity());

                    appDatabase.dao().insertData(footballData);
                    Toast.makeText(context, "SAVE TO FAVORITE", Toast.LENGTH_SHORT).show();
                    Log.d("ClubAdapter", "Save to favorite Success");
                }
            });
        }
    }


}
