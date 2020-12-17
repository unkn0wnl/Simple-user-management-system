package com.testtask.task1.cli.action.util;

import com.testtask.task1.model.Role;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.testtask.task1.cli.action.util.Constants.LOWER_NUMBER_LIMIT;
import static com.testtask.task1.cli.action.util.Constants.UPPER_NUMBER_LIMIT;

public class Utils {

    public static final String SPACE_CHARACTER = " ";

    public static Set<Role> parseUserRoles(String roles) {
        String[] splitedRoles = roles.split(SPACE_CHARACTER);
        List<Integer> collect = Arrays.stream(splitedRoles)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return collect
                .stream()
                .map(Role::getByNumber)
                .collect(Collectors.toSet());
    }

    public static List<Integer> parseInt(String line) {
        String[] split = line.split(SPACE_CHARACTER);
        List<Integer> numbers = null;
        try {
            numbers = Arrays
                    .stream(split)
                    .map(Integer::parseInt)
                    .filter(integer -> integer > LOWER_NUMBER_LIMIT
                            && integer < UPPER_NUMBER_LIMIT)
                    .collect(Collectors.toList());
        } catch (NumberFormatException exception) {
            numbers = Collections.emptyList();
        }
        return numbers;
    }

}
