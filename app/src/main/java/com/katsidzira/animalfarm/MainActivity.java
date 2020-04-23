package com.katsidzira.animalfarm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.katsidzira.animalfarm.model.AnimalList;
import com.katsidzira.animalfarm.network.AnimalService;
import com.katsidzira.animalfarm.network.RetrofitSingleton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = RetrofitSingleton.getInstance();
        AnimalService animalService = retrofit.create(AnimalService.class);
        animalService.getAllAnimals().enqueue(new Callback<AnimalList>() {
            @Override
            public void onResponse(Call<AnimalList> call, Response<AnimalList> response) {
                Log.d("main", "animal: " + response.body().getAnimalList().get(0).getFact());
            }

            @Override
            public void onFailure(Call<AnimalList> call, Throwable t) {
                Log.d("main", "failed: " + t.getMessage());
            }
        });
    }
}
