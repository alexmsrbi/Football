package com.example.sportfootball.View.Fragment.HomeFragment.Table;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.sportfootball.R;

import static com.example.sportfootball.R.*;
import static com.example.sportfootball.R.array.*;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainTable extends Fragment {

    Fragment selectedFragment = new TableSeasons();

    public MainTable() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Spinner spinner = view.findViewById(id.spinner_seasons);
        assert savedInstanceState != null;
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(),
                android.R.layout.simple_list_item_1, getResources().getStringArray(seasons));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    selectedFragment = new Seasons2017();
                    loadFragment();

                }
                else if (position == 1) {
                    selectedFragment = new TableSeasons();
                    loadFragment();
                }
            }

            private void loadFragment() {
                if (selectedFragment != null) {
                    getFragmentManager()
                            .beginTransaction()
                            .replace(R.id.container_tabel, selectedFragment)
                            .commit();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(layout.fragment_main_table, container, false);
    }
}
