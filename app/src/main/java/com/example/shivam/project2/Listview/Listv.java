package com.example.shivam.project2.Listview;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.shivam.project2.Detail;
import com.example.shivam.project2.R;
import com.example.shivam.project2.Sql.DBholder;
import java.util.List;

public  class Listv extends RecyclerView.Adapter<Listv.MyViewHolder> {
    private List<DBholder> adapterList;

    private Context context;

    public Listv(Context context,List<DBholder> adapterList ) {
        this.adapterList = adapterList;
        this.context = context;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item;
        item = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_project, parent, false);
         final MyViewHolder vh = new MyViewHolder(item);
        vh.Text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Click" + String.valueOf(vh.getAdapterPosition()),Toast.LENGTH_LONG);
            }
        });
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final DBholder adapter = adapterList.get(position);

        holder.Text.setText(adapter.getProjectName());
        holder.Text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, Detail.class);
                intent.putExtra("key",  adapter);
                context.startActivity(intent);
                Toast.makeText(context,"Click"  +adapter.getProjectName(),Toast.LENGTH_LONG).show();

            }
        });

    }

    @Override
    public int getItemCount() {
        return adapterList.size();
    }

    public static   class  MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        AppCompatTextView Text;
        ImageView imageView;
        private ItemClickListener itemClickListener;



        public MyViewHolder( View view ) {
            super(view);
            Text = view.findViewById(R.id.text);
            imageView = view.findViewById(R.id.imageView);
            view.setOnClickListener(this);


        }
        public  void setItemClickListener(ItemClickListener itemClickListener){
            this.itemClickListener = itemClickListener;
        }

         @Override
        public void onClick(View v) {
            if(itemClickListener != null){
                itemClickListener.onClick(v,getAdapterPosition());


            }

        }
    }
    }

