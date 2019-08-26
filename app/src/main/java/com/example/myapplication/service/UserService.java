package com.example.myapplication.service;

import com.example.myapplication.model.User;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UserService {

    @GET("users")
    Call<ArrayList<User>> getUsers();
}
