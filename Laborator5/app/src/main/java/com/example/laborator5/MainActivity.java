package com.example.laborator5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    int NumberToGuess, PlayerNumber, CPUNumber = 0;
    private static final Handler mainHandler = new Handler();
    private volatile boolean stopThread = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onStart(View view) {
        Random random = new Random();
        TextView nrMax = findViewById(R.id.NrMax);
        if (nrMax.getText().length() <= 0) {
            int randomizedNum = random.nextInt(11);
            nrMax.setText("" + randomizedNum);
        }

        stopThread = false;
        Fire fire = new Fire();
        new Thread(fire).start();
    }


    public void onVerifica(View view) {
        comparanrMeu(NumberToGuess);
    }

    public void comparanrMeu(int nrDeAles) {
        TextView nrIntrodus = findViewById(R.id.nrPlayer);
        if (nrIntrodus.getText().length() <= 0) {
            nrIntrodus.setText("0");
        }
        PlayerNumber = Integer.parseInt(nrIntrodus.getText().toString());

        TextView castigator = findViewById(R.id.Winner);
        if (PlayerNumber == nrDeAles) {
            castigator.setText("Human");
            stopThread = true;
        } else {
            castigator.setText("No winner (yet)");
        }
    }

    public void CheckCPUNum(int nrLui, int nrDeAles) {
        TextView castigator = findViewById(R.id.Winner);
        if (nrLui == nrDeAles) {
            castigator.setText("CPU");
            stopThread = true;
        } else {
            castigator.setText("No winner (yet)");
        }
    }

    public int Randomizer() {
        TextView nrMax = findViewById(R.id.NrMax);
        Random random = new Random();
        int ran, max;
        max = Integer.parseInt(nrMax.getText().toString());
        ran = random.nextInt(max);

        return ran;
    }

    class Fire implements Runnable {

        Fire() {
        }

        @Override
        public void run() {
            NumberToGuess = Randomizer();
            //System.out.println("nr de ghicit " + NumberToGuess);
            while (!stopThread) {
                mainHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        CPUNumber = Randomizer();
                        TextView textView = findViewById(R.id.NrOponent);;
                        textView.setText("" + CPUNumber);
                        //System.out.println("nr lui " + CPUNumber);
                        CheckCPUNum(CPUNumber, NumberToGuess);
                    }
                });
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


