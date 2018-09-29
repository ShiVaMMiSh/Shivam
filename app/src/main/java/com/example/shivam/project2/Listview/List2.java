package com.example.shivam.project2.Listview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shivam.project2.R;
import com.example.shivam.project2.Sql.DBholder;
import com.example.shivam.project2.Sql.Dbholder2;

import java.util.List;

public class List2 extends RecyclerView.Adapter<List2.Second> {
    private List<Dbholder2> dbholder2List;
    private Context context;

    public List2(List<Dbholder2> dbholder2List, Context context) {
        this.dbholder2List = dbholder2List;
        this.context = context;
    }

    @NonNull
    @Override
    public Second onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item;
        item = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview,parent,false);
        Second second = new Second(item);

        return second;
    }

    @Override
    public void onBindViewHolder(@NonNull Second holder, int position) {
        Dbholder2 dbholder2 = dbholder2List.get(position);
        holder.name.setText(dbholder2.getName());
        holder.prec.setText(dbholder2.getPercentage());
    }

    @Override
    public int getItemCount() {
        return dbholder2List.size();
    }

    public class Second extends RecyclerView.ViewHolder {
        AppCompatImageView image;
        AppCompatTextView user, name, prec;
        public Second(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.img1);
            user = itemView.findViewById(R.id.tx1);
            name = itemView.findViewById(R.id.nm1);
            prec = itemView.findViewById(R.id.prct1);


        }
    }
}
