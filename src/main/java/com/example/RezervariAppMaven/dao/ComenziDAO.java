package com.example.RezervariAppMaven.dao;

import com.example.RezervariAppMaven.model.Comenzi;
import com.example.RezervariAppMaven.model.Users;

import java.util.List;

public interface ComenziDAO {
    void insert(Comenzi comanda);
    void delete(int id);
    List<Comenzi> selectAll();
}
