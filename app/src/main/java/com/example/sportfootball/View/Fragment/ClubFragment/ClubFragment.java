package com.example.sportfootball.View.Fragment.ClubFragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sportfootball.Adapter.ClubAdapter;
import com.example.sportfootball.Model.ClubModel.TeamsItem;
import com.example.sportfootball.R;
import com.example.sportfootball.View.ViewModel.FootballViewModel;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ClubFragment extends Fragment {

    private ClubAdapter clubAdapter;
    private RecyclerView rvClub;
    ArrayList<TeamsItem> list = new ArrayList<>();
    private FootballViewModel viewModel;
    private String l = "English Premier League";


    public ClubFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        clubAdapter = new ClubAdapter(getContext());
        clubAdapter.notifyDataSetChanged();

        rvClub = view.findViewById(R.id.fragmentclub_rv);
        rvClub.setLayoutManager(new LinearLayoutManager(getContext()));

        viewModel = new ViewModelProvider(this).get(FootballViewModel.class);
        viewModel.setListClub(l);
        viewModel.getListClub().observe(this, getlistClub);

        rvClub.setAdapter(clubAdapter);

    }

    private Observer<ArrayList<TeamsItem>> getlistClub = new Observer<ArrayList<TeamsItem>>() {
        @Override
        public void onChanged(ArrayList<TeamsItem> clubItems) {
            if ((clubItems != null)) {
                Log.d("ClubFragment", "getListClub Observer : " + clubItems);
                clubAdapter.setClub(clubItems);
            }
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_club, container, false);
    }
}
