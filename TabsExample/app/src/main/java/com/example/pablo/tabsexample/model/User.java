package com.example.pablo.tabsexample.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pablo on 6/16/2016.
 */
public class User {
    private int id;
    private String email;
    private String username;
    private String password;
    private String picture_url;
    private List<Post> posts;

    public User() {
        id = 0;
        email = "";
        username = "";
        picture_url = "";
        password = "";
        posts = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPicture_url() {
        return picture_url;
    }

    public void setPicture_url(String pictureUrl) {
        this.picture_url = pictureUrl;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
