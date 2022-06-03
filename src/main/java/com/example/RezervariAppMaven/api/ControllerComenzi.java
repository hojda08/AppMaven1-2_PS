package com.example.RezervariAppMaven.api;

import com.example.RezervariAppMaven.model.Comenzi;
import com.example.RezervariAppMaven.model.Magazine;
import com.example.RezervariAppMaven.service.ComenziService;
import com.example.RezervariAppMaven.service.MagazineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("comenzi")
@RestController
public class ControllerComenzi {
    private ComenziService comenziService;

    @Autowired
    public ControllerComenzi(ComenziService comenziService) {
        this.comenziService = comenziService;
    }

    @PostMapping
    public void addComanda(@RequestBody Comenzi comanda){
        comenziService.addComanda(comanda);
    }

    @DeleteMapping(path = "{id}")
    public void deleteComanda(@PathVariable("id") int id){
        comenziService.deleteComanda(id);
    }

    @GetMapping
    public List<Comenzi> findComenzi(){
        return comenziService.findComenzi();
    }
}
