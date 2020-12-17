package com.testtask.task1.cli.action.mainmenu;

import com.testtask.task1.exception.FileWhichContainsUsersListDoesntExistsException;
import com.testtask.task1.exception.UserListReadException;
import com.testtask.task1.service.UserService;
import com.testtask.task1.service.UserServiceImpl;
import io.bretty.console.view.ActionView;
import io.bretty.console.view.ViewConfig;

public class ViewAllUsersAction extends ActionView {

    private UserService userService;

    public ViewAllUsersAction(String runningTitle, String nameInParentMenu) {
        super(runningTitle, nameInParentMenu);
        userService = UserServiceImpl.getInstance();
    }

    public ViewAllUsersAction(String runningTitle, String nameInParentMenu, ViewConfig viewConfig) {
        super(runningTitle, nameInParentMenu, viewConfig);
        userService = UserServiceImpl.getInstance();
    }

    @Override
    public void executeCustomAction() {
        try {
            userService.getAllUsers().forEach(this::println);
        } catch (UserListReadException exception) {
            print(exception.getMessage());
        } catch (FileWhichContainsUsersListDoesntExistsException exception) {
            print("There are no users.");
        }
    }
}
