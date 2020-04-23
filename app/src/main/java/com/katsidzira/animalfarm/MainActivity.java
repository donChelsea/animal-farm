package com.katsidzira.animalfarm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import com.katsidzira.animalfarm.screens.game.GameViewModel;
import com.katsidzira.animalfarm.model.Animal;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private GameViewModel gameViewModel;
    List<Animal> animals;
    List<Animal> randomAnimals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        gameViewModel = ViewModelProviders.of(this).get(GameViewModel.class);
        gameViewModel.getAnimalLiveData().observe(this, new Observer() {
            @Override
            public void onChanged(Object o) {
                animals = (List<Animal>) o;
                randomAnimals = gameViewModel.getRandomAnimals(animals);
//                Log.d("yup", randomAnimals.get(0).getName());
            }
        });

    }


}
