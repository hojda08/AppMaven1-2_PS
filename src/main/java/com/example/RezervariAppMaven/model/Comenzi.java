package com.example.RezervariAppMaven.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Comenzi {
    private int id;
    private String numeProdus;
    private String username;
    private int cantitate;

    public Comenzi(@JsonProperty("id") int id,
                   @JsonProperty("numeProdus") String numeProdus,
                   @JsonProperty("username") String username,
                   @JsonProperty("cantitate") int cantitate) {
        this.id = id;
        this.numeProdus = numeProdus;
        this.username = username;
        this.cantitate = cantitate;
    }

    public Comenzi(@JsonProperty("numeProdus") String numeProdus,
                   @JsonProperty("username") String username,
                   @JsonProperty("cantitate") int cantitate) {
        this.numeProdus = numeProdus;
        this.username = username;
        this.cantitate = cantitate;
    }

    public int getId() {
        return id;
    }

    public String getNumeProdus() {
        return numeProdus;
    }

    public String getUsername() {
        return username;
    }

    public int getCantitate() {
        return cantitate;
    }
}
