package com.example.RezervariAppMaven.api;

import com.example.RezervariAppMaven.model.Magazine;
import com.example.RezervariAppMaven.model.Users;
import com.example.RezervariAppMaven.service.MagazineService;
import com.example.RezervariAppMaven.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("magazine")
@RestController
public class ControllerMagazine {
    private MagazineService magazineService;

    @Autowired
    public ControllerMagazine(MagazineService magazineService) {
        this.magazineService = magazineService;
    }

    @PostMapping
    public void addMagazin(@RequestBody Magazine magazin){
        magazineService.addMagazin(magazin);
    }

    @PutMapping(path = "{nume}")
    public void updateMagazin(@PathVariable("nume") String nume,@RequestBody Magazine magazin){
        magazineService.updateMagazin(nume,magazin);
    }

    @DeleteMapping(path = "{nume}")
    public void deleteMagazin(@PathVariable("nume") String nume){
        magazineService.deleteMagazin(nume);
    }

    @GetMapping
    public List<Magazine> findMagazine(){
        return magazineService.findMagazine();
    }
}
