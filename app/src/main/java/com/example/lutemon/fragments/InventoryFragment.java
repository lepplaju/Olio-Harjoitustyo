package com.example.lutemon.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.lutemon.R;
import com.example.lutemon.classes.GameFile;
import com.example.lutemon.classes.Home;
import com.example.lutemon.classes.Inventory;
import com.example.lutemon.classes.Lutemon;
import com.example.lutemon.classes.SaveFileManager;

import java.util.ArrayList;


public class InventoryFragment extends Fragment {

    private RadioGroup lutemonRadioGroupInventory;
    private SaveFileManager saveFileManager;
    private GameFile gameFile;

    public InventoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_inventory, container, false);

        lutemonRadioGroupInventory = view.findViewById(R.id.lutemonRadioGroupInvent);

        makeRadioButtons();

        Button moveBtn = view.findViewById(R.id.moveButtonInvent);
        moveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                moveLutemonToHomeFunc();
            }
        });
        return view;
    }

    public void moveLutemonToHomeFunc(){
        saveFileManager = SaveFileManager.getInstance();
        gameFile = saveFileManager.getGameFile();
        Inventory inventory = gameFile.getInventory();
        ArrayList<Lutemon> lutemonsInInventory = inventory.getLutemons();
        int id = lutemonRadioGroupInventory.getCheckedRadioButtonId();
        if (id != -1) {
            View rb = lutemonRadioGroupInventory.findViewById(id);
            int position = lutemonRadioGroupInventory.indexOfChild(rb);
            Lutemon lutemon = lutemonsInInventory.get(position);
            inventory.moveLutemonToHome(lutemon);

            makeRadioButtons();
        }
    }

    public void makeRadioButtons(){
        saveFileManager = SaveFileManager.getInstance();
        gameFile = saveFileManager.getGameFile();
        Inventory inventory = gameFile.getInventory();
        lutemonRadioGroupInventory.removeAllViews();
        ArrayList<Lutemon> lutemonsInInventory = inventory.getLutemons();

        if (lutemonsInInventory != null) {
            for (Lutemon lutemon : lutemonsInInventory) {
                RadioButton rb = new RadioButton(getContext());
                rb.setText(lutemon.getName() + " type: " + lutemon.getType());
                lutemonRadioGroupInventory.addView(rb);
            }
        }
    }
}