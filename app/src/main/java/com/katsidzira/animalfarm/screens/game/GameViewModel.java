package com.katsidzira.animalfarm.screens.game;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.katsidzira.animalfarm.model.Animal;
import com.katsidzira.animalfarm.repository.AnimalRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameViewModel extends AndroidViewModel {

    private AnimalRepository animalRepository;

    public GameViewModel(@NonNull Application application) {
        super(application);

        animalRepository = new AnimalRepository(application);
    }

    public LiveData getAnimalLiveData() {
        return animalRepository.getLiveData();
    }

    /**
     * will get 3 random animals from repository
     * @return list of animals
     */

    public List<Animal> getRandomAnimals(List<Animal> animals) {
        Random rand = new Random();
        List<Animal> newList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            int randomIndex = rand.nextInt(animals.size());
            newList.add(animals.get(randomIndex));
            animals.remove(randomIndex);
        }
        return newList;
    }

}
