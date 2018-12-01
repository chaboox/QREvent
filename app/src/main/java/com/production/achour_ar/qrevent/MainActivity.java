package com.production.achour_ar.qrevent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.production.achour_ar.qrevent.camera.BarcodeCaptureActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //test2
        //test
        //test3
        Intent i = new Intent(this, BarcodeCaptureActivity.class);
        startActivity(i);
    }
}
