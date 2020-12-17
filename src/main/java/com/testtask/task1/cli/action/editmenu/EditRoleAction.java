package com.testtask.task1.cli.action.editmenu;

import com.testtask.task1.dao.FileUserDao;
import com.testtask.task1.dao.UserDao;
import com.testtask.task1.model.Role;
import com.testtask.task1.model.User;
import io.bretty.console.view.ActionView;
import io.bretty.console.view.ViewConfig;

import java.util.Arrays;
import java.util.Set;

import static com.testtask.task1.cli.action.util.Utils.parseUserRoles;
import static com.testtask.task1.cli.action.util.Validators.roleValidator;

public class EditRoleAction extends ActionView {

    private User user;
    private UserDao userDao;

    public EditRoleAction(String runningTitle, String nameInParentMenu, User user) {
        super(runningTitle, nameInParentMenu);
        this.user = user;
        userDao = FileUserDao.getInstance();
    }

    public EditRoleAction(String runningTitle, String nameInParentMenu, ViewConfig viewConfig, User user) {
        super(runningTitle, nameInParentMenu, viewConfig);
        this.user = user;
        userDao = FileUserDao.getInstance();
    }

    @Override
    public void executeCustomAction() {
        print(String.format("Old roles: %s\n", user.getUserRole().toString()));
        String roles = prompt(String.format("Select role %s (eg: \"1 2 3\"): ", Arrays.toString(Role.values())), String.class, roleValidator);
        Set<Role> userRoles = parseUserRoles(roles);
        user.setUserRole(userRoles);
        userDao.updateUser(user);
    }

}
