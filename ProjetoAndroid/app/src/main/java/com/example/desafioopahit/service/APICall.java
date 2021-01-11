package com.example.desafioopahit.service;
import com.example.desafioopahit.JSONResponse;

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

    /*@GET("people/{id}")
    Call<JSONResponse> getPerson(
            @Path("id") int id);*/


    /*@GET("people/?search=Luke")
    Call<JSONResponse> getPerson(

    );*/

    @GET("people/")
    Call<JSONResponse> getPerson(
        @Query("search") String search
    );

    @GET("species/ ")
    Call<JSONResponse> getSpecies(
            @Query("search") String search
    );

}
