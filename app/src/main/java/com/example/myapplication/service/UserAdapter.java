package com.example.myapplication.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserAdapter {

    public static UserService API_SERVICE;

    public static UserService getUserService() {

        String baseUrl = "http://10.0.2.2";

        if (API_SERVICE == null) {

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            API_SERVICE = retrofit.create(UserService.class);
        }

        return API_SERVICE;
    }
}
