package com.example.pablo.tabsexample.network;

import com.example.pablo.tabsexample.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Olivercv on 10/07/2016.
 */
public interface UserService {
    @GET("/users.json")
    Call<List<User>> getAllUsers();
    @POST("/login.json")
    Call<User> login(@Body User user);
}
