package com.example.desafioopahit.model;


import java.util.ArrayList;

public class SearchPerson {

    //Java that is used as a JSON model(POJO)
    //Could use @SerializedName to have a diffent Var/Json name
    private String name, hair_color, skin_color, eye_color, birth_year, gender, homeworld;
    private ArrayList<String> films;
    private ArrayList<String> species;
    private ArrayList<String> vehicles;
    private ArrayList<String> starships;
    private int height, mass;

    public String getName() {
        return name;
    }

    public String getHair_color() {
        return hair_color;
    }

    public String getEye_color() {
        return eye_color;
    }

    public String getBirth_year() {
        return birth_year;
    }

    public String getGender() {
        return gender;
    }

    public String getHomeworld() {
        return homeworld;
    }

    public ArrayList<String> getFilms() {
        return films;
    }

    public ArrayList<String> getSpecies() {
        return species;
    }

    public ArrayList<String> getVehicles() {
        return vehicles;
    }

    public ArrayList<String> getStarships() {
        return starships;
    }

    public int getHeight() {
        return height;
    }

    public int getMass() {
        return mass;
    }

    public String getSkin_color() {
        return skin_color;
    }
//pode dar errado


}
