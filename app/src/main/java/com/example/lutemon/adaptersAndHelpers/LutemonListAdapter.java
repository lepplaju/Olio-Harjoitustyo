package com.example.lutemon.adaptersAndHelpers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lutemon.R;
import com.example.lutemon.classes.Lutemon;

import java.util.ArrayList;

public class LutemonListAdapter extends RecyclerView.Adapter<LutemonViewHelper> {
    private Context context;
    private ArrayList<Lutemon> lutemons;

    public LutemonListAdapter(Context context, ArrayList<Lutemon> lutemons){
        this.context = context;
        this.lutemons = lutemons;
    }

    @NonNull
    @Override
    public LutemonViewHelper onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        return new LutemonViewHelper(LayoutInflater.from(context).inflate(R.layout.lutemon_listing_placeholder,parent,false));
    }


    @Override
    public void onBindViewHolder(@NonNull LutemonViewHelper holder, int position){
        Lutemon lutemon = lutemons.get(position);
        holder.name.setText("Name: " + lutemon.getName().toString());
        holder.type.setText("Type: " + lutemon.getType().toString());
        holder.location.setText("Location: " + lutemon.getStorageLocation());
        holder.level.setText("Level: " + String.valueOf(lutemon.getLevel()));
        holder.hitpoints.setText("Hitpoints: " + String.valueOf(lutemon.getHealth()) + "/" +lutemon.getMaxHealth());
        holder.attack.setText("Attack: " + lutemon.getAttack());
        holder.defence.setText("Defence: " + lutemon.getDefence());
        holder.image.setImageResource(lutemon.getImage());

    }
    @Override
    public int getItemCount() {
        return lutemons.size();
    }
}
