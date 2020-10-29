package com.example.abhishek.learningdisability;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class M1Page1 extends AppCompatActivity {

    public void goToPhoneme1(View view){
        Intent intent = new Intent(getApplicationContext(),M1P1Test.class);
        startActivity(intent);
    }

    public void go(View view){
        Intent intent = new Intent(getApplicationContext(),M1P2Test.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m1_page1);
    }
}
