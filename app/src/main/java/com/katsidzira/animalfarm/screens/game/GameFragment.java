package com.katsidzira.animalfarm.screens.game;


import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.katsidzira.animalfarm.R;
import com.katsidzira.animalfarm.databinding.FragmentGameBinding;
import com.katsidzira.animalfarm.model.Animal;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 */
public class GameFragment extends Fragment {
    private GameViewModel gameViewModel;
    private List<Animal> allAnimals;
    private List<Animal> randomAnimals;
    FragmentGameBinding binding;
    ImageView imageView;
    Random random = new Random();
    ImageView[] imageViews;


    public GameFragment() {}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_game, container, false);
        binding.setLifecycleOwner(this);

        imageViews = new ImageView[]{binding.buttonOne, binding.buttonTwo, binding.buttonThree};

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        gameViewModel = ViewModelProviders.of(this).get(GameViewModel.class);

        gameViewModel.getAnimalLiveData().observe(getViewLifecycleOwner(), new Observer<List<Animal>>() {
            @Override
            public void onChanged(List<Animal> animals) {
                allAnimals = animals;
                loadGameImages(allAnimals);

            }
        });
    }

    private void loadGameImages(List<Animal> animals) {
        List<Animal> animalsList = gameViewModel.getRandomAnimals(animals);
        int randomIndex = random.nextInt(animalsList.size());

        Animal winner = animalsList.get(randomIndex);
        binding.animalNameText.setText(winner.getName());


        for (int i = 0; i < imageViews.length; i++) {
            Picasso.get().load(animalsList.get(i).getImage()).into(imageViews[i]);
            if (animalsList.get(i) == winner) {
                imageViews[i].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        correctGuess();
//                        Toast.makeText(getContext(), "correct!", Toast.LENGTH_SHORT).show();
                    }
                });
            } else {
                imageViews[i].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        incorrectGuess();
                    }
                });
            }

        }
    }

    private void correctGuess() {
        loadGameImages(allAnimals);
//        Navigation.findNavController(getView()).navigate(R.id.action_gameFragment_to_gameWonFragment);
    }

    private void incorrectGuess() {
        Navigation.findNavController(getView()).navigate(R.id.action_gameFragment_to_gameLoseFragment);
    }
}
