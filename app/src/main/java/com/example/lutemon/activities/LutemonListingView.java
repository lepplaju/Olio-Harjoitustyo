package com.example.lutemon.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.lutemon.R;
import com.example.lutemon.adaptersAndHelpers.LutemonListAdapter;
import com.example.lutemon.classes.GameFile;
import com.example.lutemon.classes.Home;
import com.example.lutemon.classes.SaveFileManager;

public class LutemonListingView extends AppCompatActivity {
    private SaveFileManager saveFileManager;
    private GameFile gameFile;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lutemon_listing_view);

        saveFileManager = SaveFileManager.getInstance();
        gameFile = saveFileManager.getGameFile();
        Home home = gameFile.getHome();
        recyclerView = findViewById(R.id.listingsRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new LutemonListAdapter(getApplicationContext(),home.getLutemons()));

    }
}