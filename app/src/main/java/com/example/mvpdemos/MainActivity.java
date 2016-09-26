package com.example.mvpdemos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.mvpdemos.dagger.DaggerActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onNormalMVP(View v) {

    }

    public void onRxJavaMVP(View v) {

    }

    public void onDaggerMVP(View v) {
        startActivity(new Intent(MainActivity.this, DaggerActivity.class));
    }

    public void onBindingMVP(View v) {

    }
}
