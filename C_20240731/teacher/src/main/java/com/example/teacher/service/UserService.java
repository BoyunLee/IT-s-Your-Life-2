package com.example.teacher.service;

import com.example.teacher.model.User;
import java.util.List;

public interface UserService {
    void addUser(User user);
    void updateUser(User user);
    void deleteUser(int id);
    User getUser(int id);
    List<User> getAllUsers();
}
