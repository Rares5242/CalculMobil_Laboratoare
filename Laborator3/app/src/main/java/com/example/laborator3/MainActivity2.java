package com.example.laborator3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView textView = findViewById(R.id.textView);

        int Img_id = getIntent().getIntExtra("ImageID",0);

            switch (Img_id) {
                case 0:
                    textView.setText("bali.jpg, an image of Bali.");
                    break;
                case 1:
                    textView.setText("brain.jpg, the shadow of a head, with the image of a brain, and the optical system highlighted.");
                    break;
                case 2:
                    textView.setText("charlie.jpg, a picture of a dog.");
                    break;
            }

    }

    public void Back(View view)
    {
        finish();
    }
}