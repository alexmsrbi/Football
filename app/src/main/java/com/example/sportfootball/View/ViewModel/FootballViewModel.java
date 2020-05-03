package com.example.sportfootball.View.ViewModel;

import android.util.Log;

import com.example.sportfootball.Model.ClubModel.ClubResponse;
import com.example.sportfootball.Model.MatchModel.EventResponse;
import com.example.sportfootball.Model.MatchModel.EventsItem;
import com.example.sportfootball.Model.StandingModel.Seasons2017Response;
import com.example.sportfootball.Model.StandingModel.TableFootballResponse;
import com.example.sportfootball.Model.StandingModel.TableItem;
import com.example.sportfootball.Model.ClubModel.TeamsItem;
import com.example.sportfootball.Service.FootballClient;

import java.util.ArrayList;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FootballViewModel extends ViewModel {

    private FootballClient footballClient;

    private MutableLiveData<ArrayList<TableItem>> listTable = new MutableLiveData<>();
    private MutableLiveData<ArrayList<EventsItem>> listEvent = new MutableLiveData<>();
    private MutableLiveData<ArrayList<TeamsItem>> listClub = new MutableLiveData<>();
    private String L;

    public void setTableFootball() {
        if (this.footballClient == null){
            footballClient=new FootballClient();
        }
        footballClient.getApiFootball().getTableFootball().enqueue(new Callback<TableFootballResponse>() {
            @Override
            public void onResponse(Call<TableFootballResponse> call, Response<TableFootballResponse> response) {
                TableFootballResponse responseFootball = response.body();
                if (responseFootball != null && responseFootball.getTable() != null){
                    ArrayList<TableItem> tableFootballitem = responseFootball.getTable();
                    listTable.postValue(tableFootballitem);
                }
            }

            @Override
            public void onFailure(Call<TableFootballResponse> call, Throwable t) {

            }
        });

    }
    public LiveData<ArrayList<TableItem>> getTableFootball(){
        return listTable;
    }

    public void setTableSeasons(){
        if (this.footballClient == null){
            footballClient=new FootballClient();
        }
        footballClient.getApiFootball().getTableSeasons().enqueue(new Callback<Seasons2017Response>() {
            @Override
            public void onResponse(Call<Seasons2017Response> call, Response<Seasons2017Response> response) {
                Seasons2017Response seasons2017Response = response.body();
                if (seasons2017Response != null && seasons2017Response.getTable() != null) {
                    ArrayList<TableItem> tableseasons = (ArrayList<TableItem>) seasons2017Response.getTable();
                    listTable.postValue(tableseasons);
                }
            }

            @Override
            public void onFailure(Call<Seasons2017Response> call, Throwable t) {

            }
        });
    }

    public LiveData<ArrayList<TableItem>> getTableSeasons() {
        return listTable;
    }

    public void setFootballClient() {
        if (this.footballClient == null) {
            footballClient = new FootballClient();
        }
        footballClient.getApiFootball().getEvent().enqueue(new Callback<EventResponse>() {
            @Override
            public void onResponse(Call<EventResponse> call, Response<EventResponse> response) {
                EventResponse eventResponse = response.body();
                if (eventResponse != null && eventResponse.getEvents()!=null) {
                    ArrayList<EventsItem> eventsItems = (ArrayList<EventsItem>) eventResponse.getEvents();
                    listEvent.postValue(eventsItems);
                }
            }

            @Override
            public void onFailure(Call<EventResponse> call, Throwable t) {

            }
        });
    }
    public LiveData<ArrayList<EventsItem>> getEvent(){
        return listEvent;
    }

    public void setListClub(String L) {
        if (this.footballClient == null) {
            footballClient = new FootballClient();
        }
        footballClient.getApiFootball().getClub(L).enqueue(new Callback<ClubResponse>() {
            @Override
            public void onResponse(Call<ClubResponse> call, Response<ClubResponse> response) {
                ClubResponse clubResponse = response.body();
                if (clubResponse != null && clubResponse.getTeams() != null) {
                    ArrayList<TeamsItem> listclub = (ArrayList<TeamsItem>) clubResponse.getTeams();
                    listClub.postValue(listclub);
                }
            }

            @Override
            public void onFailure(Call<ClubResponse> call, Throwable t) {
                Log.d("FootbalViewModel","Retrofit Get"+t.getMessage());
            }
        });
    }

    public LiveData<ArrayList<TeamsItem>> getListClub() {
        return listClub;
    }

}
