package com.example.yandre.kubsau.addchangelesson;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.yandre.kubsau.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddChangeLessonActivity extends AppCompatActivity {
    private List<String> teacherList;
    private ArrayAdapter autoCompileAdapter;

    @BindView(R.id.tvStartTime) TextView startTime;
    @BindView(R.id.tvEndTime) TextView endTime;
    @BindView(R.id.addLessonBtn) Button addLessonBtn;
    @BindView(R.id.addChange_subject_name) AutoCompleteTextView subjectName;
    @BindView(R.id.addChange_teacher_name) AutoCompleteTextView teacherName;
    @BindView(R.id.addChange_classRoom) EditText classRoom;
    @BindView(R.id.rb1) RadioButton rb1;

    public Calendar time = Calendar.getInstance();
    int hour, minute;
    String selectedHour = "";
    String selectedMinute = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_change_lesson);
        ButterKnife.bind(this);

        //заполнять лист из рума
        teacherList = new ArrayList<>();
        teacherList.add("грибок");
        teacherList.add("Мурлин");
        teacherList.add("jde");
        teacherList.add("dkf");
        // addChange_subject_name = (AutoCompleteTextView) findViewById(R.id.addChange_subject_name);
        autoCompileAdapter = new ArrayAdapter<>(AddChangeLessonActivity.this,
                android.R.layout.select_dialog_item, teacherList);
        subjectName.setAdapter(autoCompileAdapter);
        //с первой буквы поиск
        subjectName.setThreshold(0);
    }

    @OnClick({R.id.tvStartTime, R.id.tvEndTime, R.id.addLessonBtn})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.tvStartTime: {
                hour = time.get(Calendar.HOUR_OF_DAY);
                minute = time.get(Calendar.MINUTE);
                TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker timePicker, int hourOfDay, int minuteOfDay) {
                                if (hourOfDay < 10)
                                    selectedHour = "0" + hourOfDay;
                                else selectedHour = String.valueOf(hourOfDay);
                                if (minuteOfDay < 10)
                                    selectedMinute = "0" + minuteOfDay;
                                else selectedMinute = String.valueOf(minuteOfDay);
                                startTime.setText(selectedHour + ":" + selectedMinute);
                            }
                        }, hour, minute, true);
                timePickerDialog.show();
            }
            break;
            case R.id.tvEndTime: {
                hour = time.get(Calendar.HOUR_OF_DAY);
                minute = time.get(Calendar.MINUTE);
                TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker timePicker, int hourOfDay, int minuteOfDay) {
                                if (hourOfDay < 10)
                                    selectedHour = "0" + hourOfDay;
                                else selectedHour = String.valueOf(hourOfDay);
                                if (minuteOfDay < 10)
                                    selectedMinute = "0" + minuteOfDay;
                                else selectedMinute = String.valueOf(minuteOfDay);
                                endTime.setText(selectedHour + ":" + selectedMinute);
                            }
                        }, hour, minute, true);
                timePickerDialog.show();
            }
            break;
            case R.id.addLessonBtn: {
                //если есть пустые поля
                if (subjectName.getText().length() == 0
                        || teacherName.getText().length() == 0
                        || classRoom.getText().length() == 0) {
                    Toast.makeText(this, "Заполните все поля корректно!", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = getIntent();
                    int dayOfWeek = intent.getIntExtra("position", -1) + 1;
                    String typeOcupation;
                    if (rb1.isChecked()) typeOcupation = "Лекция";
                    else typeOcupation = "Практика";

//                    AppDatabase database = InstanceDatabase.getInstance().getDatabase();
//                    ILessonDao lessonDao = database.getLessonDao();//создали Dao объект
//
//                    Lesson lesson = new Lesson(/*dayOfWeek,*/ startTime.getText().toString(),
//                            endTime.getText().toString(), typeOcupation, subjectName.getText().toString(),
//                            classRoom.getText().toString(), teacherName.getText().toString());
//
//                    Single.just(lesson)
//                            .subscribeOn(Schedulers.io())
//                            .observeOn(AndroidSchedulers.mainThread())
//                            .subscribe(lessonDao::insert, Throwable::printStackTrace);

                    /*Single.create(e -> {

                        Lesson lesson = new Lesson(dayOfWeek, startTime.getText().toString(),
                            endTime.getText().toString(), typeOcupation, subjectName.getText().toString(),
                            classRoom.getText().toString(), teacherName.getText().toString());
                        lessonDao.insert(lesson);
                    })

                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(result -> {

                        }, throwable -> {
                            throwable.printStackTrace();
                        });*/

                    //finish();
                }
            }
        }
    }

}