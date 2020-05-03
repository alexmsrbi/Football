package com.example.sportfootball.Presenter;

import android.content.Context;
import android.os.AsyncTask;

import com.example.sportfootball.Database.AppDatabase;
import com.example.sportfootball.Database.FootballData;
import com.example.sportfootball.MainContact;

public class PresenterDao implements MainContact.presenter {
    MainContact.view view;
    MainContact.delete viewDel;

    public PresenterDao(MainContact.view view) {
        this.view = view;
    }

    public PresenterDao(MainContact.delete viewDel) {
        this.viewDel = viewDel;
    }

    @Override
    public void deleteData(AppDatabase database, FootballData footballData) {
        new DeleteData(database, footballData).execute();
    }

    private class DeleteData extends AsyncTask<Void, Void, Void> {
        private AppDatabase database;
        private FootballData footballData;
        Context context;

        public DeleteData(AppDatabase database, FootballData footballData) {
            this.database = database;
            this.footballData = footballData;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            database.dao().deleteData(footballData);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            viewDel.successDel();
        }
    }
}
