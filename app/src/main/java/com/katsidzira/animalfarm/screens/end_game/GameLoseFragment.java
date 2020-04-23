package com.katsidzira.animalfarm.screens.end_game;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.katsidzira.animalfarm.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class GameLoseFragment extends Fragment {


    public GameLoseFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game_lose, container, false);
    }

}
