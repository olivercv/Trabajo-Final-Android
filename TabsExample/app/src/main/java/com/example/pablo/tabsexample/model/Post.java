package com.example.pablo.tabsexample.model;

public class Post {
    private int id;
    private String title;
    private String content;
    private User user;

    public Post() {
        id = 0;
        title = "";
        content = "";
        user = new User();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
