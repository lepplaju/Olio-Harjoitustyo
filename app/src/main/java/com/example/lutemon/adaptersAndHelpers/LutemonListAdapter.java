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
        holder.information.setText(lutemon.getName().toString()  + " : " +  lutemon.getType().toString());
        holder.strength.setText("Attack: " + String.valueOf(lutemon.getAttack()));
        holder.defence.setText("Defence: " + String.valueOf(lutemon.getDefence()));
        holder.exp.setText("exp: " + String.valueOf(lutemon.getExperience()));
        holder.hitpoints.setText("HP: " + String.valueOf(lutemon.getHealth()));
    }
    @Override
    public int getItemCount() {
        return lutemons.size();
    }
}
