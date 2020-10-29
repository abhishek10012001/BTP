package com.example.abhishek.learningdisability;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public void goToModule1(View view){
        Intent intent = new Intent(getApplicationContext(),Module1Activity.class);
        startActivity(intent);
    }

    public void goToModule2(View view){
        Intent intent = new Intent(getApplicationContext(),Module2Activity.class);
        startActivity(intent);
    }

    public void goToModule3(View view){
        Intent intent = new Intent(getApplicationContext(),Module3Activity.class);
        startActivity(intent);
    }

    public void goToModule4(View view){
        Intent intent = new Intent(getApplicationContext(),Module4Activity.class);
        startActivity(intent);
    }

    public void goToModule5(View view){
        Intent intent = new Intent(getApplicationContext(),Module5Activity.class);
        startActivity(intent);
    }

    public void goToModule6(View view){
        Intent intent = new Intent(getApplicationContext(),Module6Activity.class);
        startActivity(intent);
    }

    public void goToModule7(View view){
        Intent intent = new Intent(getApplicationContext(),Module7Activity.class);
        startActivity(intent);
    }

    public void goToModule8(View view){
        Intent intent = new Intent(getApplicationContext(),Module8Activity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
