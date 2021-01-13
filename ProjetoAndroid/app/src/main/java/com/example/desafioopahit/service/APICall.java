package com.example.desafioopahit.service;
import com.example.desafioopahit.JSONResponse;
import com.example.desafioopahit.JSONResponseSpecies;
import com.example.desafioopahit.model.SearchPerson;
import com.example.desafioopahit.model.SearchSpecies;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APICall {

    //  public static final String baseUrl = "https://swapi.dev/api/";
    //Inteface that define the possible HTTP operations
    // https://swapi.dev/api/people/?search=r2

    /*@GET("people/1/")
    Call<SearchPerson> getPerson();*/

    // https://swapi.dev/api/planets/?page=6

    //Query is used in search because it returns various objects
    /*@GET("people/?search={name}")
    Call<SearchPerson> getPerson(
            @Path("name") String name,  //mudar name para personName
            @Query("page") int page
            );*/

    @GET("species/{id}")
    Call<SearchSpecies> getSpeciesId(
            @Path("id") String id
    );

    @GET("people/")
    Call<JSONResponse> getPerson(
            @Query("search") String search
    );

    @GET("species/ ")
    Call<JSONResponseSpecies> getSpecies(
            @Query("search") String search
    );

}
