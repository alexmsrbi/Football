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

    @Insert
    long daftarAkun(Akun akun);

    @Query("Select * from account where username =:user and password=:pass")
    Akun[] getDataLogin(String user, String pass);

    @Query("Select * from account where username =:user")
    Akun[] checkUser(String user);
    

    @Query("SELECT * FROM club_fav")
    List<FootballData> getData();

    @Delete
    void deleteData(FootballData item);
}
