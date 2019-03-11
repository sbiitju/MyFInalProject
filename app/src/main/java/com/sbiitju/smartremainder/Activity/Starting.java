package com.sbiitju.smartremainder.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

import com.sbiitju.smartremainder.R;

public class Starting extends AppCompatActivity {
    ProgressBar progressBar;
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting);
        progressBar=findViewById(R.id.progress);
        getSupportActionBar().hide();
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                dowork();
                newact();
            }
        });

        thread.start();
    }
    public void dowork(){
        for(i=0;i<=100;i=i+25) {
            try {
                Thread.sleep(500);
                progressBar.setProgress(i);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void newact(){
        Intent intent=new Intent(this,LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
