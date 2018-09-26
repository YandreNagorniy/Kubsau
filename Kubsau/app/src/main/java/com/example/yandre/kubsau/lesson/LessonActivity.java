package com.example.yandre.kubsau.lesson;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.example.yandre.kubsau.R;
import com.example.yandre.kubsau.addchangelesson.AddChangeLessonActivity;
import com.example.yandre.kubsau.map.MapActivity;
import com.example.yandre.kubsau.teacher.TeacherActivity;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LessonActivity extends AppCompatActivity {

    @BindView(R.id.commentTv) TextView commentTv;
    @BindView(R.id.commentEt) EditText commentEt;
    //@BindView(R.id.clickableShowAtMap) RelativeLayout clickableShowAtMap;
   // @BindView(R.id.goToTacher) RelativeLayout goToTeacherRv;
    @BindView(R.id.toolbar) Toolbar mToolbar;
    @BindView(R.id.viewSwitcher) ViewSwitcher viewSwitcher;
    @BindView(R.id.commentAddBtn) Button commentAddBtn;
    @BindView(R.id.commentCancelBtn) Button commentCancelBtn;
    @BindView(R.id.collapsing_toolbar) CollapsingToolbarLayout mCollapsingToolbar;
    @BindView(R.id.toolbarImage) ImageView im;
    //@BindView(R.id.changeLesson) ImageView changeLesson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);
        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);
        //  getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //здесь я буду передавать название предмета которое получу по интенту из LessonAdaptera
        mCollapsingToolbar.setTitle("08:00-09:30 ");
        Picasso.with(this).load(R.drawable.blackboard).into(im);
    }

    @OnClick({R.id.clickableShowAtMap, R.id.viewSwitcher, R.id.commentAddBtn, R.id.commentCancelBtn,
            R.id.goToTacher, R.id.changeLesson})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.changeLesson: {
                Intent intent = new Intent(this, AddChangeLessonActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.clickableShowAtMap: {
                Intent intent = new Intent(this, MapActivity.class);
                startActivity(intent);
                break;
            }
            //Отправлять интент с данными об определенном преподавателе
            case R.id.goToTacher: {
                Intent intent = new Intent(this, TeacherActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.viewSwitcher: {
                commentEt.setText(commentTv.getText().toString());
                viewSwitcher.showNext();
                commentAddBtn.setVisibility(View.VISIBLE);
                commentCancelBtn.setVisibility(View.VISIBLE);
                commentAddBtn.setClickable(true);
                commentCancelBtn.setClickable(true);
                break;
            }
            case R.id.commentAddBtn: {
                commentTv.setText(commentEt.getText().toString());
                viewSwitcher.showNext();
                commentAddBtn.setClickable(false);
                commentCancelBtn.setClickable(false);
                commentAddBtn.setVisibility(View.INVISIBLE);
                commentCancelBtn.setVisibility(View.INVISIBLE);
                break;
            }
            case R.id.commentCancelBtn: {
                viewSwitcher.showNext();
                commentAddBtn.setClickable(false);
                commentCancelBtn.setClickable(false);
                commentAddBtn.setVisibility(View.INVISIBLE);
                commentCancelBtn.setVisibility(View.INVISIBLE);
                break;
            }
        }
    }
}
