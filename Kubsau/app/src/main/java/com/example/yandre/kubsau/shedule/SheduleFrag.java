package com.example.yandre.kubsau.shedule;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yandre.kubsau.R;

public class SheduleFrag extends Fragment {
    public  static TabLayout tabLayout;
    public  static ViewPager viewPager;
//    public  static int int_items = 3;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frag_shedule,null);
        tabLayout=(TabLayout)v.findViewById(R.id.tabs);
        viewPager=(ViewPager)v.findViewById(R.id.viewpager);
        //set an adpater

        class SectionsPagerAdapter extends FragmentPagerAdapter {

            public SectionsPagerAdapter(FragmentManager fm) {
                super(fm);
            }

            @Override
            public Fragment getItem(int position) {

                switch (position){
                    case 0:
                        TodayTab tab1 = new TodayTab();
                        return tab1;
                    case 1:
                        FirstWeekTab tab2 = new FirstWeekTab();
                        return tab2;
                    case 2:
                        SecondWeekTab tab3 = new SecondWeekTab();
                        return tab3;
                    default: return null;
                }
            }

            @Override
            public int getCount() {
                // Show 3 total pages.
                return 3;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                switch (position){
                    case 0:
                        return "Сегодня";
                    case 1:
                        return "1 неделя";
                    case 2:
                        return "2 неделя";
                }
                return null;
            }
        }

        viewPager.setAdapter(new SectionsPagerAdapter( getChildFragmentManager()));

        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                tabLayout.setupWithViewPager(viewPager);
            }
        });
        return v;
    }
}
