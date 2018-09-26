package com.example.yandre.kubsau.notes;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.yandre.kubsau.R;
import com.example.yandre.kubsau.lesson.LessonActivity;

import java.util.ArrayList;
import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.ViewHolder> {

    private List<Note> notesList;
    private Context mContext;

    public NotesAdapter(Context mContext, List<Note> notesList) {
        this.mContext= mContext;
        this.notesList = notesList;
    }

    @NonNull
    @Override
    public NotesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_notes, parent, false);
        return new NotesAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NotesAdapter.ViewHolder holder, int position) {
        holder.noteTime.setText(notesList.get(position).getNoteTime());
        holder.noteDate.setText(notesList.get(position).getNoteDate());
        holder.noteSmalText.setText(notesList.get(position).getNoteSmalTextText());
    }

    @Override
    public int getItemCount() {
        return notesList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView noteTime;
        private TextView noteDate;
        private TextView noteSmalText;
        private LinearLayout noteContainer;

        public ViewHolder(View itemView) {
            super(itemView);
            noteTime = (TextView) itemView.findViewById(R.id.noteTime);
            noteDate = (TextView) itemView.findViewById(R.id.noteDate);
            noteSmalText = (TextView) itemView.findViewById(R.id.noteSmalText);
            noteContainer = (LinearLayout) itemView.findViewById(R.id.noteContainer);
            noteContainer.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION) {
                switch (v.getId()) {
                    case R.id.noteContainer:
                        goToNote(position);
                }
            }
        }

        private void goToNote(int position) {
            Intent intent = new Intent(mContext, NoteCardActivity.class);
            mContext.startActivity(intent);
        }
    }
}
