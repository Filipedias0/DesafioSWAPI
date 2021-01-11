package com.example.desafioopahit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.desafioopahit.model.SearchPerson;
import com.example.desafioopahit.model.SearchSpecies;
import com.example.desafioopahit.service.APICall;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SearchSpeciesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_species);
    }

    // list person
    List<SearchSpecies> speciesList;

    public void btnHome(View view){
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }

    public void btnSearch(View view){


        TextView textViewInfoSpecies = findViewById(R.id.textViewInfoSpecies);
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
        Call<JSONResponse> call = apiCall.getSpecies(name);

        call.enqueue(new Callback<JSONResponse>() {
            @Override
            public void onResponse(Call<JSONResponse> call, Response<JSONResponse> response) {

                if(response.code() != 200){
                    textViewInfoSpecies.setText("Connection failed");
                    return;
                }

                JSONResponse jsonResponse = response.body();
                speciesList = new ArrayList<SearchSpecies>(new ArrayList(jsonResponse.getResults()));
                textViewInfoSpecies.setText(speciesList.toString());
            }

            @Override
            public void onFailure(Call<JSONResponse> call, Throwable t) {
                textViewInfoSpecies.setText(t.toString());
                return;
            }
        });

    }

}