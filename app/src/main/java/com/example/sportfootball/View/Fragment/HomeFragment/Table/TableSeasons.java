package com.example.sportfootball.View.Fragment.HomeFragment.Table;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sportfootball.Adapter.FootballAdapter;
import com.example.sportfootball.Model.StandingModel.TableItem;
import com.example.sportfootball.R;
import com.example.sportfootball.View.ViewModel.FootballViewModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class TableSeasons extends Fragment {

    private FootballAdapter footballAdapter;
    private RecyclerView rvTableFootball;
    ArrayList<TableItem> list = new ArrayList<>();
    private FootballViewModel footballViewModel;

    public TableSeasons() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        footballAdapter = new FootballAdapter(getActivity());
        footballAdapter.notifyDataSetChanged();

        rvTableFootball = view.findViewById (R.id.rv_table_football);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rvTableFootball.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvTableFootball.addItemDecoration(new DividerItemDecoration(rvTableFootball.getContext(), layoutManager.getOrientation()));

        footballViewModel = new ViewModelProvider(this).get(FootballViewModel.class);
        footballViewModel.setTableFootball();
        footballViewModel.getTableFootball().observe(this, getTablesFootball);

        rvTableFootball.setAdapter(footballAdapter);
    }

    private Observer<ArrayList<TableItem>> getTablesFootball = new Observer<ArrayList<TableItem>>() {
        @Override
        public void onChanged(ArrayList<TableItem> tableItems) {
            if (tableItems != null ){
                footballAdapter.setData(tableItems);
            }
        }
    };


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_table_seasons, container, false);
    }
}
