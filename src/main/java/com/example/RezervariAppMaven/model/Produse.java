package com.example.RezervariAppMaven.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Produse {
    private int id;
    private String numeProdus;
    private int cantitate;
    private String numeMagazin;
    private int pret;

    public Produse(@JsonProperty("id") int id,
                   @JsonProperty("numeProdus") String numeProdus,
                   @JsonProperty("cantitate") int cantitate,
                   @JsonProperty("numeMagazin") String numeMagazin,
                   @JsonProperty("pret") int pret) {
        this.id = id;
        this.numeProdus = numeProdus;
        this.cantitate = cantitate;
        this.numeMagazin = numeMagazin;
        this.pret = pret;
    }

    public Produse(@JsonProperty("numeProdus") String numeProdus,
                   @JsonProperty("cantitate") int cantitate,
                   @JsonProperty("numeMagazin") String numeMagazin,
                   @JsonProperty("pret") int pret) {
        this.numeProdus = numeProdus;
        this.cantitate = cantitate;
        this.numeMagazin = numeMagazin;
        this.pret = pret;
    }

    public int getId() {
        return id;
    }

    public String getNumeProdus() {
        return numeProdus;
    }

    public int getCantitate() {
        return cantitate;
    }

    public String getNumeMagazin() {
        return numeMagazin;
    }

    public int getPret() {
        return pret;
    }
}
