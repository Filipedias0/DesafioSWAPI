package com.example.desafioopahit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.desafioopahit.model.SearchSpecies;
import com.example.desafioopahit.service.APICall;
import com.example.desafioopahit.model.SearchPerson;

import java.lang.reflect.Executable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SearchPersonActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busca_pessoa);

        recyclerView = findViewById(R.id.recyclerView);

    }

    // list person
    List<SearchPerson> personsList;

    public void btnHome(View view){
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }

    public void btnSearch(View view){

        EditText editTextPersonName = findViewById(R.id.editTextPersonName);
        String name = editTextPersonName.getText().toString();
        personsList = new ArrayList<>();

        //Retrofit Builder
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://swapi.dev/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //instance for interface
        APICall apiCall = retrofit.create(APICall.class);

        Call<JSONResponse> call = apiCall.getPerson(name);

        call.enqueue(new Callback<JSONResponse>() {
            @Override
            public void onResponse(Call<JSONResponse> call, Response<JSONResponse> response) {

                if(response.code() != 200){
                    //inserir text view
                    return;
                }

                JSONResponse jsonResponse = response.body();
                personsList = new ArrayList<>(Arrays.asList(jsonResponse.getResults()));

                PutDataIntoRecyclerView(personsList);
                // List<SearchPerson> persons = response.body();

            }

            @Override
            public void onFailure(Call<JSONResponse> call, Throwable t) {
                //inserir textview
                return;
            }
        });

    }

    private void PutDataIntoRecyclerView(List<SearchPerson> personsList) {
        Adaptery adaptery = new Adaptery(this, personsList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adaptery);
    }

}