package com.example.lutemon.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.lutemon.R;
import com.example.lutemon.classes.GameFile;
import com.example.lutemon.classes.Home;
import com.example.lutemon.classes.Lutemon;
import com.example.lutemon.classes.SaveFileManager;
import com.example.lutemon.uniqueLutemonTypes.FireLutemon;
import com.example.lutemon.uniqueLutemonTypes.GrassLutemon;
import com.example.lutemon.uniqueLutemonTypes.WaterLutemon;

public class AddNewLutemon extends AppCompatActivity {

    private RadioGroup lutemonTypesGroup;
    private SaveFileManager saveFileManager;
    private GameFile gameFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_lutemon);
    }

    public void addLutemon(View view) {

        lutemonTypesGroup = findViewById(R.id.lutemonTyperRG);
        int chosenBtnId = lutemonTypesGroup.getCheckedRadioButtonId();
        RadioButton chosenType = findViewById(chosenBtnId);
        String type = chosenType.getText().toString();
        EditText nameField = findViewById(R.id.lutemonNameField);
        String lutemonName = nameField.getText().toString();

        Lutemon lutemonToAdd;
        switch (type) {
            case "Fire":
                lutemonToAdd = new FireLutemon(lutemonName);
                break;
            case "Water":
                lutemonToAdd = new WaterLutemon(lutemonName);
                break;
            case "Grass":
                lutemonToAdd = new GrassLutemon(lutemonName);
                break;
            default:
                lutemonToAdd = new Lutemon("Normal", lutemonName);
                break;
        }

        saveFileManager = SaveFileManager.getInstance();
        gameFile = saveFileManager.getGameFile();
        Home home = gameFile.getHome();
        home.createLutemon(lutemonToAdd);

        home.listLutemons();

        Intent intent = new Intent(AddNewLutemon.this, MainActivity.class);
        startActivity(intent);
    }

    public void cancelBtn(View view) {
        super.onBackPressed();
    }
}