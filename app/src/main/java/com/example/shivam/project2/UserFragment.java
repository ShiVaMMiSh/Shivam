package com.example.shivam.project2;

import android.app.AlertDialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatTextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.shivam.project2.Sql.Database;

public class UserFragment extends Fragment {
    Database db;
    AppCompatTextView name , per , user;
    AppCompatEditText namE;
    AppCompatEditText percentagE;
    AppCompatButton Submit, Viewall;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.user_fragment, container, false);

        namE =(AppCompatEditText) v.findViewById(R.id.name1);
        percentagE = (AppCompatEditText) v.findViewById(R.id.percentage);
        name = (AppCompatTextView)v.findViewById(R.id.nameview);
        per = (AppCompatTextView)v.findViewById(R.id.perview);
        user = (AppCompatTextView)v.findViewById(R.id.view);
        db = new Database(getActivity());

        Submit = v.findViewById(R.id.Submit);
        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name = namE.getText().toString();
                String Percentage = percentagE.getText().toString();
                if(Name.isEmpty() || Percentage.isEmpty()){
                    Toast.makeText(getActivity(),"please fill the form ", Toast.LENGTH_LONG).show();
                }else {
                    addAll(Name, Percentage);
                    namE.setText("");
                    percentagE.setText("");
                }

            }
        });
//        Viewall = v.findViewById(R.id.vieall);
//        Viewall.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                String name = namE.getText().toString();
//                String per = percentagE.getText().toString();
//                fetchdata();
//                Bundle manager = new Bundle();
//                manager.putString("Name",name );
//                manager.putString("percentage", per);
//                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                FragmentUser user = new FragmentUser();
//                user.setArguments(manager);
//                fragmentTransaction.replace(R.id.fragment_container,user).commit();

//            }

 //       });
        Viewall = v.findViewById(R.id.vieall);
        Viewall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fetchdata();
                ShareList shareList = new ShareList();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.fragment_container,shareList,getTag()).addToBackStack(null).commit();

            }
        });




        return v;

    }

    private void addAll(String name, String percentage) {

        boolean isInsertdata = db.adddata(name, percentage);

        if (isInsertdata == true) {
            Toast.makeText(getActivity(), "inserted data", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getActivity(), "data is not inserted", Toast.LENGTH_LONG).show();
        }


    }
//    public void show() {
//        Viewall.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Cursor res = db.getInfo();
//                if (res.getCount() == 0) {
//                    showmessege("data", "nothing data");
//                    return;
//                }
//                StringBuffer buffer = new StringBuffer();
//                while (res.moveToNext()) {
//                    buffer.append("ID : " + res.getString(0) + "\n");
//                    buffer.append("Name : " + res.getShort(1) + "\n");
//                    buffer.append("Percentage : " + res.getString(2) + "\n\n");
//                }
//                showmessege("data", buffer.toString());
//            }
//        });
//    }
    private  void fetchdata(){
        db.alluser();

    }
    public void showmessege(String title, String messege){
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(messege);

    }


}



