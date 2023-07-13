package com.example.lutemon.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lutemon.R;
import com.example.lutemon.classes.Enemy;
import com.example.lutemon.classes.GameFile;
import com.example.lutemon.classes.Inventory;
import com.example.lutemon.classes.Lutemon;
import com.example.lutemon.classes.Move;
import com.example.lutemon.classes.SaveFileManager;

import java.util.ArrayList;
import java.util.Random;

public class BattlePage extends AppCompatActivity {

    private boolean buttonsAreVisible = true;
    private boolean enemyIsAlive = true;
    private Enemy enemy;
    Lutemon enemyLutemon;
    Lutemon userLutemon;

    ArrayList<Move> userMoves;

    private TextView userLutemonHp;
    private TextView userLutemonName;
    private ImageView userImage;
    private Inventory inventory;

    private Button move1Btn;
    private Button move2Btn;
    private Button move3Btn;
    private Button move4Btn;
    private TextView enemyLutemonHp;
    private ImageView enemyImage;
    private TextView enemyLutemonName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle_page);


        SaveFileManager saveFileManager = SaveFileManager.getInstance();
        GameFile gameFile = saveFileManager.getGameFile();
        inventory = gameFile.getInventory();
        enemy = new Enemy("Enemy", 1, 1);
        setFields();
        setButtons();

    }

    private void setFields() {
        enemyLutemon = enemy.getLutemons().get(0);
        userLutemon = inventory.getLutemon(0);

        enemyLutemonHp = findViewById(R.id.enemyHpTxt);
        enemyLutemonName = findViewById(R.id.enemyLutemonTxtView);
        userLutemonName = findViewById(R.id.userLutemonTxtView);
        userLutemonHp = findViewById(R.id.userHpTxt);
        userImage = findViewById(R.id.userImage);
        enemyImage = findViewById(R.id.enemyImage);

        enemyImage.setImageResource(R.drawable.enemymonster1);
        userImage.setImageResource(userLutemon.getImage());

        enemyLutemonHp.setText(enemyLutemon.getHealth() + "/" + enemyLutemon.getMaxHealth());
        enemyLutemonName.setText(enemyLutemon.getName());
        userLutemonHp.setText(userLutemon.getHealth() + "/" + userLutemon.getMaxHealth());
        userLutemonName.setText(userLutemon.getName());

    }

    private void setButtons() {
        userMoves = userLutemon.getMoves();
        move1Btn = findViewById(R.id.move1Btn);
        move2Btn = findViewById(R.id.move2Btn);
        move3Btn = findViewById(R.id.move3Btn);
        move4Btn = findViewById(R.id.move4Btn);

        move1Btn.setText(String.valueOf(userMoves.get(0).getName()));
        move2Btn.setText(String.valueOf(userMoves.get(1).getName()));
        move3Btn.setText(String.valueOf(userMoves.get(2).getName()));
        move4Btn.setText(String.valueOf(userMoves.get(3).getName()));
        move1Btn.setOnClickListener(listener);
        move2Btn.setOnClickListener(listener);
        move3Btn.setOnClickListener(listener);
        move4Btn.setOnClickListener(listener);
    }

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int viewId = view.getId();
            if (viewId == R.id.move1Btn) {
                userLutemon.attack(enemyLutemon, 0);
            } else if (viewId == R.id.move2Btn) {
                userLutemon.attack(enemyLutemon, 1);
            } else if (viewId == R.id.move3Btn) {
                userLutemon.attack(enemyLutemon, 2);
            } else if (viewId == R.id.move4Btn) {
                userLutemon.attack(enemyLutemon, 3);
            }
            disableButtons();
            enemyLutemonHp.setText(enemyLutemon.getHealth() + "/" + enemyLutemon.getMaxHealth());

            if (enemyLutemon.getHealth() <= 0) {
                enemyIsAlive = false;
                destroyEnemyLutemon();
            }
            if (enemyIsAlive) {
                Random random = new Random();
                int attackId = random.nextInt(4);
                enemyLutemon.attack(userLutemon, attackId);
                userLutemonHp.setText(userLutemon.getHealth() + "/" + userLutemon.getMaxHealth());
            }
            if(userLutemon.getHealth() <= 0){
                destroyUserLutemon();
            }

        }
    };

    public void destroyEnemyLutemon() {
        enemyImage.setImageResource(0);
        enemyLutemonName.setText("");
        enemyLutemonHp.setText("");
    }

    public void destroyUserLutemon() {
        userImage.setImageResource(0);
        userLutemonName.setText("");
        userLutemonHp.setText("");
    }

    public void disableButtons() {
        buttonsAreVisible = false;
        move1Btn.setVisibility(View.GONE);
        move2Btn.setVisibility(View.GONE);
        move3Btn.setVisibility(View.GONE);
        move4Btn.setVisibility(View.GONE);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                buttonsAreVisible = true;
                move1Btn.setVisibility(View.VISIBLE);
                move2Btn.setVisibility(View.VISIBLE);
                move3Btn.setVisibility(View.VISIBLE);
                move4Btn.setVisibility(View.VISIBLE);
            }
        }, 5000);

    }
}