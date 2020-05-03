package com.example.sportfootball;

import android.view.View;

import com.example.sportfootball.Database.AppDatabase;
import com.example.sportfootball.Database.FootballData;

import java.util.List;

public interface MainContact {
    interface view extends View.OnClickListener {
    }

    interface presenter {
        void deleteData(AppDatabase database, FootballData footballData);
    }

    interface read extends View.OnClickListener {
        void getData(List<FootballData> list);
    }

    interface delete {
        void successDel();

        void deleteData(FootballData item);
    }
}
