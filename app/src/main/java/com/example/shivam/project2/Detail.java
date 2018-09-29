package com.example.shivam.project2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shivam.project2.Sql.DBholder;

public class Detail extends AppCompatActivity {

    AppCompatImageView image;
    AppCompatTextView prn,re,amp,amf,qt;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.project_list);
        image =(AppCompatImageView) findViewById(R.id.imagev);
        prn = (AppCompatTextView) findViewById(R.id.pr);
        re = (AppCompatTextView) findViewById(R.id.rf);
        amp = (AppCompatTextView) findViewById(R.id.ap);
        amf = (AppCompatTextView) findViewById(R.id.af);
        qt = (AppCompatTextView) findViewById(R.id.qta);

        DBholder data = new DBholder();
        data = (DBholder) getIntent().getSerializableExtra("key");
        prn.setText(data.getProjectName());
        re.setText(data.getReference());
        amp.setText(data.getAmountProposed());
        amf.setText(data.getAmountFianl());
        qt.setText(data.getQuatation());


    }
}
