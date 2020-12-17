package com.testtask.task1.service;

import com.testtask.task1.dao.FileUserDao;
import com.testtask.task1.dao.UserDao;
import com.testtask.task1.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {

    private static volatile UserServiceImpl instance;

    private UserDao userDao;

    private UserServiceImpl() {
        userDao = FileUserDao.getInstance();
    }

    public static UserServiceImpl getInstance() {
        UserServiceImpl localeInstance = instance;

        if (localeInstance == null) {
            synchronized (UserServiceImpl.class) {
                localeInstance = instance;

                if (localeInstance == null) {
                    instance = new UserServiceImpl();
                }
            }
        }
        return instance;
    }

    @Override
    public void saveUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public void editUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

}