package com.example.lutemon.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
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

public class BattlePage extends AppCompatActivity {

    private Enemy enemy;
    Lutemon enemyLutemon;
    Lutemon userLutemon;

    ArrayList<Move> userMoves;

    private Inventory inventory;

    private Button move1Btn;
    private Button move2Btn;
    private Button move3Btn;
    private Button move4Btn;
    private TextView enemyLutemonHp;

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
        TextView enemyLutemonName = findViewById(R.id.enemyLutemonTxtView);
        TextView userLutemonName = findViewById(R.id.userLutemonTxtView);
        TextView userLutemonHp = findViewById(R.id.userHpTxt);
        ImageView userImage = findViewById(R.id.userImage);
        ImageView enemyImage = findViewById(R.id.enemyImage);

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
                userLutemon.attack(enemyLutemon,0);
            } else if (viewId == R.id.move2Btn) {
                userLutemon.attack(enemyLutemon, 1);
            } else if (viewId == R.id.move3Btn) {
                userLutemon.attack(enemyLutemon,2);
            } else if (viewId == R.id.move4Btn) {
                userLutemon.attack(enemyLutemon,3);
            }
            enemyLutemonHp.setText(enemyLutemon.getHealth() + "/" + enemyLutemon.getMaxHealth());
        }
    };
}