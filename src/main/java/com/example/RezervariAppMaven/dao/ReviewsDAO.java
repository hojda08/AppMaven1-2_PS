package com.example.RezervariAppMaven.dao;

import com.example.RezervariAppMaven.model.Produse;
import com.example.RezervariAppMaven.model.Reviews;

import java.util.List;

public interface ReviewsDAO {
    void insert(Reviews review);
    List<Reviews> selectAll();
    List<Reviews> selectAllByNumeProdus(String numeProdus);
}
