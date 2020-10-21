package com.example.abhishek.speechtotext;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    TextView txvResult;
    TextView encodedText;
    TextView resText;
    Boolean flag;
    String finalResult;
    MediaPlayer mediaPlayer;
    public void play(View view){
        mediaPlayer.start();
    }
    TextToSpeech ttsobject;
    int result;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setContentView(R.layout.activity_main);
        txvResult = (TextView) findViewById(R.id.txvResult);
        encodedText = (TextView) findViewById(R.id.encodedText);
        resText = (TextView) findViewById(R.id.resText);
        mediaPlayer = MediaPlayer.create(this, R.raw.cat);

        ttsobject = new TextToSpeech(MainActivity.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status==TextToSpeech.SUCCESS){
                   result =  ttsobject.setLanguage(Locale.ENGLISH);

                }
                else{
                    Toast.makeText(getApplicationContext(), "Feature not supported in your device", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void doSomething(View view){
        switch(view.getId()){
            case R.id.imageButton2:
            if(result==TextToSpeech.LANG_NOT_SUPPORTED || result == TextToSpeech.LANG_MISSING_DATA){
                Toast.makeText(getApplicationContext(), "Feature not supported in your device", Toast.LENGTH_SHORT).show();
            }
            else{
                    ttsobject.speak("CATT",TextToSpeech.QUEUE_FLUSH,null);
            }
            break;

        }
    }

    public void getSpeechInput(View view) {

        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, 10);
        } else {
            Toast.makeText(this, "Your Device Don't Support Speech Input", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case 10:
                if (resultCode == RESULT_OK && data != null) {
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    txvResult.setText(result.get(0).toUpperCase());
                    String encodedVoice = encodedText.getText().toString().toUpperCase();
                    String recordedVoice = txvResult.getText().toString();
                    flag = encodedVoice.equals(recordedVoice);
                    if(flag){

                        finalResult = "Good Job!";
                        resText.setText(finalResult);
                        resText.setTextColor(Color.parseColor("green"));

                    }
                    else {

                        finalResult = "Oops, Try Again!";
                        resText.setText(finalResult);
                        resText.setTextColor(Color.parseColor("red"));

                    }




                }
                break;
        }
    }

}
