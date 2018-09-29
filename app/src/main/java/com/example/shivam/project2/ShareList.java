package com.example.shivam.project2;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shivam.project2.Listview.List2;
import com.example.shivam.project2.Sql.Database;
import com.example.shivam.project2.Sql.Dbholder2;

import java.util.ArrayList;
import java.util.List;

public class ShareList extends Fragment {
    RecyclerView recyclerView;
    Database db;
    List2 list2;
    Context context;
    List<Dbholder2> dbholder2s;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.sharelist,container,false);
        recyclerView = (RecyclerView) v.findViewById(R.id.recy2);
        dbholder2s = new ArrayList<Dbholder2>();
        db = new Database(getActivity());
        dbholder2s = db.alluser();
        list2 = new List2(dbholder2s,context);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(list2);
        list2.notifyDataSetChanged();



        return v;

    }
}
