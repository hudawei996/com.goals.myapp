package com.goals.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.goals.lib_annotation.MyAnnotation;

@MyAnnotation("hello world")
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}