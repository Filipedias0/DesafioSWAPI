package com.example.desafioopahit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.desafioopahit.model.SearchPerson;
import com.example.desafioopahit.model.SearchSpecies;
import com.example.desafioopahit.service.APICall;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SearchSpeciesActivity extends AppCompatActivity {

    RecyclerView recyclerViewSearchSpecies;
    List<SearchSpecies> speciesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_species);

        recyclerViewSearchSpecies = findViewById(R.id.recyclerViewSearchSpecies);

    }


    public void btnHome(View view){
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }

    public void btnSearchSpecies(View view){

        EditText editTextSpeciesName = findViewById(R.id.editTextSpeciesName);
        String name = editTextSpeciesName.getText().toString();
        speciesList = new ArrayList<>();

        //Retrofit Builder
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://swapi.dev/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //instance for interface
        APICall apiCall = retrofit.create(APICall.class);
        //get url
        Call<JSONResponseSpecies> call = apiCall.getSpecies(name);

        call.enqueue(new Callback<JSONResponseSpecies>() {
            @Override
            public void onResponse(Call<JSONResponseSpecies> call, Response<JSONResponseSpecies> response) {

                 JSONResponseSpecies jsonResponse  = response.body();
                 speciesList = new ArrayList<>(Arrays.asList(jsonResponse.getResults()));

                 PutDataIntoRecyclerView(speciesList);
            }

            @Override
            public void onFailure(Call<JSONResponseSpecies> call, Throwable t) {

            }
        });

    }

    private void PutDataIntoRecyclerView(List<SearchSpecies> speciesList) {
        AdapterySearchSpecies adaptery = new AdapterySearchSpecies(this, speciesList);
        recyclerViewSearchSpecies.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewSearchSpecies.setAdapter(adaptery);
    }


}