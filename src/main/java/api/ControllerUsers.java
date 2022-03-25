package api;

import model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.UsersService;

import java.util.List;

@RequestMapping("api/v1/user")
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

    @PostMapping
    public void updateUser(String username, Users user){
        usersService.updateUser(username,user);
    }

    @PostMapping
    public void deleteUser(String username){
        usersService.deleteUser(username);
    }

    @PostMapping
    public List<Users> findUsers(){
        return usersService.findUsers();
    }
}
