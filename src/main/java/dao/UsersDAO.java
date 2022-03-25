package dao;

import model.Users;

import java.util.List;

public interface UsersDAO {
    void insert(Users user);
    void update(String username,Users user);
    void delete(String username);
    List<Users> selectAll();
}
