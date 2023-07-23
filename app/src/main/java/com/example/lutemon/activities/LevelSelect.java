package com.example.lutemon.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;

import com.example.lutemon.R;
import com.example.lutemon.classes.SaveFileManager;

public class LevelSelect extends AppCompatActivity {

    private GridLayout buttonsContainer;
    private SaveFileManager saveFileManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_select);
        buttonsContainer = findViewById(R.id.gridLayout);
        lockButtons();
    }

    public void goTrain(View view) {
        Intent intent = new Intent(this, BattlePage.class);
        startActivity(intent);
    }

    private void lockButtons() {
        saveFileManager = SaveFileManager.getInstance();
        int levelsCompleted = saveFileManager.getGameFile().getHighestLevelAvailable();
        int count = buttonsContainer.getChildCount();
        for (int i = levelsCompleted; i < count; i++) {
            View child = buttonsContainer.getChildAt(i);
            if (child instanceof Button) {
                Button button = (Button) child;
                button.setBackgroundResource(R.color.disabledButton_color);
                button.setEnabled(false);
            }
        }
    }

    public void cancelBtn(View view) {
        super.onBackPressed();
    }
}