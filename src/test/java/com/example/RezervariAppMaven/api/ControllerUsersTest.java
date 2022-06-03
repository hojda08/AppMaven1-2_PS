package com.example.RezervariAppMaven.api;

import com.example.RezervariAppMaven.model.Users;
import com.example.RezervariAppMaven.service.UsersService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.nio.channels.UnresolvedAddressException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ControllerUsersTest {

    ControllerUsers controllerUsers;

    UsersService usersService;

//    @BeforeAll
//    void init(){
//        usersService = Mockito.mock(UsersService.class);
//       controllerUsers = new ControllerUsers(usersService);
//    }

    @Test
    void addUser() {
        Users expectedUser = new Users("user","user");
        usersService = Mockito.mock(UsersService.class);
        controllerUsers = new ControllerUsers(usersService);

        controllerUsers.addUser(expectedUser);
//        List<Users> users = controllerUsers.findUsers();
//
//        Users user = new Users("user","user");
//
//        assertTrue(users.contains(user));

        verify(usersService).addUser(expectedUser);
    }

    @Test
    void findUsersTest() {
        usersService = Mockito.mock(UsersService.class);
        controllerUsers = new ControllerUsers(usersService);
        when(usersService.findUsers()).thenReturn(new ArrayList<>());

        List<Users> list = controllerUsers.findUsers();
        verify(usersService).findUsers();
        assertTrue(list.size() == 0);
    }

    @Test
    void updateUser() {
        usersService = Mockito.mock(UsersService.class);
        controllerUsers = new ControllerUsers(usersService);

        controllerUsers.updateUser("user2",new Users("newuser","newuser"));

        List<Users> users = controllerUsers.findUsers();

        assertTrue(users.contains(new Users("newuser","newuser")));
    }

    @Test
    void deleteUser() {
        usersService = Mockito.mock(UsersService.class);
        controllerUsers = new ControllerUsers(usersService);

        controllerUsers.deleteUser("usernou");

        List<Users> users = controllerUsers.findUsers();

        assertFalse(users.contains(new Users("usernou","passnou")));
    }

    @Test
    void findUsers() {
        usersService = Mockito.mock(UsersService.class);
        controllerUsers = new ControllerUsers(usersService);

        List<Users> users = controllerUsers.findUsers();

        assertTrue(users.contains(new Users("user2","pass2")));
        assertTrue(users.contains(new Users("usernou","passnou")));
    }
}