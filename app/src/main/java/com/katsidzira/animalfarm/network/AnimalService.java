package com.katsidzira.animalfarm.network;

import com.katsidzira.animalfarm.model.AnimalList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AnimalService {

    @GET("/donChelsea/aa939ae3397043df1e1b17499ec0c238/raw/291e66ec1d91e27f673bdfcd70ec44b8ce2c3f20/animals.json")
    public Call<AnimalList> getAllAnimals();
}
