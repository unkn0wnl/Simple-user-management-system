package com.testtask.task1.dao;

import com.testtask.task1.exception.FileWhichContainsUsersListDoesntExistsException;
import com.testtask.task1.exception.UserListReadException;
import com.testtask.task1.exception.UserListWriteException;
import com.testtask.task1.model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;

public class FileUserDao implements UserDao {

    public static final String DEFAULT_FILE_NAME = "users.dat";
    public static final int INITIAL_VALUE = 0;

    private static AtomicLong idCounter;

    private static volatile FileUserDao instance;

    private List<User> userList;

    private FileUserDao() {
        userList = new CopyOnWriteArrayList<>();
        idCounter = new AtomicLong(INITIAL_VALUE);
    }

    public static FileUserDao getInstance() {
        FileUserDao localeInstance = instance;

        if (localeInstance == null) {
            synchronized (FileUserDao.class) {
                localeInstance = instance;

                if (localeInstance == null) {
                    instance = new FileUserDao();
                }
            }
        }
        return instance;
    }

    @Override
    public void addUser(User user) {
        user.setId(idCounter.getAndIncrement());
        userList.add(user);
        writeListToFile();
    }

    @Override
    public List<User> getAllUsers() {
        if (userList.isEmpty()) {
            readListFromFile();
        }
        return new ArrayList<>(userList);
    }

    @Override
    public Optional<User> getUserById(Long userId) {
        return userList
                .stream()
                .filter(user -> userId.equals(user.getId()))
                .findFirst();
    }

    @Override
    public void deleteUser(Long userId) {
        userList.removeIf(
                user -> userId.equals(user.getId())
        );
    }

    @Override
    public void updateUser(User user) {
        deleteUser(user.getId());
        userList.add(user);
        writeListToFile();
    }

    private void writeListToFile() {
        try (FileOutputStream fileOutputStream = new FileOutputStream(DEFAULT_FILE_NAME);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(userList);
            objectOutputStream.writeLong(idCounter.longValue());
        } catch (IOException exception) {
            throw new UserListWriteException(exception);
        }
    }

    private void readListFromFile() {
        if (!checkExistsFile()) {
            throw new FileWhichContainsUsersListDoesntExistsException();
        }

        try (FileInputStream fileInputStream = new FileInputStream(DEFAULT_FILE_NAME);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            userList = (CopyOnWriteArrayList) objectInputStream.readObject();
            idCounter.set(objectInputStream.readLong());
        } catch (IOException | ClassNotFoundException exception) {
            throw new UserListReadException(exception);
        }
    }

    private boolean checkExistsFile() {
        return new File(DEFAULT_FILE_NAME).exists();
    }
}
