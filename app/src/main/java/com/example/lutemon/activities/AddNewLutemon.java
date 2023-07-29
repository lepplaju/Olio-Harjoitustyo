package com.example.lutemon.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
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

    EditText nameField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_lutemon);
        nameField = findViewById(R.id.lutemonNameField);

        // Max input length for lutemon name is set to 12
        nameField.setFilters(new InputFilter[]{new InputFilter.LengthFilter(12)});
    }

    public void addLutemon(View view) {

        lutemonTypesGroup = findViewById(R.id.lutemonTyperRG);
        int chosenBtnId = lutemonTypesGroup.getCheckedRadioButtonId();
        RadioButton chosenType = findViewById(chosenBtnId);
        String lutemonName = nameField.getText().toString();
        if (lutemonName.length() > 0 && chosenBtnId > 0) {
            String type = chosenType.getText().toString();

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
                    lutemonToAdd = new Lutemon("Normal", lutemonName, 5);
                    break;
            }

            saveFileManager = SaveFileManager.getInstance();
            gameFile = saveFileManager.getGameFile();
            Home home = gameFile.getHome();
            home.createLutemon(lutemonToAdd);

            home.listLutemons();

            Intent intent = new Intent(AddNewLutemon.this, MainActivity.class);
            startActivity(intent);

        } else { // We go here if there is missing information when adding a new Lutemon
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Missing Lutemon information!")
                    .setMessage("Make sure to fill all fields")
                    .setNegativeButton("Close", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            AlertDialog dialog = builder.create();
            dialog.show();
        }

    }

    public void cancelBtn(View view) {
        super.onBackPressed();
    }
}