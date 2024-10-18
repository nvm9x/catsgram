package com.practice.catsgram.model;

import java.time.Instant;

public class Post {

    private int id;
    private final String author; // автор
    private final Instant creationDate = Instant.now(); // дата создания
    private String description; // описание
    private String photoUrl; // url-адрес фотографии

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Post(int id, String author, String description, String photoUrl) {
        this.id=id;
        this.author = author;
        this.description = description;
        this.photoUrl = photoUrl;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getAuthor() {
        return author;
    }

    public Instant getCreationDate() {
        return creationDate;
    }

    public String getDescription() {
        return description;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }
}