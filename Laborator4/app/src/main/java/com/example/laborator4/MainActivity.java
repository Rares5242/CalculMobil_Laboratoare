package com.example.laborator4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> studenti;
    private RecyclerView studentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        studentList = findViewById(R.id.recyclerView);
        studenti = new ArrayList<String>();

        RecyclerAdapter ourListAdapter = new RecyclerAdapter(studenti);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        studentList.setLayoutManager(layoutManager);
        studentList.setItemAnimator(new DefaultItemAnimator());
        studentList.setAdapter(ourListAdapter);


    }




    public void AdaugaStudent(View view)
    {
        EditText Nume = findViewById(R.id.Nume);
        studenti.add(Nume.getText().toString());
        Nume.getText().clear();


    }
}