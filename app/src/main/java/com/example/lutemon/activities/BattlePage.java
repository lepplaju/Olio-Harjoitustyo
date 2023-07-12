package com.example.lutemon.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lutemon.R;
import com.example.lutemon.classes.Enemy;
import com.example.lutemon.classes.GameFile;
import com.example.lutemon.classes.Inventory;
import com.example.lutemon.classes.Lutemon;
import com.example.lutemon.classes.SaveFileManager;

public class BattlePage extends AppCompatActivity {

    private Enemy enemy;
    private Inventory inventory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle_page);
        SaveFileManager saveFileManager = SaveFileManager.getInstance();
        GameFile gameFile = saveFileManager.getGameFile();
        inventory = gameFile.getInventory();
        enemy = new Enemy("Enemy",1,1);

        setFields();
    }

    private void setFields(){
        Lutemon enemyLutemon = enemy.getLutemons().get(0);
        Lutemon userLutemon = inventory.getLutemon(0);

        TextView enemyLutemonHp = findViewById(R.id.enemyHpTxt);
        TextView enemyLutemonName = findViewById(R.id.enemyLutemonTxtView);
        TextView userLutemonName = findViewById(R.id.userLutemonTxtView);
        TextView userLutemonHp = findViewById(R.id.userHpTxt);
        ImageView userImage = findViewById(R.id.userImage);
        ImageView enemyImage = findViewById(R.id.enemyImage);

        enemyImage.setImageResource(R.drawable.enemymonster1);
        userImage.setImageResource(R.drawable.firemonster);

        enemyLutemonHp.setText(enemyLutemon.getHealth() + "/" + enemyLutemon.getMaxHealth());
        enemyLutemonName.setText(enemyLutemon.getName());
        userLutemonHp.setText(userLutemon.getHealth()+ "/" + userLutemon.getMaxHealth());
        userLutemonName.setText(userLutemon.getName());



    }
}