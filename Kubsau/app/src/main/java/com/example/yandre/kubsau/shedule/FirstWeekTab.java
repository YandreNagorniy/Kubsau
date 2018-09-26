package com.example.yandre.kubsau.shedule;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yandre.kubsau.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class FirstWeekTab extends Fragment {
    private RecyclerView day_RV;
    private DayAdapter dayAdapter;
    private RecyclerView.LayoutManager dayLayMan;
    private List<Lesson> lessonList;
    //private List<Day> dayList;
    private List<String> dayList;
    public Calendar calendar;
    int dayOfWeek, number, month;
    String date;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.frag_firstweek, container, false);

        calendar = Calendar.getInstance();
        //Опред. тек. дня нед.(-1)
        if (calendar.get(Calendar.DAY_OF_WEEK) > 1) {
            dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        } else dayOfWeek = 7;
        String date = String.valueOf(calendar.get(Calendar.DATE));
        calendar.add(Calendar.DATE, -dayOfWeek + 1);
        date = String.valueOf(calendar.get(Calendar.DATE));
        lessonList = new ArrayList<>();
        //заполнение LessonList из бд
          getLessonsDataset(lessonList);

        dayList = new ArrayList<>();
        dayList = getDayDataset(dayList);

        day_RV = (RecyclerView) rootView.findViewById(R.id.day_RV);
        dayLayMan = new LinearLayoutManager(getContext());
        day_RV.setLayoutManager(dayLayMan);
        dayAdapter = new DayAdapter(getContext(), dayList, lessonList);
        day_RV.setAdapter(dayAdapter);
        return rootView;
    }

    //не будет пуст листДэй (значения возможно будут браться из календаря)
    public List<String> getDayDataset(List<String> mDataSet) {
        for (int i = 0; i < 7; i++) {
            SimpleDateFormat formatter = new SimpleDateFormat("EEEE dd.MM");
            date = formatter.format(calendar.getTime());
            mDataSet.add(date);
            calendar.add(Calendar.DATE, 1);
        }
        return mDataSet;
    }

    //в дальнейшем данные брать из БД Firebase
    public List<Lesson> getLessonsDataset(List<Lesson> mDataSet) {
        String[] time = {"08:00", "09:30", "09:45", "11:15", "11:30", "13:00", "13:50", "15:20", "15:35", "17:05", "17:20", "18:50","18:50","18:50","18:50"};
        String[] room = {"203 эк", "310 эк", "1 эк", "122 зр", "323 гл", "310 эк", "12 гд"};
        String[] teacher = {"Мурлин А.Г.","Вострокнутов А.Е.","Ефанова Н.В.","Грубич Т.Ю.","Иванова Е.А.","Орлянская Н.П.","Мурлин А.Г."};
        String[] lesson = {"Разработка крсплатформенных приложений","Безопасность жизнидеятельности", "Инструментальные средства информационных систем",
                "Админитрирование информационных систем", "Разработка кросплатформенных приложений", "Основы теории управления",
                "Защита информации","Корпоративные информационные системы"};

        int k=0;
        for (int i = 0; i < 7; i++) {

            mDataSet.add(new Lesson(/*1,*/time[k], time[k + 1], "лекция", lesson[i], room[i], teacher[i]));
            k++;
            k++;
        }
        return mDataSet;
    }

//
//    @SuppressLint("CheckResult")
//    public void getLessonsDataset() {
//
//        AppDatabase database = InstanceDatabase.getInstance().getDatabase();
//        ILessonDao lessonDao = database.getLessonDao();//создали Dao объект
//        /*Single.create(e -> {
//            AppDatabase database = InstanceDatabase.getInstance().getDatabase();
//            ILessonDao lessonDao = database.getLessonDao();//создали Dao объект
//            lessonList = (List<Lesson>) lessonDao.getAll();
//        })*/
//        lessonDao.getAll()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(result -> {
//                    lessonList = result;
//                }, Throwable::printStackTrace);
//    }
}
