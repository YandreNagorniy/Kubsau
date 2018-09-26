package com.example.yandre.kubsau.shedule;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yandre.kubsau.R;
import com.example.yandre.kubsau.addchangelesson.AddChangeLessonActivity;

import java.util.List;

class DayAdapter extends RecyclerView.Adapter<DayAdapter.MyViewHolder> {

    private Context mContext;
    private List<String> dayList;
    private List<Lesson> lessonList;

    // лист с парами на 1н день
    private List<Lesson> lessonTodayList;

    public DayAdapter(Context mContext, List<String> dayList, List<Lesson> lessonList) {
        this.mContext = mContext;
        this.dayList = dayList;
        this.lessonList = lessonList;
    }

    @Override
    public int getItemCount() {
        return dayList.size();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_day, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        //  String day = dayList.get(position);00000000000000000000000000
        holder.dateDay.setText(dayList.get(position));
//        holder.number.setText(day.getNumber());

//        //убрать этот костыль для отсутствия пар
//        if (lessonList.size() > 0) {
//            lessonTodayList = lessonList.subList(1, 5);
            LessonAdapter lessonAdapter = new LessonAdapter(mContext, lessonList);
            holder.lessons_RV.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
            holder.lessons_RV.setAdapter(lessonAdapter);
        //}
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView dateDay;
        public RecyclerView lessons_RV;
        public ImageView addNewLesson;

        public MyViewHolder(View itemView) {
            super(itemView);
            dateDay = (TextView) itemView.findViewById(R.id.dateDay);
            addNewLesson = (ImageView) itemView.findViewById(R.id.addImg);
//            number = (TextView) itemView.findViewById(R.id.number);

            this.lessons_RV = (RecyclerView) itemView.findViewById(R.id.lesson_RV);
            this.lessons_RV.setLayoutManager(new LinearLayoutManager(this.lessons_RV.getContext(), LinearLayoutManager.VERTICAL, false));
            lessons_RV.setNestedScrollingEnabled(true);

            // растояние между элементами
           // lessons_RV.addItemDecoration(new SpacesItemDecoration(1));
            lessons_RV.setAdapter(null);
            addNewLesson.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION) {
                switch (view.getId()) {
                    case R.id.addImg:
                        goToAddLesson(position);
                }
            }
        }
    }

    private void goToAddLesson(int position) {
        Intent intent = new Intent(mContext, AddChangeLessonActivity.class);
        intent.putExtra("position", position);
        mContext.startActivity(intent);
    }
}