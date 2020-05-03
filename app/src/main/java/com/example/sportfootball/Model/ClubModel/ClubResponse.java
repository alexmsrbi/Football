package com.example.sportfootball.Model.ClubModel;

import java.util.List;

public class ClubResponse {
    private List<TeamsItem> teams;

    public List<TeamsItem> getTeams() {
        return teams;
    }

    public void setTeams(List<TeamsItem> teams) {
        this.teams = teams;
    }

    @Override
    public String toString() {
        return
                "ClubResponse{" +
                        "teams = '" + teams + '\'' +
                        "}";
    }
}