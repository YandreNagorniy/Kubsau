package com.example.yandre.kubsau.shedule;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yandre.kubsau.R;

import java.util.ArrayList;
import java.util.List;

public class SecondWeekTab extends Fragment {

    private RecyclerView day_RV;
    private DayAdapter dayAdapter;
    private RecyclerView.LayoutManager dayLayMAn;
    private List<Lesson> lessonList;
    //   private List<Day> dayList;
    private List<String> dayList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.frag_secondweek, container, false);

        lessonList = new ArrayList<>();
        lessonList = getLessonsDataset(lessonList);

        dayList = new ArrayList<>();
        dayList = getDayDataset(dayList);

        day_RV = (RecyclerView) rootView.findViewById(R.id.day_RV);
        dayLayMAn = new LinearLayoutManager(getContext());
        day_RV.setLayoutManager(dayLayMAn);
        // dayAdapter = new DayAdapter(getContext(), dayList, lessonList);
        dayAdapter = new DayAdapter(getContext(), dayList, lessonList);
        day_RV.setAdapter(dayAdapter);
        return rootView;
    }

    public List<Lesson> getLessonsDataset(List<Lesson> mDataSet) {
        for (int i = 0; i < 7; i++) {
            mDataSet.add(new Lesson(/*1,*/"09:30", "11:15", "лекция", "Разработка кросплатформенных приложений", "1эк", "Мурлин А.Г."));
        }
        return mDataSet;
    }

    public List<String> getDayDataset(List<String> mDataSet) {
        for (int i = 0; i < 6; i++) {
            mDataSet.add("Пятница");
        }
        return mDataSet;
    }
}