package com.katsidzira.animalfarm.screens.title;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.katsidzira.animalfarm.R;
import com.katsidzira.animalfarm.databinding.FragmentTitleBinding;


public class TitleFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        FragmentTitleBinding binding = DataBindingUtil
                .inflate(LayoutInflater.from(container.getContext()), R.layout.fragment_title, container, false);

        binding.playButton.setOnClickListener(v ->
                Navigation.findNavController(v).navigate(R.id.action_titleFragment_to_gameFragment)
        );

        binding.factsButton.setOnClickListener(v ->
                Navigation.findNavController(v).navigate(R.id.action_titleFragment_to_factsFragment)
        );

        return binding.getRoot();
    }

}
