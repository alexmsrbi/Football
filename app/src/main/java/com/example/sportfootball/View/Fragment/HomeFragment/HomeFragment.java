package com.example.sportfootball.View.Fragment.HomeFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.sportfootball.Adapter.SectionPagerAdapter;
import com.example.sportfootball.R;
import com.example.sportfootball.View.Fragment.HomeFragment.Table.MainTable;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    View myFragment;
    ViewPager viewPager;
    TabLayout tabLayout;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        myFragment =  inflater.inflate(R.layout.fragment_home, container, false);

        viewPager = myFragment.findViewById(R.id.view_pager);
        tabLayout = myFragment.findViewById(R.id.tab_Layout);
        return myFragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setUpViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void setUpViewPager(ViewPager viewPager) {
        SectionPagerAdapter adapter = new SectionPagerAdapter(getChildFragmentManager());

       adapter.setFragment(new FragmentDeskripsi(), "Deskripsi");
       adapter.setFragment(new FragmentMatch(), "Match");
       adapter.setFragment(new MainTable(), "Standings");

       viewPager.setAdapter(adapter);

    }
}
