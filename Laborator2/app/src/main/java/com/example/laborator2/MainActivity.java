package com.example.laborator2;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ActivityResultLauncher<Intent> activityLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {

                    TextView resultDisplay = findViewById(R.id.result);

                    if(result.getResultCode()==RESULT_OK)
                    {
                        Intent data = result.getData();
                        if(data!=null)
                        {
                            int calc_result = data.getIntExtra("calc_res",0);
                            resultDisplay.setText("Rezultat: "+calc_result);
                        }
                    }
                    if(result.getResultCode()==RESULT_CANCELED)
                    {
                        resultDisplay.setText("Error");
                    }

                }
            }


    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Calculeaza(View view)
    {
        EditText firstNum = findViewById(R.id.firstNum);
        EditText secondNum = findViewById(R.id.secondNum);

        if((firstNum.getText().toString().equals(""))||(secondNum.getText().toString().equals("")))
        {
            Toast.makeText(getApplicationContext(),"Completati cele 2 campuri",Toast.LENGTH_LONG).show();
        }
        else
        {
            Intent intent_1 = new Intent(this,MainActivity2.class);

            intent_1.putExtra("first_num",firstNum.getText().toString());
            intent_1.putExtra("second_num",secondNum.getText().toString());

            activityLauncher.launch(intent_1);
        }

    }
}