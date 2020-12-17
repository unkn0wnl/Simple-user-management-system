package com.testtask.task1.cli.action.util;

import io.bretty.console.view.Validator;

import java.util.Collections;
import java.util.List;

import static com.testtask.task1.cli.action.util.Constants.LOWER_NUMBER_LIMIT;
import static com.testtask.task1.cli.action.util.Constants.UPPER_NUMBER_LIMIT;

public interface Validators {

    String phoneNumberRegex = "^375(17|25|29|33|44) [0-9]{3}[0-9]{2}[0-9]{2}$";
    String emailRegex = "^[a-zA-Z0-9.]+@[a-zA-Z0-9.]+\\.[a-zA-Z]{2,4}";

    Validator<String> nameValidator = s -> s.length() > LOWER_NUMBER_LIMIT;
    Validator<Integer> numberRangeValidator = integer ->
            integer > LOWER_NUMBER_LIMIT && integer < UPPER_NUMBER_LIMIT;
    Validator<String> emailValidator = s -> s.matches(emailRegex);
    Validator<String> numberValidator = s -> s.matches(phoneNumberRegex);
    Validator<String> roleValidator = s -> {
        List<Integer> integerList = Utils.parseInt(s);
        return !integerList.equals(Collections.emptyList()) && !integerList.isEmpty();
    };
}
