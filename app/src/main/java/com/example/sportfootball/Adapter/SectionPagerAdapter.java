package com.example.sportfootball.Adapter;

import com.example.sportfootball.View.Fragment.HomeFragment.FragmentDeskripsi;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class SectionPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragmentlist = new ArrayList<>();
    private List<String> titleList = new ArrayList<>();

    public SectionPagerAdapter(FragmentManager fm) {
        super(fm);
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentlist.get(position);
    }

    @Override
    public int getCount() {
        return fragmentlist.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titleList.get(position);
    }

    public void setFragment (Fragment fragment, String title){
        fragmentlist.add(fragment);
        titleList.add(title);
    }

}
