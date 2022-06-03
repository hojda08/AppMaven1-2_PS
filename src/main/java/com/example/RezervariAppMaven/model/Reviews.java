package com.example.RezervariAppMaven.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Reviews {
    private int id;
    private String numeProdus;
    private String text;
    private int likes;

    public Reviews(@JsonProperty("id") int id,
                   @JsonProperty("numeProdus") String numeProdus,
                   @JsonProperty("text") String text,
                   @JsonProperty("likes") int likes) {
        this.id = id;
        this.numeProdus = numeProdus;
        this.text = text;
        this.likes = likes;
    }

    public Reviews(@JsonProperty("numeProdus") String numeProdus,
                   @JsonProperty("text") String text,
                   @JsonProperty("likes") int likes) {
        this.numeProdus = numeProdus;
        this.text = text;
        this.likes = likes;
    }

    public int getId() {
        return id;
    }

    public String getNumeProdus() {
        return numeProdus;
    }

    public String getText() {
        return text;
    }

    public int getLikes() {
        return likes;
    }
}
