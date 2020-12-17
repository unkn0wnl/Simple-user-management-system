package com.testtask.task1.cli.action.mainmenu;

import com.testtask.task1.cli.action.util.Constants;
import com.testtask.task1.model.Role;
import com.testtask.task1.model.User;
import com.testtask.task1.service.UserService;
import com.testtask.task1.service.UserServiceImpl;
import io.bretty.console.view.ActionView;

import java.util.Arrays;
import java.util.Set;

import static com.testtask.task1.cli.action.util.Utils.parseUserRoles;
import static com.testtask.task1.cli.action.util.Validators.*;

public class CreateNewUserAction extends ActionView {

    private UserService userService;

    public CreateNewUserAction(String runningTitle, String nameInParentMenu) {
        super(runningTitle, nameInParentMenu);
        userService = UserServiceImpl.getInstance();
    }

    private String[] inputPhoneNumbers(final int upperLimit) {
        final String[] phoneNumbers = new String[upperLimit];

        int i = Constants.LOWER_NUMBER_LIMIT;
        while (i < upperLimit) {
            String phoneNumber = prompt(String.format("Phone number #%d: ", i + 1), String.class, numberValidator);
            phoneNumbers[i] = phoneNumber;
            i++;
        }
        return phoneNumbers;
    }

    @Override
    public void executeCustomAction() {
        String firstName = prompt("Enter your first name: ", String.class, nameValidator);
        String surname = prompt("Enter your surname: ", String.class, nameValidator);
        String email = prompt("Enter your e-mail: ", String.class, emailValidator);
        int phonesCount = prompt("How many phone numbers you want to input (1-3): ", Integer.class, numberRangeValidator);
        String[] phoneNumbers = inputPhoneNumbers(phonesCount);
        String roles = prompt(String.format("Select role %s (eg: \"1 2 3\"): ", Arrays.toString(Role.values())), String.class, roleValidator);
        Set<Role> userRoles = parseUserRoles(roles);

        User newUser = new User(firstName, surname, email, Arrays.asList(phoneNumbers), userRoles);
        userService.saveUser(newUser);
    }
}
