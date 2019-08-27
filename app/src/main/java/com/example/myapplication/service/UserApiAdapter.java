package com.example.myapplication.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserApiAdapter {

    public static UserApiService API_SERVICE;

    public static UserApiService getUserService() {

        String baseUrl = "http://10.0.2.2";

        if (API_SERVICE == null) {

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            API_SERVICE = retrofit.create(UserApiService.class);
        }

        return API_SERVICE;
    }
}
