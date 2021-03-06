package com.katsidzira.animalfarm.screens.game;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.katsidzira.animalfarm.R;
import com.katsidzira.animalfarm.databinding.FragmentGameBinding;
import com.katsidzira.animalfarm.model.Animal;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 */
public class GameFragment extends Fragment {
    private GameViewModel gameViewModel;
    private List<Animal> allAnimals;
    private FragmentGameBinding binding;
    private Random random = new Random();
    private ImageView[] imageViews;

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

        gameViewModel.currentTime.observe(getViewLifecycleOwner(), aLong -> binding.timerText.setText(aLong.toString()));

        gameViewModel.getAnimalLiveData().observe(getViewLifecycleOwner(), animals -> {
            allAnimals = animals;
            loadGameImages(allAnimals);

        });

        gameViewModel.eventGameFinished.observe(getViewLifecycleOwner(), aBoolean -> {
            if (aBoolean) {
                Navigation.findNavController(getView()).navigate(R.id.action_gameFragment_to_gameLoseFragment);
            }
        });

    }

    private void loadGameImages(List<Animal> animals) {
        List<Animal> animalsList = gameViewModel.getRandomAnimals(animals);
        int randomIndex = random.nextInt(animalsList.size());

        ConstraintLayout cl = getView().findViewById(R.id.layout_Color);
        cl.setBackgroundColor(gameViewModel.getRandomColor());

        Animal winner = animalsList.get(randomIndex);
        binding.animalNameText.setText(winner.getName());


        for (int i = 0; i < imageViews.length; i++) {
            Picasso.get().load(animalsList.get(i).getImage()).into(imageViews[i]);
            if (animalsList.get(i) == winner) {
                imageViews[i].setOnClickListener(v -> {
                    correctGuess();
                    gameViewModel.correctPicks++;
                    if (gameViewModel.correctPicks == 3) {
                        gameWon();
                    }
                });
            } else {
                imageViews[i].setOnClickListener(v -> gameLost());
            }

        }
    }

    private void gameWon() {
        Navigation.findNavController(getView()).navigate(R.id.action_gameFragment_to_gameWonFragment);
    }

    private void correctGuess() {
        loadGameImages(allAnimals);
    }

    private void gameLost() {
        Navigation.findNavController(getView()).navigate(R.id.action_gameFragment_to_gameLoseFragment);
    }
}
