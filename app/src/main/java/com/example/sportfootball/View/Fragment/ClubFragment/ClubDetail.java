package com.example.sportfootball.View.Fragment.ClubFragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.sportfootball.R;

import androidx.appcompat.app.AppCompatActivity;

public class ClubDetail extends AppCompatActivity {


    TextView tvNamaStadium, tvNamaClub, tvDeskripsiClub, tvFormYear, tvKapasitas, tvDescStadium;
    ImageView ivLogo,ivImageStadium, ivJersey;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club_detail);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ivLogo=findViewById(R.id.iv_detaillogo);
        tvNamaClub=findViewById(R.id.tv_detailnama);
        tvNamaStadium=findViewById(R.id.tv_detailnamastadium);
        tvDeskripsiClub=findViewById(R.id.tv_detaildesc);
        ivImageStadium=findViewById(R.id.iv_detailimagestadium);
        tvFormYear = findViewById(R.id.tv_detailform);
        tvKapasitas=findViewById(R.id.tv_detailjmlstadium);
        tvDescStadium=findViewById(R.id.tv_detaildescstadium);
        ivJersey=findViewById(R.id.iv_detailjersey);

        getIncomingIntent();
    }

    private void getIncomingIntent() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String getLogo = bundle.getString("img_urlLogo");
            String getNamaClub = bundle.getString("detail_namaClub");
            String getNamaStadium = bundle.getString("detail_namaStadium");
            String getDeskripsi = bundle.getString("detail_deskripsi");
            String getStadium=bundle.getString("img_urlstadium");
            String getFormYear = bundle.getString("detail_formyear");
            String getKapasitas = bundle.getString("detail_kapasitas");
            String getDescStadium=bundle.getString("detail_descstadium");
            String getJersey =bundle.getString("detail_Jersey");

            tvNamaClub.setText(getNamaClub);
            tvDeskripsiClub.setText(getDeskripsi);
            tvNamaStadium.setText(getNamaStadium);
            tvFormYear.setText(getFormYear);
            tvKapasitas.setText(getKapasitas);
            tvDescStadium.setText(getDescStadium);

            Glide.with(this)
                    .load(getLogo)
                    .into(ivLogo);

            Glide.with(this)
                    .load(getStadium)
                    .into(ivImageStadium);

            Glide.with(this)
                    .load(getJersey)
                    .into(ivJersey);



        } else {
            Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
        }
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
