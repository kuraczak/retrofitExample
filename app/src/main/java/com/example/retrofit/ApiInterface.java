package com.example.retrofit;

import com.google.gson.JsonObject;
import java.util.List;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.PUT;
import retrofit.http.Path;

public interface ApiInterface {

    @GET("/users") // specify the sub url for our base url
    public void getUsers(Callback<List<User>> callback);


    @PUT("/users/{id}")
    public void saveUser(@Path("id") Integer id,
                         @Body() JsonObject json,
                         Callback<User> callback
                         );

}
