package com.production.achour_ar.qrevent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.production.achour_ar.qrevent.camera.BarcodeCaptureActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText usernameET;
    private EditText passwordET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        Intent i = new Intent(this, DetailsInputActivity.class);
        startActivity(i);
    }

    private void initView() {
        usernameET = findViewById(R.id.user);
        passwordET = findViewById(R.id.pass);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.login:
                login();
                break;
        }
    }

    private void login() {
        //TODO LOGIN (ADAM'S PART)

    }
}
