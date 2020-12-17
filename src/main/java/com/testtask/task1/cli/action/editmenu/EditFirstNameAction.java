package com.testtask.task1.cli.action.editmenu;

import com.testtask.task1.dao.FileUserDao;
import com.testtask.task1.dao.UserDao;
import com.testtask.task1.model.User;
import io.bretty.console.view.ActionView;
import io.bretty.console.view.ViewConfig;

import static com.testtask.task1.cli.action.util.Validators.nameValidator;

public class EditFirstNameAction extends ActionView {

    private User user;
    private UserDao userDao;

    public EditFirstNameAction(String runningTitle, String nameInParentMenu, User user) {
        super(runningTitle, nameInParentMenu);
        this.user = user;
        userDao = FileUserDao.getInstance();
    }

    public EditFirstNameAction(String runningTitle, String nameInParentMenu, ViewConfig viewConfig, User user) {
        super(runningTitle, nameInParentMenu, viewConfig);
        this.user = user;
        userDao = FileUserDao.getInstance();
    }

    @Override
    public void executeCustomAction() {
        print(String.format("Old first name: %s\n", user.getFirstName()));
        String newUserFirstName = prompt("Enter new first name: ", String.class, nameValidator);
        user.setFirstName(newUserFirstName);
        userDao.updateUser(user);
    }
}
