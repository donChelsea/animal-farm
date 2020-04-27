package com.katsidzira.animalfarm.model;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;

import com.google.gson.annotations.SerializedName;
import com.katsidzira.animalfarm.R;

public class Animal {

    @SerializedName("name")
    private String name;

    @SerializedName("image")
    private String image;

    @SerializedName("fact")
    private String fact;

    private Boolean isFavorited;

    public Boolean getFavorited() {
        return isFavorited;
    }

    public void setFavorited(Boolean favorited) {
        isFavorited = favorited;
    }

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
