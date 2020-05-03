package com.example.sportfootball.Service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FootballClient {

    private Retrofit retrofit;
    public ApiFootball getApiFootball() {
        String BASE_URL = "https://www.thesportsdb.com/";
        if (retrofit == null){
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return retrofit.create(ApiFootball.class);
    }
}

