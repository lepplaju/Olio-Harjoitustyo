package com.example.lutemon.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.lutemon.R;
import com.example.lutemon.classes.SaveFileManager;

import java.io.FileNotFoundException;
import java.io.IOException;

public class FrontPage extends AppCompatActivity {

    private SaveFileManager saveFileManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front_page);
        saveFileManager = SaveFileManager.getInstance();
    }

    public void makeNewFile() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


    public void loadFile(View view) {
        try {
            saveFileManager.loadFile(this);
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        } catch (IOException e) {
            showLoadErrorPopup();
        }


    }

    public void showNewFilePopup(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Are you sure you want to continue?")
                .setMessage("New save file will override any existing files")
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setPositiveButton("Yes, make new file", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    makeNewFile();
                    }
                });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void showLoadErrorPopup() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Unable to load file")
                .setMessage("could not load a saved file")
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}