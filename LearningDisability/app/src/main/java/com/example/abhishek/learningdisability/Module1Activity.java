package com.example.abhishek.learningdisability;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Module1Activity extends AppCompatActivity {

    public void goToPage1(View view){
        Intent intent = new Intent(getApplicationContext(),M1Page1.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module1);
    }
}
