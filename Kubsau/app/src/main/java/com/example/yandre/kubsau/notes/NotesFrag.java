package com.example.yandre.kubsau.notes;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.yandre.kubsau.R;
import java.util.ArrayList;
import java.util.List;


public class NotesFrag extends Fragment {

    private RecyclerView notesRV;
    private RecyclerView.LayoutManager notesLayMan;
    private NotesAdapter notesAdapter;
    private List<Note> notesList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.frag_notes, container, false);

        notesList= new ArrayList<>();
        notesList = getDataSet();

        notesRV = (RecyclerView) rootView.findViewById(R.id.notesRV);
        notesLayMan = new LinearLayoutManager(getActivity());
        notesRV.setLayoutManager(notesLayMan);
        notesAdapter = new NotesAdapter(getContext(), notesList);
        notesRV.setAdapter(notesAdapter);
        return rootView;
    }

    public List<Note> getDataSet() {
        List<Note> noteList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            noteList.add(new Note("12:00","6 сентября", "Сдать учебники в библиотеку!"));
            noteList.add(new Note("09:00","7 сентября", "Купить много шоколоадок!"));
            noteList.add(new Note("08:00","8 сентября", "Найти работу!"));

        }
        return noteList;
    }
}
