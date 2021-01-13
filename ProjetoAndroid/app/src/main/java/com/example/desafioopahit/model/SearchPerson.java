package com.example.desafioopahit.model;


public class SearchPerson {


    //Java that is used as a JSON model(POJO)
    //Could use @SerializedName to have a diffent Var/Json name
    private String name, hair_color, skin_color, eye_color, birth_year, gender, homeworld;
    private String[] filmsUrl;
    private String[] species;
    private String[] vehicles;
    private String[] starships;
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

    public String getGener() {
        return gender;
    }

    public String getHomeworld() {
        return homeworld;
    }

    public String[] getFilms() {
        return filmsUrl;
    }

    public String[] getSpecies() {
        return species;
    }

    public String[] getVehicles() {
        return vehicles;
    }

    public String[] getStarships() {
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
}
