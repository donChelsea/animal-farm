package com.katsidzira.animalfarm.screens.facts;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.katsidzira.animalfarm.R;
import com.katsidzira.animalfarm.controller.AnimalAdapter;
import com.katsidzira.animalfarm.databinding.AnimalListViewBinding;
import com.katsidzira.animalfarm.databinding.FragmentFactsBinding;
import com.katsidzira.animalfarm.model.Animal;

import java.util.List;

public class FactsFragment extends Fragment {
    private FragmentFactsBinding binding;
    RecyclerView recyclerView;
    FactsViewModel factsViewModel;

    public FactsFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_facts, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = binding.recyclerView;

        factsViewModel = ViewModelProviders.of(this).get(FactsViewModel.class);

        factsViewModel.getLiveData().observe(getViewLifecycleOwner(), new Observer<List<Animal>>() {
            @Override
            public void onChanged(List<Animal> animals) {
                recyclerView.setAdapter(new AnimalAdapter(animals));
                recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
            }
        });
    }
}
