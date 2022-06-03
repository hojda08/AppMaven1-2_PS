package com.example.RezervariAppMaven.dao;

import com.example.RezervariAppMaven.model.Comenzi;
import com.example.RezervariAppMaven.model.Magazine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ComenziData implements ComenziDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void insert(Comenzi comanda) {
        String sql = "INSERT INTO comenzi (numeProdus, username, cantitate) VALUES (?,?,?)";

        jdbcTemplate.update(sql,comanda.getNumeProdus(),comanda.getUsername(),comanda.getCantitate());
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM comenzi WHERE (id = ?)";

        jdbcTemplate.update(sql,id);
    }

    @Override
    public List<Comenzi> selectAll() {
        String sql = "SELECT * FROM comenzi";

        List<Comenzi> comenzi = jdbcTemplate.query(
                sql,
                (rs, rowNum) ->
                        new Comenzi(Integer.parseInt(rs.getString("id")),
                                rs.getString("numeProdus"),
                                rs.getString("username"),
                                Integer.parseInt(rs.getString("cantitate")))
        );

        return comenzi;
    }
}
