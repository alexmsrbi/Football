package com.example.sportfootball.Service;

import com.example.sportfootball.Model.ClubModel.ClubResponse;
import com.example.sportfootball.Model.MatchModel.EventResponse;
import com.example.sportfootball.Model.StandingModel.Seasons2017Response;
import com.example.sportfootball.Model.StandingModel.TableFootballResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiFootball {
    @GET("api/v1/json/1/lookuptable.php?l=4328&s=1819")
    Call<TableFootballResponse> getTableFootball();

    @GET("api/v1/json/1/lookuptable.php?l=4328&s=1213")
    Call<Seasons2017Response> getTableSeasons();

    @GET ("api/v1/json/1/eventsnextleague.php?id=4328")
    Call<EventResponse> getEvent();

    @GET("api/v1/json/1/search_all_teams.php")
    Call<ClubResponse> getClub(@Query("l") String l);
}
