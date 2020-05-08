package com.katsidzira.animalfarm.screens.game;

import android.app.Application;
import android.content.res.TypedArray;
import android.os.CountDownTimer;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.katsidzira.animalfarm.R;
import com.katsidzira.animalfarm.model.Animal;
import com.katsidzira.animalfarm.repository.AnimalRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameViewModel extends AndroidViewModel {

    private AnimalRepository animalRepository;

    MutableLiveData<Long> currentTime = new MutableLiveData<>();
    MutableLiveData<Boolean> eventGameFinished = new MutableLiveData<>();

    CountDownTimer timer;
    private static final Long DONE = 0L;
    private static final Long ONE_SECOND = 1000L;
    private static final Long COUNTDOWN_TIME = 6000L;

    Random rand = new Random();
    int correctPicks = 0;


    public GameViewModel(@NonNull Application application) {
        super(application);

        animalRepository = new AnimalRepository(application);

        timer = new CountDownTimer(COUNTDOWN_TIME, ONE_SECOND) {
            @Override
            public void onTick(long millisUntilFinished) {
                currentTime.setValue(millisUntilFinished / ONE_SECOND);
                Log.d("vm", currentTime.getValue().toString());
            }

            @Override
            public void onFinish() {
                currentTime.setValue(DONE);
                eventGameFinished.setValue(true);
            }
        };
        timer.start();

        eventGameFinished.setValue(false);
    }

    public MutableLiveData<List<Animal>> getAnimalLiveData() {
        return animalRepository.getLiveData();
    }

    /**
     * will get 3 random animals from repository
     * @return list of animals
     */

    public List<Animal> getRandomAnimals(List<Animal> animals) {
        List<Animal> newList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            int randomIndex = rand.nextInt(animals.size());
            newList.add(animals.get(randomIndex));
            animals.remove(randomIndex);
        }
        return newList;
    }

    public Integer getRandomColor() {
        TypedArray ta = getApplication().getResources().obtainTypedArray(R.array.rainbow);
        int[] rainbow = new int[ta.length()];
        for (int i = 0; i < ta.length(); i++) {
            rainbow[i] = ta.getColor(i, 0);
        }
        ta.recycle();

        int randomIndex = rand.nextInt(rainbow.length);
        return rainbow[randomIndex];
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        timer.cancel();
    }
}
