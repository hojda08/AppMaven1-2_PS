package com.example.RezervariAppMaven.service;

import com.example.RezervariAppMaven.dao.UsersData;
import com.example.RezervariAppMaven.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {

    private UsersData usersData;

    @Autowired
    public UsersService(UsersData usersData) {
        this.usersData = usersData;
    }

    public void addUser(Users user){
        usersData.insert(user);
    }

    public void updateUser(String username, Users user){
        usersData.update(username,user);
    }

    public void deleteUser(String username){
        usersData.delete(username);
    }

    public List<Users> findUsers(){
        return usersData.selectAll();
    }
}
