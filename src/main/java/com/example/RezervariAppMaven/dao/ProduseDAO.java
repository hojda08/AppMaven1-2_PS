package com.example.RezervariAppMaven.dao;

import com.example.RezervariAppMaven.model.Magazine;
import com.example.RezervariAppMaven.model.Produse;

import java.util.List;

public interface ProduseDAO {
    void insert(Produse produs);
    void update(String numeProdus,Produse produs);
    void delete(String numeProdus);
    List<Produse> selectAll();
    List<Produse> selectAllByNumeMagazin(String numeMagazin);
}
