package com.katsidzira.animalfarm.screens.facts;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.katsidzira.animalfarm.model.Animal;
import com.katsidzira.animalfarm.repository.AnimalRepository;

import java.util.List;

public class FactsViewModel extends AndroidViewModel {
    private AnimalRepository animalRepository;

    public FactsViewModel(@NonNull Application application) {
        super(application);

        animalRepository = new AnimalRepository(application);
    }

    public MutableLiveData<List<Animal>> getLiveData() {
        return animalRepository.getLiveData();
    }
}
