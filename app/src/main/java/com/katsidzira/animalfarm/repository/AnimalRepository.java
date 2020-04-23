package com.katsidzira.animalfarm.repository;

import android.app.Application;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.katsidzira.animalfarm.model.Animal;
import com.katsidzira.animalfarm.model.AnimalList;
import com.katsidzira.animalfarm.network.AnimalService;
import com.katsidzira.animalfarm.network.RetrofitSingleton;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AnimalRepository {

    public static final String TAG = "repository";
    List<Animal> animalList = new ArrayList<>();
    private MutableLiveData<List<Animal>> mutableLiveData = new MutableLiveData<>();
    private Application application;

    public AnimalRepository(Application application) {
        this.application = application;
    }

    /**
     * exposes the mutalable live data retrieved from api call
     * @return mutableLiveData
     */

    public MutableLiveData<List<Animal>> getLiveData() {
        AnimalService animalApiService = RetrofitSingleton.getAnimalApiService();
        animalApiService.getAllAnimals().enqueue(new Callback<AnimalList>() {
            @Override
            public void onResponse(Call<AnimalList> call, Response<AnimalList> response) {
//                Log.d("main", "animal: " + response.body().getAnimalList().get(0).getFact());
                if (response.body() != null) {
                    animalList = response.body().getAnimalList();
                    mutableLiveData.setValue(animalList);
                }
            }

            @Override
            public void onFailure(Call<AnimalList> call, Throwable t) {
//                Log.d("main", "failed: " + t.getMessage());
                Log.d(TAG, "failed: " + t.getMessage());
            }
        });

        return mutableLiveData;
    }

    public List<Animal> getAnimalList() {
        return mutableLiveData.getValue();
    }
}
