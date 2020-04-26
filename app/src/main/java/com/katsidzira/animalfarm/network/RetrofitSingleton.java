package com.katsidzira.animalfarm.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitSingleton {

    public static final String BASE_URL = "https://gist.githubusercontent.com";

    private static Retrofit retrofit;

    private RetrofitSingleton() {}

    public static AnimalService getAnimalApiService() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(AnimalService.class);
    }
}
