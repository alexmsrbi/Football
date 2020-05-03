package com.example.sportfootball.View.Fragment.HomeFragment;

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

import com.example.sportfootball.Adapter.EventAdapter;
import com.example.sportfootball.Model.MatchModel.EventsItem;
import com.example.sportfootball.R;
import com.example.sportfootball.View.ViewModel.FootballViewModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentMatch extends Fragment {

    private EventAdapter eventAdapter;
    private RecyclerView rvEvent;
    ArrayList<EventsItem> list = new ArrayList<>();
    private FootballViewModel viewModel;

    public FragmentMatch() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        eventAdapter = new EventAdapter(getContext());
        eventAdapter.notifyDataSetChanged();

        rvEvent = view.findViewById(R.id.rv_event);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rvEvent.setLayoutManager(new LinearLayoutManager(getContext()));
        rvEvent.addItemDecoration(new DividerItemDecoration(rvEvent.getContext(), layoutManager.getOrientation()));


        viewModel = new ViewModelProvider(this).get(FootballViewModel.class);
        viewModel.setFootballClient();
        viewModel.getEvent().observe(this, getEvents);

        rvEvent.setAdapter(eventAdapter);
    }

    private Observer<ArrayList<EventsItem>> getEvents = new Observer<ArrayList<EventsItem>>() {
        @Override
        public void onChanged(ArrayList<EventsItem> eventsItems) {
            if ((eventsItems != null)){
                eventAdapter.setEvent(eventsItems);
            }
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_match, container, false);
    }
}
