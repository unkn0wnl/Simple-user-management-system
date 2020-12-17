package com.testtask.task1.service;

import com.testtask.task1.model.User;

import java.util.List;

public interface UserService {

    void saveUser(User user);

    void editUser(User user);

    List<User> getAllUsers();

}
