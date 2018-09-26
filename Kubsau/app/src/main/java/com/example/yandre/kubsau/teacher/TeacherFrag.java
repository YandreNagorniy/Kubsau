package com.example.yandre.kubsau.teacher;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import com.example.yandre.kubsau.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TeacherFrag extends Fragment {

    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    List<String> expandableListTitle;
    HashMap<String, List<String>> expandableListDetail;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.frag_teacher, container, false);

        //  return inflater.inflate(R.layout.frag_teacher, container, false);


        expandableListView = (ExpandableListView) rootView.findViewById(R.id.expandableTeacherListView);

        //подгружать инфу из рума в классе ExpandableListDataPump
        expandableListDetail = ExpandableListDataPump.getData();
        expandableListTitle = new ArrayList<String>(expandableListDetail.keySet());
        expandableListAdapter = new ExpandableTeachersListAdapter(getContext(), expandableListTitle, expandableListDetail);
        expandableListView.setAdapter(expandableListAdapter);

        expandableListView
                .setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

                    @Override
                    public boolean onChildClick(
                            ExpandableListView parent, View v,
                            int groupPosition, int childPosition,
                            long id) {

                        final String selected = (String) expandableListAdapter.getChild(
                                groupPosition, childPosition);
                        //Creating an Intent Bundle to pass over to the Add Medication Screen.

                        //По нажатию на препода переходм в TeacherActivity туда передаем его  идентификатор( возможно имя)
                        // и заполняем все TeacherActivity данными из Room по этому идентификатору
                        Intent intent = new Intent(getContext(), TeacherActivity.class);
                            Bundle extras = new Bundle();
                            extras.putString("OPERATION","ADD");
                            extras.putInt("ParentPosition", groupPosition);
                            intent.putExtras(extras);
                        startActivity(intent);

                        return true;

                    }
                });

        //опредеись куда девать этого малыша
        return rootView;
    }
}