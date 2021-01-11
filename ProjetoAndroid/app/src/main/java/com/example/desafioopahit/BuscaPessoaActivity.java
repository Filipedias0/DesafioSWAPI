package com.example.desafioopahit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.Person;
import android.content.Intent;
import android.net.Credentials;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.desafioopahit.service.APICall;
import com.example.desafioopahit.model.SearchPerson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BuscaPessoaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busca_pessoa);
    }

    // list person
    List<SearchPerson> personsList;

    public void btnHome(View view){
        ImageView btnHomePerson = findViewById(R.id.btnHomePerson);

        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }

    public void btnSearch(View view){

        //Retrofit Builder
        TextView textViewInfoPerson = findViewById(R.id.textViewInfoPerson);
        EditText editTextPersonName = findViewById(R.id.editTextPersonName);
        String name = editTextPersonName.getText().toString();
        personsList = new ArrayList<>();

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
                    textViewInfoPerson.setText("Connection failed");
                    return;
                }

                JSONResponse jsonResponse = response.body();

                //Tratar a array com for each para os atributos ficarem formatados de forma correta
                personsList = new ArrayList<SearchPerson>(new ArrayList(jsonResponse.getResults()));
                textViewInfoPerson.setText(personsList.toString());
            }

            @Override
            public void onFailure(Call<JSONResponse> call, Throwable t) {
                textViewInfoPerson.setText(t.toString());
                return;
            }
        });

    }

}