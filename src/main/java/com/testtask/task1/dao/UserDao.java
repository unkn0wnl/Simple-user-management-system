package com.testtask.task1.dao;

import com.testtask.task1.model.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {

    void addUser(User user);

    Optional<User> getUserById(Long userId);

    List<User> getAllUsers();

    void deleteUser(Long userId);

    void updateUser(User user);

}
