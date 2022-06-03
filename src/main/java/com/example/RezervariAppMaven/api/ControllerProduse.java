package com.example.RezervariAppMaven.api;

import com.example.RezervariAppMaven.model.Magazine;
import com.example.RezervariAppMaven.model.Produse;
import com.example.RezervariAppMaven.service.MagazineService;
import com.example.RezervariAppMaven.service.ProduseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("produse")
@RestController
public class ControllerProduse {

    private ProduseService produseService;

    @Autowired
    public ControllerProduse(ProduseService produseService) {
        this.produseService = produseService;
    }

    @PostMapping
    public void addProdus(@RequestBody Produse produs){
        produseService.addProdus(produs);
    }

    @PutMapping(path = "{numeProdus}")
    public void updateMagazin(@PathVariable("numeProdus") String numeProdus,@RequestBody Produse produs){
        produseService.updateProdus(numeProdus,produs);
    }

    @DeleteMapping(path = "{numeProdus}")
    public void deleteProdus(@PathVariable("numeProdus") String numeProdus){
        produseService.deleteProdus(numeProdus);
    }

    @GetMapping
    public List<Produse> findProduse(){
        return produseService.findProduse();
    }

    @GetMapping(path = "{numeMagazin}")
    public List<Produse> findProduseByNumeMagazin(@PathVariable("numeMagazin") String numeMagazin){
        return produseService.findProduseByMagazin(numeMagazin);
    }

}
