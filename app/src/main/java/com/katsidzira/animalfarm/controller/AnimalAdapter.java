package com.katsidzira.animalfarm.controller;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.katsidzira.animalfarm.R;
import com.katsidzira.animalfarm.model.Animal;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder> {
    private List<Animal> animalList;

    public AnimalAdapter(List<Animal> animalList) {
        this.animalList = animalList;
    }

    @NonNull
    @Override
    public AnimalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.animal_list_view, parent, false);
        return new AnimalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalViewHolder holder, int position) {
        holder.onBind(animalList.get(position));

    }

    @Override
    public int getItemCount() {
        return animalList.size();
    }

    class AnimalViewHolder extends RecyclerView.ViewHolder {
        TextView nameText, factText;
        ImageView animalImage;

        public AnimalViewHolder(@NonNull View itemView) {
            super(itemView);

            nameText = itemView.findViewById(R.id.rec_animal_name_text);
            factText = itemView.findViewById(R.id.fun_fact_text);
            animalImage = itemView.findViewById(R.id.imageView);
        }

        public void onBind(Animal animal) {
            nameText.setText(animal.getName());
            factText.setText(animal.getFact());
            Picasso.get().load(animal.getImage()).into(animalImage);
        }
    }
}