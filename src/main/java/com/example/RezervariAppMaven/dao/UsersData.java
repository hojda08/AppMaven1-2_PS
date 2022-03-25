package com.example.RezervariAppMaven.dao;

import com.example.RezervariAppMaven.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UsersData implements UsersDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void insert(Users user) {
        // INSERT INTO users (username, password) VALUES ('fgjt', 'hyju')
        String sql = "INSERT INTO users (username, password) VALUES ('" +
                      user.getUsername() + "', '" + user.getPassword() + "')";

        jdbcTemplate.update(sql);
    }

    @Override
    public void update(String username, Users user) {
        //UPDATE users SET username = 'usermodif', password = 'passm' WHERE (username = 'fgjt')
        String sql = "UPDATE users SET username = '" + user.getUsername() + "', password = '"
                    + user.getPassword() + "'" +  " WHERE (username = '" + username + "')";

        jdbcTemplate.update(sql);
    }

    @Override
    public void delete(String username) {
        //DELETE FROM users WHERE (username = 'usermodif')
        String sql = "DELETE FROM users WHERE (username = '" + username + "')";
        jdbcTemplate.update(sql);
    }

    @Override
    public List<Users> selectAll() {
        String sql = "SELECT * FROM users";

        List<Users> users = jdbcTemplate.query(
                sql,
                (rs, rowNum) ->
                        new Users(rs.getString("username"),
                                rs.getString("password"))
        );

        return users;
    }
}
