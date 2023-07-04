package com.example.lutemon.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.lutemon.R;
import com.example.lutemon.classes.Home;
import com.example.lutemon.classes.Lutemon;

public class AddNewLutemon extends AppCompatActivity {

    private RadioGroup lutemonTypesGroup;
    private Home storage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_lutemon);
    }

    public void addLutemon(View view){

        lutemonTypesGroup = findViewById(R.id.lutemonTyperRG);
        int chosenBtnId = lutemonTypesGroup.getCheckedRadioButtonId();
        RadioButton chosenType = findViewById(chosenBtnId);
        String type = chosenType.getText().toString();
        EditText nameField = findViewById(R.id.lutemonNameField);
        String lutemonName = nameField.getText().toString();

        Lutemon lutemonToAdd = new Lutemon(type, lutemonName);

        storage = Home.getInstance();
        storage.createLutemon(lutemonToAdd);

        Intent intent = new Intent(AddNewLutemon.this, MainActivity.class);
        startActivity(intent);
    }
}