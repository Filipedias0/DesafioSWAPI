package com.example.desafioopahit.model;

import java.util.ArrayList;

public class SearchSpecies {

    //Java that is used as a JSON model(POJO)
    //Could use @SerializedName to have a diffent Var/Json name
    private String name, classification, designation, skins_colors, hair_colors, eye_colors,
            homeworld, language;
    private int average_height,  average_lifespan;
    private String[] people;
    private String[] films;
    private int height, mass;

    public String getName() {
        return name;
    }

    public String getClassification() {
        return classification;
    }

    public String getDesignation() {
        return designation;
    }

    public String getSkins_colors() {
        return skins_colors;
    }

    public String getHair_colors() {
        return hair_colors;
    }

    public String getEye_colors() {
        return eye_colors;
    }

    public String getHomeworld() {
        return homeworld;
    }

    public String getLanguage() {
        return language;
    }

    public int getAverage_height() {
        return average_height;
    }

    public int getAverage_lifespan() {
        return average_lifespan;
    }

    public String[] getPeople() {
        return people;
    }

    public String[] getFilms() {
        return films;
    }

    public int getHeight() {
        return height;
    }

    public int getMass() {
        return mass;
    }
}
