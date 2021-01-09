package com.example.desafioopahit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.desafioopahit.service.APICall;
import com.example.desafioopahit.model.SearchPerson;

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

        //Retrofit Builder
        TextView textViewInfoPerson = findViewById(R.id.textViewInfoPerson);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://swapi.dev/api/") //ATENCAO esta url pode estar errada
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //instance foir interface
        APICall apiCall = retrofit.create(APICall.class);

        Call<SearchPerson> call = apiCall.getData();

        call.enqueue(new Callback<SearchPerson>() {
            @Override
            public void onResponse(Call<SearchPerson> call, Response<SearchPerson> response) {

                //Checking for the response
                if(response.code() != 200){
                    textViewInfoPerson.setText("Connection failed");
                    return;
                }

                // Get data into textview
                String  jsony = "";

                jsony = "name= " + response.body().getName() +
                        "\n height= " + response.body().getHeight() +
                        "\n mass= " + response.body().getMass() +
                        "\n hair color= " + response.body().getHair_color() +
                        "\n skin color= " + response.body().getSkin_color() +
                        "\n eye color= " + response.body().getEye_color() +
                        "\n birth year= " + response.body().getBirth_year() +
                        "\n gender= " + response.body().getGender() +
                        "\n homeworld= " + response.body().getHomeworld() +
                        "\n films= " + response.body().getFilms().toString() +
                        "\n species= " + response.body().getSpecies().toString() +
                        "\n vehicles= " + response.body().getVehicles().toString() +
                        "\n starships= " + response.body().getStarships().toString();      // is completed

                textViewInfoPerson.append(jsony);

            }

            @Override
            public void onFailure(Call<SearchPerson> call, Throwable t) {

            }
        });
    }

    public void btnSearch(View view){

    }

}