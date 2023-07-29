package com.example.lutemon.adaptersAndHelpers;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lutemon.R;

public class LutemonViewHelper extends RecyclerView.ViewHolder {

    TextView name, type, level, defence, hitpoints, attack,location;
    ImageView image;

    public  LutemonViewHelper(@NonNull View itemView){
        super(itemView);
        name = itemView.findViewById(R.id.nametvholder);
        type = itemView.findViewById(R.id.typetvholder);
        level = itemView.findViewById(R.id.leveltvholder);
        hitpoints = itemView.findViewById(R.id.hitpointstvholder);
        location = itemView.findViewById(R.id.locationtvholder);
        attack = itemView.findViewById(R.id.attackholdertv);
        defence = itemView.findViewById(R.id.defenceholdertv);
        image = itemView.findViewById(R.id.imageholder);
    }
}
