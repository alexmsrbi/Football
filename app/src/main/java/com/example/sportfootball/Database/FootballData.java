package com.example.sportfootball.Database;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "club_fav")
public class FootballData {

    @NonNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int idTeam;

    @ColumnInfo(name = "strTeam")
    private String strTeam;

    @ColumnInfo(name = "teamBadge")
    private String strTeamBadge;

    @ColumnInfo(name = "country")
    private String strCountry;

    @ColumnInfo(name = "formedYear")
    private String intFormedYear;

    @ColumnInfo(name = "stadiumName")
    private String strStadium;

    @ColumnInfo(name = "stadiumCap")
    private String intStadiumCapacity;

    @ColumnInfo(name = "stadiumLoc")
    private String strStadiumLocation;

    public int getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(int idTeam) {
        this.idTeam = idTeam;
    }

    public String getStrTeam() {
        return strTeam;
    }

    public void setStrTeam(String strTeam) {
        this.strTeam = strTeam;
    }

    public String getStrTeamBadge() { return strTeamBadge; }

    public void setStrTeamBadge(String strTeamBadge) { this.strTeamBadge = strTeamBadge; }

    public String getStrCountry() {
        return strCountry;
    }

    public void setStrCountry(String strCountry) {
        this.strCountry = strCountry;
    }

    public String getIntFormedYear() {
        return intFormedYear;
    }

    public void setIntFormedYear(String intFormedYear) {
        this.intFormedYear = intFormedYear;
    }

    public String getStrStadium() {
        return strStadium;
    }

    public void setStrStadium(String strStadium) {
        this.strStadium = strStadium;
    }

    public String getIntStadiumCapacity() {
        return intStadiumCapacity;
    }

    public void setIntStadiumCapacity(String intStadiumCapacity) { this.intStadiumCapacity = intStadiumCapacity; }

    public String getStrStadiumLocation() {
        return strStadiumLocation;
    }

    public void setStrStadiumLocation(String strStadiumLocation) { this.strStadiumLocation = strStadiumLocation; }
}
