package com.katsidzira.animalfarm.network;

import com.katsidzira.animalfarm.model.AnimalList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * api service to http get request
 */

public interface AnimalService {

    @GET("/donChelsea/6619c69def9a1933ed4665c28dbf8452/raw/21557f6ece03b79fbf4ffba2f54e95f3e37cb563/animals2.json")
    Call<AnimalList> getAllAnimals();
}

