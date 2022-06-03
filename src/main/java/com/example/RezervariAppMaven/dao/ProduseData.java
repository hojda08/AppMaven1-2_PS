package com.example.RezervariAppMaven.dao;

import com.example.RezervariAppMaven.model.Magazine;
import com.example.RezervariAppMaven.model.Produse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProduseData implements ProduseDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void insert(Produse produs) {
        String sql = "INSERT INTO produse (numeProdus, cantitate, numeMagazin, pret) VALUES (?,?,?,?)";

        jdbcTemplate.update(sql,produs.getNumeProdus(),produs.getCantitate(),produs.getNumeMagazin(),
                produs.getPret());
    }

    @Override
    public void update(String numeProdus, Produse produs) {
        String sql = "UPDATE produse SET numeProdus = ?, cantitate = ?, numeMagazin = ?, pret = ?" +  " WHERE (numeProdus = ?)";

        jdbcTemplate.update(sql,produs.getNumeProdus(), produs.getCantitate(), produs.getNumeMagazin(),
                            produs.getPret(),numeProdus);
    }

    @Override
    public void delete(String numeProdus) {
        String sql = "DELETE FROM produse WHERE (numeProdus = ?)";

        jdbcTemplate.update(sql,numeProdus);
    }

    @Override
    public List<Produse> selectAll() {
        String sql = "SELECT * FROM produse";

        List<Produse> produse = jdbcTemplate.query(
                sql,
                (rs, rowNum) ->
                        new Produse(Integer.parseInt(rs.getString("id")),
                                rs.getString("numeProdus"),
                                Integer.parseInt(rs.getString("cantitate")),
                                rs.getString("numeMagazin"),
                                Integer.parseInt(rs.getString("pret")))
        );

        return produse;
    }

    @Override
    public List<Produse> selectAllByNumeMagazin(String numeMagazin) {
        String sql = "SELECT * FROM produse WHERE (numeMagazin = '" + numeMagazin +"')";

        List<Produse> produse = jdbcTemplate.query(
                sql,
                (rs, rowNum) ->
                        new Produse(Integer.parseInt(rs.getString("id")),
                                rs.getString("numeProdus"),
                                Integer.parseInt(rs.getString("cantitate")),
                                rs.getString("numeMagazin"),
                                Integer.parseInt(rs.getString("pret")))
        );

        return produse;
    }
}
