package com.example.RezervariAppMaven.service;

import com.example.RezervariAppMaven.dao.ComenziData;
import com.example.RezervariAppMaven.dao.MagazineData;
import com.example.RezervariAppMaven.model.Comenzi;
import com.example.RezervariAppMaven.model.Magazine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComenziService {
    private ComenziData comenziData;

    @Autowired
    public ComenziService(ComenziData comenziData) {
        this.comenziData = comenziData;
    }

    public void addComanda(Comenzi comanda){
        comenziData.insert(comanda);
    }

    public void deleteComanda(int id){
        comenziData.delete(id);
    }

    public List<Comenzi> findComenzi(){
        return comenziData.selectAll();
    }
}
