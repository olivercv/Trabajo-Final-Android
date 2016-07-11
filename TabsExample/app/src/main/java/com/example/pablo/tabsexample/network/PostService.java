package com.example.pablo.tabsexample.network;

import com.example.pablo.tabsexample.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface PostService {

    @GET("posts?user_id=1")
    Call<List<Post>> getPosts();
    @POST("/Post")
    Call<Post> Post(@Body Post post);
}
