package com.example.lutemon.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.lutemon.R;
import com.example.lutemon.adaptersAndHelpers.LutemonListAdapter;
import com.example.lutemon.classes.Home;

public class LutemonListingView extends AppCompatActivity {
    private Home storage;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lutemon_listing_view);

        storage = Home.getInstance();
        recyclerView = findViewById(R.id.listingsRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new LutemonListAdapter(getApplicationContext(),storage.getLutemons()));

    }
}