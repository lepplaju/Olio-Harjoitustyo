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
import com.example.lutemon.adaptersAndHelpers.LutemonListAdapter;
import com.example.lutemon.classes.GameFile;
import com.example.lutemon.classes.Home;
import com.example.lutemon.classes.Lutemon;
import com.example.lutemon.classes.SaveFileManager;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    private RadioGroup lutemonRadioGroup;
    private SaveFileManager saveFileManager;
    private GameFile gameFile;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        lutemonRadioGroup = view.findViewById(R.id.lutemonRadioGroup);

        makeRadioButtons();


        Button moveBtn = view.findViewById(R.id.moveButton);
        moveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveLutemonToInvent();
            }
        });

        return view;
    }

    public void moveLutemonToInvent() {
        saveFileManager = SaveFileManager.getInstance();
        gameFile = saveFileManager.getGameFile();
        Home home = gameFile.getHome();
        ArrayList<Lutemon> lutemonsInHome = home.getLutemons();
        int id = lutemonRadioGroup.getCheckedRadioButtonId();
        if (id != -1) {
            View rb = lutemonRadioGroup.findViewById(id);
            int position = lutemonRadioGroup.indexOfChild(rb);
            Lutemon lutemon = lutemonsInHome.get(position);
            home.moveLutemonToInventory(lutemon);

            makeRadioButtons();

        }
    }

    private void makeRadioButtons() {
        saveFileManager = SaveFileManager.getInstance();
        gameFile = saveFileManager.getGameFile();
        Home home = gameFile.getHome();
        lutemonRadioGroup.removeAllViews();
        ArrayList<Lutemon> lutemonsInHome = home.getLutemons();
        if (lutemonsInHome != null) {
            for (Lutemon lutemon : lutemonsInHome) {
                RadioButton rb = new RadioButton(getContext());
                rb.setText(lutemon.getName() + " type: " + lutemon.getType());
                lutemonRadioGroup.addView(rb);
            }

        }
    }
}