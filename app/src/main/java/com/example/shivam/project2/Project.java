package com.example.shivam.project2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.shivam.project2.Sql.Database;


public class Project extends Fragment {
    AppCompatEditText projectName, reference, amountfinal, amountproposed, qa;
    AppCompatButton submit;
    Database dbhandler;
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.project, container, false);
        projectName = (AppCompatEditText) view.findViewById(R.id.projectname);
        reference = (AppCompatEditText) view.findViewById(R.id.ref);
        amountproposed = (AppCompatEditText) view.findViewById(R.id.proposed);
        amountfinal = (AppCompatEditText) view.findViewById(R.id.Final);
        qa = (AppCompatEditText) view.findViewById(R.id.qa);
        dbhandler = new Database(getActivity());
        submit = (AppCompatButton) view.findViewById(R.id.button);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String projectname = projectName.getText().toString();
                String Reference = reference.getText().toString();
                String amountpr = amountproposed.getText().toString();
                String amountFinal = amountfinal.getText().toString();
                String quatation = qa.getText().toString();

                if (projectname.isEmpty() || Reference.isEmpty() || amountpr.isEmpty() || amountFinal.isEmpty() || quatation.isEmpty()) {
                    Toast.makeText(getActivity(), "plese filled the form", Toast.LENGTH_LONG).show();
                }else {
                    addAll(projectname, Reference, amountpr, amountFinal, quatation);
                    projectName.setText("");
                    reference.setText("");
                    amountproposed.setText("");
                    amountfinal.setText("");
                    qa.setText("");
                    Recycler userFragment = new Recycler();
                    FragmentManager manager = getFragmentManager();
                    manager.beginTransaction().replace(R.id.fragment_container,userFragment,getTag()).addToBackStack(null).commit();

                }
            }
        });
        return view;
    }

    private void addAll(String projectname, String Reference, String amountpr, String amountFinal, String quatation) {

        boolean isInsertdata = dbhandler.insertData(projectname, Reference, amountpr, amountFinal, quatation);

        if (isInsertdata == true) {
            Toast.makeText(getActivity(), "inserted data", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getActivity(), "data is not inserted", Toast.LENGTH_LONG).show();
        }


    }
}




