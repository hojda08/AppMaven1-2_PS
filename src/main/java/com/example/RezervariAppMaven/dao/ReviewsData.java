package com.example.RezervariAppMaven.dao;

import com.example.RezervariAppMaven.model.Magazine;
import com.example.RezervariAppMaven.model.Produse;
import com.example.RezervariAppMaven.model.Reviews;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReviewsData implements ReviewsDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void insert(Reviews review) {
        String sql = "INSERT INTO reviews (numeProdus, text, likes) VALUES (?,?,?)";

        jdbcTemplate.update(sql,review.getNumeProdus(),review.getText(),review.getLikes());
    }

    @Override
    public List<Reviews> selectAll() {
        String sql = "SELECT * FROM reviews";

        List<Reviews> reviews = jdbcTemplate.query(
                sql,
                (rs, rowNum) ->
                        new Reviews(Integer.parseInt(rs.getString("id")),
                                rs.getString("numeProdus"),
                                rs.getString("text"),
                                Integer.parseInt(rs.getString("likes")))
        );

        return reviews;
    }

    @Override
    public List<Reviews> selectAllByNumeProdus(String numeProdus) {
        String sql = "SELECT * FROM reviews WHERE (numeProdus = '" + numeProdus +"')";

        List<Reviews> reviews = jdbcTemplate.query(
                sql,
                (rs, rowNum) ->
                        new Reviews(Integer.parseInt(rs.getString("id")),
                                rs.getString("numeProdus"),
                                rs.getString("text"),
                                Integer.parseInt(rs.getString("likes")))
        );

        return reviews;
    }
}
