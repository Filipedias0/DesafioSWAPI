package com.example.desafioopahit.service;
import com.example.desafioopahit.model.SearchPerson;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APICall {

    //  public static final String baseUrl = "https://swapi.dev/api/";
    //Inteface that define the possible HTTP operations

    @GET("people/1/")
    Call<SearchPerson> getData();
}
