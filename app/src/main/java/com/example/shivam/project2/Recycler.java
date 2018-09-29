package com.example.shivam.project2;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shivam.project2.Listview.Listv;
import com.example.shivam.project2.Sql.DBholder;
import com.example.shivam.project2.Sql.Database;

import java.util.ArrayList;
import java.util.List;

public class Recycler extends Fragment  {

    RecyclerView recyclerView;
    Database dbhandler;
    Listv listv;
    Context context;
    List<DBholder>dBholders;

FloatingActionButton button;
AppCompatTextView textView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         View v = inflater.inflate(R.layout.user_listview, container, false);

          recyclerView = (RecyclerView) v.findViewById(R.id.list);
        textView = (AppCompatTextView)v.findViewById(R.id.textView);
        button = (FloatingActionButton)v.findViewById(R.id.click);


        button.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  Project project = new Project();
                  FragmentManager fragmentUser = getFragmentManager();
                  fragmentUser.beginTransaction().replace(R.id.fragment_container, project , getTag()).addToBackStack(null)
                          .commit();
              }
          });

        dBholders = new ArrayList<DBholder>();

        dbhandler = new Database(getActivity());
        dBholders = dbhandler.getAllinfo();
        listv = new Listv(getActivity(),dBholders);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
//        listv.setItemClickListener((ItemClickListener) this);
        recyclerView.setAdapter(listv);
        listv.notifyDataSetChanged();
         return v;
    }

}