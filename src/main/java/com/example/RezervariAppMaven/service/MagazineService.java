package com.example.RezervariAppMaven.service;

import com.example.RezervariAppMaven.dao.MagazineData;
import com.example.RezervariAppMaven.dao.UsersData;
import com.example.RezervariAppMaven.model.Magazine;
import com.example.RezervariAppMaven.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MagazineService {

    private MagazineData magazineData;

    @Autowired
    public MagazineService(MagazineData magazineData) {
        this.magazineData = magazineData;
    }

    public void addMagazin(Magazine magazin){
        magazineData.insert(magazin);
    }

    public void updateMagazin(String nume, Magazine magazin){
        magazineData.update(nume,magazin);
    }

    public void deleteMagazin(String nume){
        magazineData.delete(nume);
    }

    public List<Magazine> findMagazine(){
        return magazineData.selectAll();
    }
}
