package com.example.laborator2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class MainActivity2 extends AppCompatActivity {

    int n1,n2,calc_res;
    String num1,num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        num1 = getIntent().getStringExtra("first_num");
        num2 = getIntent().getStringExtra("second_num");

        TextView numere = findViewById(R.id.textView4);
        numere.setText("Numere: "+num1+","+num2);

        n1 = Integer.parseInt(num1);
        n2 = Integer.parseInt(num2);

    }

    public void Adunare(View view)
    {
        calc_res = n1 + n2;
        Intent intent_sum = new Intent(this,MainActivity.class);
        intent_sum.putExtra("calc_res",calc_res);
        setResult(RESULT_OK,intent_sum);
        finish();
    }

    public void Scadere(View view)
    {
        calc_res = n1 - n2;
        Intent intent_sub = new Intent(this,MainActivity.class);
        intent_sub.putExtra("calc_res",calc_res);
        setResult(RESULT_OK,intent_sub);
        finish();
    }
}