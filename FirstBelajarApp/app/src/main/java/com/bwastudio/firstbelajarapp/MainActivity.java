package com.bwastudio.firstbelajarapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.time.Instant;

public class MainActivity extends AppCompatActivity {

    ImageView applogo;

    //memberikan event kepada app logo
    private View.OnClickListener mCorkyListener = new View.OnClickListener() {
        public void onClick(View v) {
            // do something when the button is clicked
            Intent abc = new Intent(MainActivity.this, GetStartedAct.class);
            startActivity(abc);
            finish();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //mendapati Id pada xml
        applogo = findViewById(R.id.applogo);

        applogo.setOnClickListener(mCorkyListener);
    }
}
