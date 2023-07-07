package com.example.lutemon.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.lutemon.R;
import com.example.lutemon.fragments.BattleFragment;
import com.example.lutemon.fragments.GraveyardFragment;
import com.example.lutemon.fragments.HomeFragment;
import com.example.lutemon.fragments.TrainFragment;

public class MoveLutemons extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_lutemons);

        Button fragmentHome = findViewById(R.id.homeBtn);
        Button fragmentTrain = findViewById(R.id.trainBtn);
        Button fragmentBattle = findViewById(R.id.battleBtn);
        Button fragmentGraveyard = findViewById(R.id.deadBtn);

        fragmentHome.setOnClickListener(listener);
        fragmentTrain.setOnClickListener(listener);
        fragmentBattle.setOnClickListener(listener);
        fragmentGraveyard.setOnClickListener(listener);
    }

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Fragment fragment = null;

            if (view.getId() == R.id.homeBtn) {
                fragment = new HomeFragment();
            } else if (view.getId() == R.id.trainBtn) {
                fragment = new TrainFragment();
            } else if (view.getId() == R.id.battleBtn) {
                fragment = new BattleFragment();
            } else if (view.getId() == R.id.deadBtn) {
                fragment = new GraveyardFragment();
            }

            if (fragment != null) {
                getSupportFragmentManager().beginTransaction().replace(R.id.frameContainer, fragment).commit();
            }

        }
    };
}