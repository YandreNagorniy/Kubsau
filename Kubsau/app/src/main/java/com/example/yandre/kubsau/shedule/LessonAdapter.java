package com.example.yandre.kubsau.shedule;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yandre.kubsau.R;
import com.example.yandre.kubsau.lesson.LessonActivity;

import java.util.List;

class LessonAdapter extends RecyclerView.Adapter<LessonAdapter.MyViewHolder> {

    private Context mContext;
    private List<Lesson> lessonTodayList;
    private List<Lesson> lessonList;
    //private ItemClickListener mClickListener;

    //1
    public LessonAdapter(Context mContext, List<Lesson> lessonList) {
        this.mContext = mContext;
        this.lessonList = lessonList;
    }

    //2
    @Override
    public int getItemCount() {
        return lessonList.size();
    }

    //3,5
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_lesson, parent, false);
        return new MyViewHolder(itemView);
    }

    //4 присваиваем значение из листа, 7
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Lesson lesson = lessonList.get(position);
        holder.startTime.setText(lesson.getStartTime());
        holder.endTime.setText(lesson.getEndTime());
        holder.typeOccupation.setText(lesson.getTypeOccupation());
        holder.subjectName.setText(lesson.getSubjectName());
        holder.classRoom.setText(lesson.getClassRoom());
        holder.nameTeacher.setText(lesson.getNameTeacher());

        //с изображением фишка
        //   Glide.with(mContext).load(lesson.getDzImg()).into(holder.dzImg);

//        //есть статья в моей группе, что слуштеля лучше вешать в onCreate(),
//        // связано с перемещением, удалением элементов
//        holder.subject_name.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(mContext, "Нажал н название предмета", Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    //6 объявление и инициализция item-ов
    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView startTime, endTime, typeOccupation, subjectName, classRoom, nameTeacher;
        public ImageView dzImg;

        public MyViewHolder(View itemView) {
            super(itemView);
            startTime = (TextView) itemView.findViewById(R.id.start_time);
            endTime = (TextView) itemView.findViewById(R.id.end_time);
            typeOccupation = (TextView) itemView.findViewById(R.id.type_occupation);
            subjectName = (TextView) itemView.findViewById(R.id.subject_name);
            classRoom = (TextView) itemView.findViewById(R.id.cabinet);
            nameTeacher = (TextView) itemView.findViewById(R.id.name_teacher);
            //      dzImg = (ImageView) itemView.findViewById(R.id.dzImg);

            subjectName.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            if(position!= RecyclerView.NO_POSITION){
                switch (v.getId()){
                    case R.id.subject_name:
                        goToLesson(position);
                }
            }
        }

        private void goToLesson(int position){
            //тут же передавать все необходимые значения для заполнения lesson_activity
            Intent intent = new Intent(mContext, LessonActivity.class);
            mContext.startActivity(intent);
        }

    }

}