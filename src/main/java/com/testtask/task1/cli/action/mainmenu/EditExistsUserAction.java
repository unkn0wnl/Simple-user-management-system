package com.testtask.task1.cli.action.mainmenu;

import com.testtask.task1.cli.action.editmenu.EditEmailAction;
import com.testtask.task1.cli.action.editmenu.EditFirstNameAction;
import com.testtask.task1.cli.action.editmenu.EditRoleAction;
import com.testtask.task1.cli.action.editmenu.EditSurnameAction;
import com.testtask.task1.dao.FileUserDao;
import com.testtask.task1.dao.UserDao;
import com.testtask.task1.exception.FileWhichContainsUsersListDoesntExistsException;
import com.testtask.task1.exception.UserListReadException;
import com.testtask.task1.model.User;
import io.bretty.console.view.ActionView;
import io.bretty.console.view.MenuView;
import io.bretty.console.view.Validator;

public class EditExistsUserAction extends ActionView {

    private MenuView editSubMenu;
    private UserDao userService;
    private UserDao userDao;

    public EditExistsUserAction(String runningTitle, String nameInParentMenu) {
        super(runningTitle, nameInParentMenu);
        userDao = FileUserDao.getInstance();
        userService = FileUserDao.getInstance();
    }

    private void initSubMenu(User user) {
        editSubMenu = new MenuView("", "Choose what you want to change: ");
        editSubMenu.setParentView(this);
        editSubMenu.addMenuItem(new EditFirstNameAction("Edit first name", "Edit first name", user));
        editSubMenu.addMenuItem(new EditSurnameAction("Edit surname", "Edit surname", user));
        editSubMenu.addMenuItem(new EditEmailAction("Edit email", "Edit email", user));
        editSubMenu.addMenuItem(new EditRoleAction("Edit user role", "Edit user role", user));
    }

    private boolean printAllUsers() {
        boolean haveProblemsWithFile = false;
        try {
            userService.getAllUsers().forEach(this::println);
            print("\n");
        } catch (UserListReadException exception) {
            haveProblemsWithFile = true;
            print(exception.getMessage());
        } catch (FileWhichContainsUsersListDoesntExistsException exception) {
            haveProblemsWithFile = true;
            print("There are no users.");
        }
        return haveProblemsWithFile;
    }

    @Override
    public void executeCustomAction() {
        if (!printAllUsers()) {
            final Validator<Long> idValidator = id -> userDao
                    .getUserById(id)
                    .isPresent();
            long userId = prompt("Enter user ID you want to change: ", Long.class, idValidator);
            User user = userDao
                    .getUserById(userId).get();
            initSubMenu(user);
            editSubMenu.display();
        }
    }
}
