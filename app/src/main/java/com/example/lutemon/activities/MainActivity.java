package com.example.lutemon.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.lutemon.R;
import com.example.lutemon.classes.Home;

public class MainActivity extends AppCompatActivity {

    private Home storage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void makeNewLutemonView(View view){
        Intent intent = new Intent(MainActivity.this, AddNewLutemon.class);
        startActivity(intent);
    }

    public void listLutemonsBtn(View view){
        storage = Home.getInstance();
        storage.listLutemons();
    }
}