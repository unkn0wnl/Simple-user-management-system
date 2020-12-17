package com.testtask.task1;

import com.testtask.task1.cli.action.mainmenu.CreateNewUserAction;
import com.testtask.task1.cli.action.mainmenu.EditExistsUserAction;
import com.testtask.task1.cli.action.mainmenu.ViewAllUsersAction;
import io.bretty.console.view.MenuView;

public class ApplicationRunner {
    public static void main(String[] args) {
        MenuView rootMenu = new MenuView("User management system", "User management system");
        rootMenu.addMenuItem(new ViewAllUsersAction("User list", "View user list"));
        rootMenu.addMenuItem(new CreateNewUserAction("New user creation", "Create new user"));
        rootMenu.addMenuItem(new EditExistsUserAction("Edit user", "Edit exists user"));
        rootMenu.display();
    }
}
