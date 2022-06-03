package com.example.RezervariAppMaven.service;

import com.example.RezervariAppMaven.dao.MagazineData;
import com.example.RezervariAppMaven.dao.ProduseData;
import com.example.RezervariAppMaven.model.Magazine;
import com.example.RezervariAppMaven.model.Produse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduseService {

    private ProduseData produseData;

    @Autowired
    public ProduseService(ProduseData produseData) {
        this.produseData = produseData;
    }

    public void addProdus(Produse produs){
        produseData.insert(produs);
    }

    public void updateProdus(String numeProdus, Produse produs){
        produseData.update(numeProdus,produs);
    }

    public void deleteProdus(String numeProdus){
        produseData.delete(numeProdus);
    }

    public List<Produse> findProduse(){
        return produseData.selectAll();
    }

    public List<Produse> findProduseByMagazin(String numeMagazin){
        return produseData.selectAllByNumeMagazin(numeMagazin);
    }

}
