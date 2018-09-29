package com.example.shivam.project2;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatTextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.jar.Attributes;
import java.util.zip.Inflater;

import static com.example.shivam.project2.R.layout.fragment_user;

public class FragmentUser extends Fragment {
    AppCompatTextView name, name2 , perc1, perc2 , User;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_user, container, false);
        User = v.findViewById(R.id.user);
        name = (AppCompatTextView) v.findViewById(R.id.Name);
        name2 = v.findViewById(R.id.name2);
        perc1 = v.findViewById(R.id.pern);
        perc2 = v.findViewById(R.id.pern2);



         Bundle bundle = getArguments();

         if(bundle != null) {
             String Name = bundle.getString("Name");
             String Perc = bundle.getString("Per");
             name2.setText(Name);
             perc2.setText(Perc);
         }

        return v;
    }
}
