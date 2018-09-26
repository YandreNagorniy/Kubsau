package com.example.yandre.kubsau.shedule;

public class Day {

    private String dayWeek;
    private String number;
    private String month;
    private String date;
    public Day() {
    }

    public Day(String dayWeek, String number) {

        this.dayWeek = dayWeek;
        this.number = number;
    }

    public String getDayWeek() {
        return dayWeek;
    }

    public String setDayWeek() {
        return this.dayWeek = dayWeek;
    }

    public String getNumber() {
        return number;
    }

    public String setNumber() {
        return this.number = number;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}