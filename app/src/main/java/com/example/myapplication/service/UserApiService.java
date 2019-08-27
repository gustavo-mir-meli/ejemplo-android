package com.example.myapplication.service;

import com.example.myapplication.model.User;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface UserApiService {

    @GET("users")
    Call<ArrayList<User>> getUsers();

    @POST("post")
    @FormUrlEncoded
    Call<User> postUser(@Field("mail") String mail,
                        @Field("nombre") String nombre);
}
