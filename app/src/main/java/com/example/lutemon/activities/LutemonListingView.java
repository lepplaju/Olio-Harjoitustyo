package com.example.lutemon.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.lutemon.R;
import com.example.lutemon.adaptersAndHelpers.LutemonListAdapter;
import com.example.lutemon.classes.GameFile;
import com.example.lutemon.classes.Home;
import com.example.lutemon.classes.Inventory;
import com.example.lutemon.classes.Lutemon;
import com.example.lutemon.classes.SaveFileManager;

import java.util.ArrayList;

import kotlin.comparisons.UComparisonsKt;

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
        Inventory inventory = gameFile.getInventory();
        Home home = gameFile.getHome();
        ArrayList<Lutemon> combinedList = new ArrayList<>();
        combinedList.addAll(home.getLutemons());
        combinedList.addAll(inventory.getLutemons());
        recyclerView = findViewById(R.id.listingsRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new LutemonListAdapter(getApplicationContext(), combinedList));

    }
        public void cancelBtn(View view) {
        super.onBackPressed();
    }
}