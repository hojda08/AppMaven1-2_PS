package com.example.RezervariAppMaven.dao;


import com.example.RezervariAppMaven.model.Users;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UsersDAO {
    void insert(Users user);
    void update(String username,Users user);
    void delete(String username);
    List<Users> selectAll();
}
