package com.example.RezervariAppMaven.dao;

import com.example.RezervariAppMaven.model.Magazine;
import com.example.RezervariAppMaven.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MagazineData implements MagazineDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void insert(Magazine magazin) {
        String sql = "INSERT INTO magazine (nume, rating) VALUES (?,?)";

        jdbcTemplate.update(sql,magazin.getNume(),magazin.getRating());
    }

    @Override
    public void update(String nume, Magazine magazin) {
        String sql = "UPDATE magazine SET nume = ?, rating = ?" +  " WHERE (nume = ?)";

        jdbcTemplate.update(sql,magazin.getNume(),magazin.getRating(),nume);
    }

    @Override
    public void delete(String nume) {

        String sql = "DELETE FROM magazine WHERE (nume = ?)";

        jdbcTemplate.update(sql,nume);
    }

    @Override
    public List<Magazine> selectAll() {
        String sql = "SELECT * FROM magazine";

        List<Magazine> magazine = jdbcTemplate.query(
                sql,
                (rs, rowNum) ->
                        new Magazine(Integer.parseInt(rs.getString("id")),
                                rs.getString("nume"),
                                Integer.parseInt(rs.getString("rating")))
        );

        return magazine;
    }
}
