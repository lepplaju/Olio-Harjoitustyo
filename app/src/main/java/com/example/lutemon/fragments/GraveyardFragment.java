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
import com.example.lutemon.classes.Graveyard;
import com.example.lutemon.classes.Home;
import com.example.lutemon.classes.Lutemon;
import com.example.lutemon.classes.SaveFileManager;

import java.util.ArrayList;

public class GraveyardFragment extends Fragment {

    private RadioGroup lutemonRadioGroup;
    private SaveFileManager saveFileManager;
    private GameFile gameFile;

    public GraveyardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_graveyard, container, false);

        lutemonRadioGroup = view.findViewById(R.id.deadLutemonRadioGroup);

        makeRadioButtons();


        Button moveBtn = view.findViewById(R.id.removeButton);
        moveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removeLutemon();
            }
        });

        return view;
    }

    public void removeLutemon() {
        saveFileManager = SaveFileManager.getInstance();
        gameFile = saveFileManager.getGameFile();
        Graveyard graveyard = gameFile.getGraveyard();
        ArrayList<Lutemon> lutemonsInGraveyard = graveyard.getLutemons();
        int id = lutemonRadioGroup.getCheckedRadioButtonId();
        if (id != -1) {
            View rb = lutemonRadioGroup.findViewById(id);
            int position = lutemonRadioGroup.indexOfChild(rb);
            Lutemon lutemon = lutemonsInGraveyard.get(position);
            graveyard.deleteLutemonPermanently(lutemon);

            makeRadioButtons();

        }
    }

    private void makeRadioButtons() {
        saveFileManager = SaveFileManager.getInstance();
        gameFile = saveFileManager.getGameFile();
        Graveyard graveyard = gameFile.getGraveyard();
        lutemonRadioGroup.removeAllViews();
        ArrayList<Lutemon> lutemonsInGraveyard = graveyard.getLutemons();
        if (lutemonsInGraveyard != null) {
            for (Lutemon lutemon : lutemonsInGraveyard) {
                RadioButton rb = new RadioButton(getContext());
                rb.setText("DEAD: " + lutemon.getName() + " - was level: " + lutemon.getLevel());
                lutemonRadioGroup.addView(rb);
            }

        }
    }
}