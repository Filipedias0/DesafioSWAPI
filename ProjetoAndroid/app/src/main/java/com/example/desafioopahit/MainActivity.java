package com.example.desafioopahit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnPeopleIntent(View view){
        Intent intent = new Intent(getApplicationContext(), SearchPersonActivity.class);
        startActivity(intent);
    }

    public void btnSpeciesIntent(View view){
        Intent intent = new Intent(getApplicationContext(), SearchSpeciesActivity.class);
        startActivity(intent);
    }

}