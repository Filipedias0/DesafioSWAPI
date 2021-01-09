package com.example.desafioopahit.service;

import android.os.AsyncTask;

import com.example.desafioopahit.model.SearchPerson;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class HTTPService extends AsyncTask<Void, Void, SearchPerson> {

    private  String searchContext;
    private  String searchName;

    //Construtor com parâmetros necesários para a url
    public HTTPService(String searchContext, String searchName) {
        //Context seria people, planet, etc.
        this.searchContext = searchContext;
        //Name seria o nome do personagem, lugar, etc.
        this.searchName = searchName;
    }

    //Ligação com a API
    @Override
    protected SearchPerson doInBackground(Void... voids) {
        StringBuilder resposta = new StringBuilder();
        try {
            URL url = new URL("https://swapi.dev/api/"+searchContext+"/"+searchName+"/");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept","application/json");
            connection.setConnectTimeout(5000);
            connection.connect();

            Scanner scanner = new Scanner(url.openStream());
            while(scanner.hasNext()){
                resposta.append(scanner.next());
            }
        } catch (MalformedURLException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Gson().fromJson(resposta.toString(),SearchPerson.class);
    }
}
