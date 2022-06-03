package com.example.RezervariAppMaven.api;

import com.example.RezervariAppMaven.model.Users;
import com.example.RezervariAppMaven.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RequestMapping("users")
@RestController
public class ControllerUsers {
    private UsersService usersService;

    @Autowired
    public ControllerUsers(UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping
    public void addUser(@RequestBody Users user){
        usersService.addUser(user);
    }

    @PutMapping(path = "{username}")
    public void updateUser(@PathVariable("username") String username,@RequestBody Users user){
        usersService.updateUser(username,user);
    }

    @DeleteMapping(path = "{username}")
    public void deleteUser(@PathVariable("username") String username){
        usersService.deleteUser(username);
    }

    @GetMapping
    public List<Users> findUsers(){
        return usersService.findUsers();
    }
}
