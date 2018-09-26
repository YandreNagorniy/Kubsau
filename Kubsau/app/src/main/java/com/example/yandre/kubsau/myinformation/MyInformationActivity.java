package com.example.yandre.kubsau.myinformation;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.yandre.kubsau.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MyInformationActivity extends AppCompatActivity {
    @BindView(R.id.myName) EditText myName;
    @BindView(R.id.mySurename) EditText mySurename;
    @BindView(R.id.myPatronymic) EditText myPatronymic;
    @BindView(R.id.myGroup) EditText myGroup;
    @BindView(R.id.myClassroom) EditText myClassroom;
    @BindView(R.id.myPosition) EditText myPosition;
    @BindView(R.id.btnSaveMyInf) Button btnSaveMyInf;
    @BindView(R.id.spinner) Spinner spinner;
    @BindView(R.id.textInpLayPosition) TextInputLayout textInpLayPosition;
    @BindView(R.id.textInpLayClRoom) TextInputLayout textInpLayClRoom;
    @BindView(R.id.textInpLayGroup) TextInputLayout textInpLayGroup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_information);
        ButterKnife.bind(this);

        int userType = spinner.getSelectedItemPosition();
        if(userType>0)
        {
            textInpLayClRoom.setVisibility(View.VISIBLE);
            textInpLayPosition.setVisibility(View.VISIBLE);
            textInpLayGroup.setVisibility(View.GONE);
        }
        else {
            textInpLayClRoom.setVisibility(View.GONE);
            textInpLayPosition.setVisibility(View.GONE);
            textInpLayGroup.setVisibility(View.VISIBLE);
        }

    }

    @OnClick({R.id.btnSaveMyInf, R.id.btnCloseMyInf})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnSaveMyInf: {
                
            }

        }
    }
}
