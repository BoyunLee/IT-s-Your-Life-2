package com.example.teacher.dao;

import com.example.teacher.model.User;
import java.util.List;

public interface UserDao {
    void addUser(User user);
    void updateUser(User user);
    void deleteUser(int id);
    User getUser(int id);
    List<User> getAllUsers();
}