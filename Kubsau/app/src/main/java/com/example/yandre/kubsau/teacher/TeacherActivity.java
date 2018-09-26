package com.example.yandre.kubsau.teacher;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.yandre.kubsau.R;
import com.example.yandre.kubsau.chat.ChatActivity;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TeacherActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private CollapsingToolbarLayout mCollapsingToolbar;
    private ImageView im;
    @BindView(R.id.writeTeacher) RelativeLayout writeTeacher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);
        ButterKnife.bind(this);

        writeTeacher = (RelativeLayout)findViewById(R.id.writeTeacher);

        mToolbar = (Toolbar) findViewById(R.id.toolbarTeacher);
        setSupportActionBar(mToolbar);
        //  getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mCollapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbarTeacher);
        // в закрытом состоянии только фамилия
        mCollapsingToolbar.setTitle("КубГАУ");
        im = (ImageView) findViewById(R.id.toolbarTeacherImage);
        Picasso.with(this).load(R.drawable.blackboard).into(im);

    }

    @OnClick(R.id.writeTeacher)
    void onClick(View view) {
        Intent intent = new Intent(this, ChatActivity.class);
        startActivity(intent);
    }
}
