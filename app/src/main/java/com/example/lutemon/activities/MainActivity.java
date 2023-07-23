package com.example.lutemon.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.lutemon.R;
import com.example.lutemon.classes.SaveFileManager;

public class MainActivity extends AppCompatActivity {

    private SaveFileManager saveFileManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void makeNewLutemonView(View view) {
        Intent intent = new Intent(MainActivity.this, AddNewLutemon.class);
        startActivity(intent);
    }

    public void lutemonsListView(View view) {
        Intent intent = new Intent(MainActivity.this, LutemonListingView.class);
        startActivity(intent);
    }

    public void moveLutemonsView(View view) {
        Intent intent = new Intent(MainActivity.this, MoveLutemons.class);
        startActivity(intent);
    }

    public void levelSelect() {
        Intent intent = new Intent(MainActivity.this, LevelSelect.class);
        startActivity(intent);
    }

    public void saveGameState(View view) {
        saveFileManager = SaveFileManager.getInstance();
        saveFileManager.saveFile(MainActivity.this);
    }

    public void showBattlePopup(View view) {
        saveFileManager = SaveFileManager.getInstance();
        if (saveFileManager.getGameFile().getInventory().getNumberOfLutemons() < 1) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("No Lutemons in inventory!")
                    .setMessage("Added Lutemons have to be moved from storage to inventory in order to battle with them.")
                    .setNegativeButton("Close", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });

            AlertDialog dialog = builder.create();
            dialog.show();
        } else {
            levelSelect();
        }
    }
}