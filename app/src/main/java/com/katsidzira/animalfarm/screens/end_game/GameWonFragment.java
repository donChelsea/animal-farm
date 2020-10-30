package com.katsidzira.animalfarm.screens.end_game;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.katsidzira.animalfarm.R;
import com.katsidzira.animalfarm.databinding.FragmentGameWonBinding;

public class GameWonFragment extends Fragment {
    private FragmentGameWonBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_game_won, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        binding.playAgainButton.setOnClickListener(v ->
                Navigation.findNavController(getView()).navigate(R.id.action_gameWonFragment_to_gameFragment)
        );

        binding.winHomeButton.setOnClickListener(v ->
                Navigation.findNavController(getView()).navigate(R.id.action_gameWonFragment_to_titleFragment)
        );
    }
}
