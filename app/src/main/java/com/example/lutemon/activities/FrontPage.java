package com.example.lutemon.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.lutemon.R;
import com.example.lutemon.classes.SaveFileManager;

public class FrontPage extends AppCompatActivity {

    private SaveFileManager saveFileManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front_page);
        saveFileManager = SaveFileManager.getInstance();
    }

    public void makeNewFile(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void loadFile(View view){
        saveFileManager.loadFile(this);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}