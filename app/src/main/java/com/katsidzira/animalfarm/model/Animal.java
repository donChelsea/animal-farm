package com.katsidzira.animalfarm.model;

import com.google.gson.annotations.SerializedName;

public class Animal {

    @SerializedName("name")
    private String name;

    @SerializedName("image")
    private String image;

    @SerializedName("fact")
    private String fact;

    public Animal() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getFact() {
        return fact;
    }

    public void setFact(String fact) {
        this.fact = fact;
    }
}
