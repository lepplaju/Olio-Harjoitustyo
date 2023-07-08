package com.example.lutemon.adaptersAndHelpers;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lutemon.R;

public class LutemonViewHelper extends RecyclerView.ViewHolder {

    TextView information, strength, defence, hitpoints, exp;

    public  LutemonViewHelper(@NonNull View itemView){
        super(itemView);
        information = itemView.findViewById(R.id.uniqueinfotvholder);
        strength = itemView.findViewById(R.id.strengthtvholder);
        defence = itemView.findViewById(R.id.defencetvholder);
        hitpoints = itemView.findViewById(R.id.hitpointstvholder);
        exp = itemView.findViewById(R.id.exptvholder);
    }
}
