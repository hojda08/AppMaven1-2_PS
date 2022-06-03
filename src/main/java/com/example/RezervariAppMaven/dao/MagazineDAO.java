package com.example.RezervariAppMaven.dao;

import com.example.RezervariAppMaven.model.Magazine;

import java.util.List;

public interface MagazineDAO {
    void insert(Magazine magazin);
    void update(String nume,Magazine magazin);
    void delete(String nume);
    List<Magazine> selectAll();
}
