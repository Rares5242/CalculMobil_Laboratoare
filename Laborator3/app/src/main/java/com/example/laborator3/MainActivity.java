package com.example.laborator3;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MainActivity extends AppCompatActivity {


    int id=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button prev = findViewById(R.id.button);
        Button next = findViewById(R.id.button3);
        Button details = findViewById(R.id.button2);
        FrameLayout frameLayout = findViewById(R.id.frameLayout);
        replaceFragment(new poza1());

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                --id;
                if(id < 0)
                {
                    id = 2;
                }
                    switch (id) {
                        case 0:
                            replaceFragment(new poza1());
                            break;
                        case 1:
                            replaceFragment(new poza2());
                            break;
                        case 2:
                            replaceFragment(new poza3());
                            break;
                    }

            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ++id;
                if(id > 2)
                {
                    id = 0;
                }
                    switch (id) {
                        case 0:
                            replaceFragment(new poza1());
                            break;
                        case 1:
                            replaceFragment(new poza2());
                            break;
                        case 2:
                            replaceFragment(new poza3());
                            break;
                    }
            }
        });
    }

    public void Description(View view)
    {
        Intent intent = new Intent(this,MainActivity2.class);
        intent.putExtra("ImageID",id);
        startActivity(intent);
    }

    private void replaceFragment(Fragment fragmentParam)
    {
        FragmentManager fragManager = getSupportFragmentManager();
        FragmentTransaction fragTransaction = fragManager.beginTransaction();
        fragTransaction.replace(R.id.frameLayout,fragmentParam);
        fragTransaction.commit();
    }

}