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
import java.util.Random;

public class LevelSelect extends AppCompatActivity {
    private String[] enemyLutemonNames = {"Beastly", "Gargoleon", "Deezer", "Solaron", "Mr.Happy", "Ungnown", "Untameable", "Mambabamba"};
    private String[] enemyTrainingLutemonNames = {"Gloomfang", "Frostwraith", "Thornback", "Stormhowler", "Duskwraith", "Emberclaw", "Tidebreaker", "Sunshrike", "Bouldercrest", "Mistshroud", "Fangor", "Driftclaw", "Bramblethorn", "Shadowpounce", "Hentojalka"};
    private int[] enemyLutemonImages = {R.drawable.enemymonster2, R.drawable.enemymonster1, R.drawable.monster3, R.drawable.monster4, R.drawable.monster5, R.drawable.monster6, R.drawable.monster7, R.drawable.monster8, R.drawable.firemonster, R.drawable.grassmonster, R.drawable.watermonster, R.drawable.monster9, R.drawable.monster10};
    private GridLayout buttonsContainer;
    private SaveFileManager saveFileManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_select);
        buttonsContainer = findViewById(R.id.gridLayout);
        Button backBtn = findViewById(R.id.gobackBtn);
        Button trainBtn = findViewById(R.id.TrainBtn);
        backBtn.setOnClickListener(listener);
        trainBtn.setOnClickListener(listener);
        lockButtons();
    }


    private void lockButtons() {
        saveFileManager = SaveFileManager.getInstance();
        int highestLevelAvailable = saveFileManager.getGameFile().getHighestLevelAvailable();
        int count = buttonsContainer.getChildCount();

        for (int i = highestLevelAvailable; i < count; i++) {
            View child = buttonsContainer.getChildAt(i);
            if (child instanceof Button) {
                Button button = (Button) child;
                button.setBackgroundResource(R.color.disabledButton_color);
                button.setEnabled(false);
            }
        }
        for (int j = 0; j < highestLevelAvailable; j++) {
            View child = buttonsContainer.getChildAt(j);
            if (child instanceof Button) {
                Button button = (Button) child;

                button.setBackgroundResource(R.color.normalButton_color);
                button.setEnabled(true);
                button.setOnClickListener(listener);
            }

        }
    }

    public void cancelFunc() {
        super.onBackPressed();
    }


    private View.OnClickListener listener = new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            Enemy enemy;

            if (view.getId() == R.id.level1) {
                Intent intent = new Intent(LevelSelect.this, BattlePage.class);
                enemy = makeNewEnemy(1);
                intent.putExtra("enemy", enemy);
                startActivity(intent);
            }
            if (view.getId() == R.id.level2) {
                Intent intent = new Intent(LevelSelect.this, BattlePage.class);
                enemy = makeNewEnemy(2);
                intent.putExtra("enemy", enemy);
                startActivity(intent);
            }
            if (view.getId() == R.id.level3) {
                Intent intent = new Intent(LevelSelect.this, BattlePage.class);
                enemy = makeNewEnemy(3);
                intent.putExtra("enemy", enemy);
                startActivity(intent);
            }
            if (view.getId() == R.id.level4) {
                Intent intent = new Intent(LevelSelect.this, BattlePage.class);
                enemy = makeNewEnemy(4);
                intent.putExtra("enemy", enemy);
                startActivity(intent);
            }
            if (view.getId() == R.id.level5) {
                Intent intent = new Intent(LevelSelect.this, BattlePage.class);
                enemy = makeNewEnemy(5);
                intent.putExtra("enemy", enemy);
                startActivity(intent);
            }
            if (view.getId() == R.id.level6) {
                Intent intent = new Intent(LevelSelect.this, BattlePage.class);
                enemy = makeNewEnemy(6);
                intent.putExtra("enemy", enemy);
                startActivity(intent);
            }
            if (view.getId() == R.id.level7) {
                Intent intent = new Intent(LevelSelect.this, BattlePage.class);
                enemy = makeNewEnemy(7);
                intent.putExtra("enemy", enemy);
                startActivity(intent);
            }
            if (view.getId() == R.id.level8) {
                Intent intent = new Intent(LevelSelect.this, BattlePage.class);
                enemy = makeNewEnemy(8);
                intent.putExtra("enemy", enemy);
                startActivity(intent);
            }
            if (view.getId() == R.id.gobackBtn) {
                cancelFunc();
            }
            if (view.getId() == R.id.TrainBtn) {
                goTrain();
            }


        }


    };

    public Enemy makeNewEnemy(int level) {
        ArrayList<Lutemon> enemyLuts = new ArrayList<>();
        Enemy enemy = new Enemy("Boss", 2, true, level);
        Lutemon lut = enemy.createEnemyLutemon(enemyLutemonNames[level - 1], level, "Normal", enemyLutemonImages[level - 1]);
        enemyLuts.add(lut);
        enemy.setLutemons(enemyLuts);

        return enemy;
    }

    public void goTrain() {
        Lutemon lutemonInInventory = saveFileManager.getGameFile().getInventory().getLutemon(0);
        Random random = new Random();
        Enemy enemy = new Enemy("training", 1, false);
        int image = enemyLutemonImages[random.nextInt(enemyLutemonImages.length)];
        String name = enemyTrainingLutemonNames[random.nextInt(enemyTrainingLutemonNames.length)];
        ArrayList<Lutemon> enemyLuts = new ArrayList<>();
        Lutemon lut = enemy.createTrainingLutemon(name, lutemonInInventory.getLevel()/2,"Normal",image);

        enemyLuts.add(lut);
        enemy.setLutemons(enemyLuts);

        Intent intent = new Intent(this, BattlePage.class);
        intent.putExtra("enemy", enemy);
        startActivity(intent);
    }
}