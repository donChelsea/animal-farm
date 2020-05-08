package com.katsidzira.animalfarm.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * is the model for the response from the network call
 */

public class AnimalList {

    @SerializedName("animals")
    private List<Animal> animalList;

    public AnimalList(List<Animal> animalList) {
        this.animalList = animalList;
    }

    public List<Animal> getAnimalList() {
        return animalList;
    }

    public void setAnimalList(List<Animal> animalList) {
        this.animalList = animalList;
    }
}
