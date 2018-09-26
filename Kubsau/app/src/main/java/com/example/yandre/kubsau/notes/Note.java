package com.example.yandre.kubsau.notes;

import android.arch.persistence.room.Entity;

@Entity()
public class Note {
    private String noteTime;
    private String noteDate;
    private String noteSmalText;

    Note(String noteTime,String noteDate, String noteSmalText){
        this.noteTime= noteTime;
        this.noteDate= noteDate;
        this.noteSmalText=noteSmalText;
    }

    public String getNoteSmalTextText() {
        return noteSmalText;
    }
    public void setNoteSmalText(String noteText) {
        this.noteSmalText = noteText;
    }

    public String getNoteDate() {
        return noteDate;
    }

    public void setNoteDate(String noteDate) {
        this.noteDate = noteDate;
    }

    public String getNoteTime() {
        return noteTime;
    }

    public void setNoteTime(String noteTime) {
        this.noteTime = noteTime;
    }
}
