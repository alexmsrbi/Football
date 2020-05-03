package com.example.sportfootball.Adapter;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.view.ActionProvider;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Delete;

import com.bumptech.glide.Glide;
import com.example.sportfootball.Database.AppDatabase;
import com.example.sportfootball.Database.FootballData;
import com.example.sportfootball.MainContact;
import com.example.sportfootball.R;

import java.util.List;

public class FavAdapter extends RecyclerView.Adapter<FavAdapter.Holder> {
    private Context context;
    private List<FootballData> list;
    private MainContact.delete viewDel;
    private AppDatabase appDatabase;
    private FootballData footballData;

    public FavAdapter(Context context, List<FootballData> list, MainContact.delete viewDel) {
        this.context = context;
        this.list = list;
        this.viewDel = viewDel;
    }

    @NonNull
    @Override
    public FavAdapter.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.favorite_list, parent, false);
        Holder holder = new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull FavAdapter.Holder holder, final int position) {
        holder.bind(position);
        Glide.with(context).load(list.get(position).getStrTeamBadge())  //PANGGIL GAMBARNYA WOIII
                .into(holder.iv_img_club);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        //DEKLARASI VARIABELNYA DULU
        private ImageView iv_img_club;
        private TextView tv_name, tv_country, tv_formedYear, tv_stadiumName, tv_stadiumLoc, tv_stadiumCap;
        private Button btnView, btnDel;

        public Holder(@NonNull View itemView) {
            super(itemView);
            //BUAT NGATUR DATA KE TAMPILAN (?)
            iv_img_club = itemView.findViewById(R.id.fav_club_img);
            tv_name = itemView.findViewById(R.id.fav_club_name);
            tv_country = itemView.findViewById(R.id.fav_club_country);
            tv_formedYear = itemView.findViewById(R.id.fav_club_formed_year);
            tv_stadiumName = itemView.findViewById(R.id.fav_club_stadium);
            tv_stadiumLoc = itemView.findViewById(R.id.fav_club_stadium_loc);
            tv_stadiumCap = itemView.findViewById(R.id.fav_club_stadium_cap);
            btnView = itemView.findViewById(R.id.btn_view);
            btnDel = itemView.findViewById(R.id.btn_remove);
        }


        public void bind(int position) {
            //MENAMPILKAN DATA
            final FootballData footballData = list.get(position);
            //iv_img_club.setImageURI(footballData.getStrTeamBadge());
            tv_name.setText(footballData.getStrTeam());
            tv_country.setText(footballData.getStrCountry());
            tv_formedYear.setText(footballData.getIntFormedYear());
            tv_stadiumName.setText(footballData.getStrStadium());
            tv_stadiumLoc.setText(footballData.getStrStadiumLocation());
            tv_stadiumCap.setText(footballData.getIntStadiumCapacity());
            btnDel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    viewDel.deleteData(footballData);
                }
            });
        }
    }
}
