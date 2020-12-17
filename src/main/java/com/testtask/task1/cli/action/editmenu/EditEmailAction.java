package com.testtask.task1.cli.action.editmenu;

import com.testtask.task1.dao.FileUserDao;
import com.testtask.task1.dao.UserDao;
import com.testtask.task1.model.User;
import io.bretty.console.view.ActionView;
import io.bretty.console.view.ViewConfig;

public class EditEmailAction extends ActionView {

    private User user;
    private UserDao userDao;

    public EditEmailAction(String runningTitle, String nameInParentMenu, User user) {
        super(runningTitle, nameInParentMenu);
        this.user = user;
        userDao = FileUserDao.getInstance();
    }

    public EditEmailAction(String runningTitle, String nameInParentMenu, ViewConfig viewConfig, User user) {
        super(runningTitle, nameInParentMenu, viewConfig);
        this.user = user;
        userDao = FileUserDao.getInstance();
    }

    @Override
    public void executeCustomAction() {
        print(String.format("Old email: %s\n", user.getEmail()));
        String newUserEmail = prompt("Enter new email: ", String.class);
        user.setEmail(newUserEmail);
        userDao.updateUser(user);
    }
}
