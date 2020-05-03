package com.example.sportfootball.Database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface FootballDao {
    @Insert
    long insertData(FootballData footballData);

    @Query("SELECT * FROM club_fav")
    List<FootballData> getData();

    @Delete
    void deleteData(FootballData item);
}
