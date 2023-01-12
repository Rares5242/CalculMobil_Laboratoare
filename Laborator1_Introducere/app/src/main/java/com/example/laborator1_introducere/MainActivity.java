package com.example.laborator1_introducere;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void Click(View view)
    {
        TextView textViewNume = findViewById(R.id.textView2);
        TextView textViewPrenume = findViewById(R.id.textView3);
        TextView textViewEmail = findViewById(R.id.textView4);

        EditText Nume = findViewById(R.id.inputNume);
        EditText Prenume = findViewById(R.id.inputPrenume);
        EditText Email = findViewById(R.id.inputEmail);

        textViewNume.setText("Nume: "+Nume.getText().toString());
        textViewPrenume.setText("Prenume: "+Prenume.getText().toString());
        textViewEmail.setText("Email: "+Email.getText().toString());
    }
}