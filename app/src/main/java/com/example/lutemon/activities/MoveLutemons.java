package com.example.lutemon.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.lutemon.R;
import com.example.lutemon.fragments.GraveyardFragment;
import com.example.lutemon.fragments.HomeFragment;
import com.example.lutemon.fragments.InventoryFragment;

public class MoveLutemons extends AppCompatActivity {

    private Button fragmentHomeController;
    private Button fragmentInventoryController;
    private Button fragmentGraveyardController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_lutemons);

        fragmentHomeController = findViewById(R.id.homeBtn);
        fragmentInventoryController = findViewById(R.id.inventoryBtn);
        fragmentGraveyardController = findViewById(R.id.deadBtn);

        fragmentHomeController.setOnClickListener(listener);
        fragmentInventoryController.setOnClickListener(listener);
        fragmentGraveyardController.setOnClickListener(listener);

        if (savedInstanceState == null) {
            fragmentInventoryController.setBackgroundColor(getColor(R.color.inactiveButton_color));
            fragmentGraveyardController.setBackgroundColor(getColor(R.color.inactiveButton_color));
            fragmentHomeController.setBackgroundColor(getColor(R.color.activeButton_color));
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frameContainer, new HomeFragment())
                    .commit();
        }
    }

    private View.OnClickListener listener = new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            fragmentHomeController.setBackgroundColor(getColor(R.color.inactiveButton_color));
            fragmentInventoryController.setBackgroundColor(getColor(R.color.inactiveButton_color));
            fragmentGraveyardController.setBackgroundColor(getColor(R.color.inactiveButton_color));
            Fragment fragment = null;

            if (view.getId() == R.id.homeBtn) {
                fragmentHomeController.setBackgroundColor(getColor(R.color.activeButton_color));
                fragment = new HomeFragment();
            } else if (view.getId() == R.id.inventoryBtn) {
                fragmentInventoryController.setBackgroundColor(getColor(R.color.activeButton_color));
                fragment = new InventoryFragment();
            } else if (view.getId() == R.id.deadBtn) {
                fragmentGraveyardController.setBackgroundColor(getColor(R.color.activeButton_color));
                fragment = new GraveyardFragment();
            }

            if (fragment != null) {
                getSupportFragmentManager().beginTransaction().replace(R.id.frameContainer, fragment).commit();
            }

        }
    };

    public void cancelBtn(View view) {
        super.onBackPressed();
    }
}