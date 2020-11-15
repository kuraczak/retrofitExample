package com.example.retrofit;


import com.google.gson.GsonBuilder;

import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

public class Api {

    public static ApiInterface getClient() {

        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint("http://10.0.2.2:3000") //Setting the Root URL
                .build(); //Finally building the adapter

        //Creating object for our interface
        ApiInterface api = adapter.create(ApiInterface.class);
        return api;
    }
}
