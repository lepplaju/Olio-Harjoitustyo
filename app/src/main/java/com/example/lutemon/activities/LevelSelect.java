package com.example.lutemon.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;

import com.example.lutemon.R;
import com.example.lutemon.classes.Enemy;
import com.example.lutemon.classes.Lutemon;
import com.example.lutemon.classes.SaveFileManager;

import java.util.ArrayList;

public class LevelSelect extends AppCompatActivity {

    private GridLayout buttonsContainer;
    private SaveFileManager saveFileManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_select);
        buttonsContainer = findViewById(R.id.gridLayout);
        //Button backBtn = findViewById(R.id.exitBtn);
        lockButtons();
    }

    public void goTrain() {
        Intent intent = new Intent(this, BattlePage.class);
        startActivity(intent);
    }

    private void lockButtons() {
        saveFileManager = SaveFileManager.getInstance();
        int levelsCompleted = saveFileManager.getGameFile().getHighestLevelAvailable();
        int count = buttonsContainer.getChildCount();

        for (int j = 0; j < levelsCompleted; j++) {
            View child = buttonsContainer.getChildAt(j);
            if (child instanceof Button) {
                Button button = (Button) child;
                button.setOnClickListener(listener);
                button.setBackgroundResource(R.color.normalButton_color);
                button.setEnabled(true);
            }

        }


        for (int i = levelsCompleted; i < count; i++) {
            View child = buttonsContainer.getChildAt(i);
            if (child instanceof Button) {
                Button button = (Button) child;
                button.setBackgroundResource(R.color.disabledButton_color);
                button.setEnabled(false);
            }
        }
    }

    public void cancelFunc() {
        super.onBackPressed();
    }

    public void selectLevel(int levelNum) {
    }

    private View.OnClickListener listener = new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            Enemy enemy;
            ArrayList<Lutemon> enemyLuts = new ArrayList<>();
            Intent intent = new Intent(LevelSelect.this, BattlePage.class);
            if (view.getId() == R.id.level1) {
                enemy = new Enemy("Boss", 2, true);
                Lutemon lut = enemy.createEnemyLutemon("Normal", 1, "Normal", R.drawable.enemymonster2);
                enemyLuts.add(lut);
                enemy.setLutemons(enemyLuts);
                intent.putExtra("enemy", enemy);
            }
            if (view.getId() == R.id.level2) {
            }
            if (view.getId() == R.id.level3) {
            }
            if (view.getId() == R.id.level4) {
            }
            if (view.getId() == R.id.level5) {
            }
            if (view.getId() == R.id.level6) {
            }
            if (view.getId() == R.id.level7) {
            }
            if (view.getId() == R.id.level8) {
            }
            if (view.getId() == R.id.level9) {
            }
            if (view.getId() == R.id.level10) {
            }
            if (view.getId() == R.id.level11) {
            }
            if (view.getId() == R.id.level12) {
            }
            if (view.getId() == R.id.level13) {
            }
            if (view.getId() == R.id.level14) {
            }
            if (view.getId() == R.id.level15) {
            }
            if (view.getId() == R.id.level16) {
            }
            if (view.getId() == R.id.gobackBtn) {
                cancelFunc();
            }
            if (view.getId() == R.id.TrainBtn) {
                goTrain();
            }
            startActivity(intent);

        }


    };
}