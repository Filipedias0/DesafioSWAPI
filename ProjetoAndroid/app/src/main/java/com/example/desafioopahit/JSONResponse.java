package com.example.desafioopahit;

import android.text.TextUtils;

import com.example.desafioopahit.model.SearchPerson;

import java.io.Serializable;
import java.util.ArrayList;

public class JSONResponse<T> {

    private  ArrayList<T> results;

    public ArrayList<T> getResults() {
        return results;
    }
}

