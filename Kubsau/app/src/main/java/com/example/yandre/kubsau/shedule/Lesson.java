package com.example.yandre.kubsau.shedule;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity()
public class Lesson {

    @PrimaryKey//(autoGenerate = true)
    private long id; //position(понедельник)
    private String startTime;
    private String endTime;
    private String typeOccupation;
    private String subjectName;
    private String classRoom;
    private String nameTeacher;

    // private int dzImg;
    public Lesson() {}

    public Lesson(/*int id,*/ String start_time, String end_time, String type_occupation,
                              String subject_name, String classRoom, String name_teacher) {
        this.startTime = start_time;
        this.endTime = end_time;
        this.typeOccupation = type_occupation;
        this.subjectName = subject_name;
        this.classRoom = classRoom;
        this.nameTeacher = name_teacher;
        /*this.id = id;*/
        //  this.dzImg = dzImg;
    }
    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getTypeOccupation() {
        return typeOccupation;
    }

    public void setTypeOccupation(String typeOccupation) {
        this.typeOccupation = typeOccupation;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(String classRoom) {
        this.classRoom = classRoom;
    }

    public String getNameTeacher() {
        return nameTeacher;
    }

    public void setNameTeacher(String nameTeacher) {
        this.nameTeacher = nameTeacher;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}