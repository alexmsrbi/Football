package com.example.sportfootball.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {FootballData.class,Akun.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase {
    public abstract FootballDao dao();

    private static AppDatabase appDatabase;

    public static AppDatabase iniDb(Context context) {
        if (appDatabase == null)
            appDatabase = Room.databaseBuilder(context, AppDatabase.class,
                    "clubDb").fallbackToDestructiveMigration().allowMainThreadQueries().build();
        return appDatabase;
    }


}
