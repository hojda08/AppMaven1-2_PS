package com.example.RezervariAppMaven.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Magazine {
    private int id;
    private String nume;
    private int rating;

    public Magazine(@JsonProperty("id") int id,
                    @JsonProperty("nume") String nume,
                    @JsonProperty("rating") int rating) {
        this.id = id;
        this.nume = nume;
        this.rating = rating;
    }

    public Magazine(@JsonProperty("nume") String nume,
                    @JsonProperty("rating") int rating) {
        this.id = 0;
        this.nume = nume;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public String getNume() {
        return nume;
    }

    public int getRating() {
        return rating;
    }
}
