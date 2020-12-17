package com.testtask.task1.cli.action.editmenu;

import com.testtask.task1.dao.FileUserDao;
import com.testtask.task1.dao.UserDao;
import com.testtask.task1.model.User;
import io.bretty.console.view.ActionView;
import io.bretty.console.view.ViewConfig;

import static com.testtask.task1.cli.action.util.Validators.nameValidator;

public class EditSurnameAction extends ActionView {

    private User user;
    private UserDao userDao;

    public EditSurnameAction(String runningTitle, String nameInParentMenu, User user) {
        super(runningTitle, nameInParentMenu);
        this.user = user;
        userDao = FileUserDao.getInstance();
    }

    public EditSurnameAction(String runningTitle, String nameInParentMenu, ViewConfig viewConfig, User user) {
        super(runningTitle, nameInParentMenu, viewConfig);
        this.user = user;
        userDao = FileUserDao.getInstance();
    }

    @Override
    public void executeCustomAction() {
        print(String.format("Old surname: %s\n", user.getSurname()));
        String newUserSurname = prompt("Enter new surname: ", String.class, nameValidator);
        user.setSurname(newUserSurname);
        userDao.updateUser(user);
    }

}
