package com.testtask.task1.model;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum Role {

    ADMIN(1), USER(2), VIEWER(3);

    private static final Map<Integer, Role> ROLE_MAP;

    static {
        ROLE_MAP = Arrays.stream(Role.values())
                .collect(Collectors.toMap(Role::getNumber, role -> role));
    }

    private final int number;

    Role(int number) {
        this.number = number;
    }

    public static Role getByNumber(int number) {
        return ROLE_MAP.get(number);
    }

    public int getNumber() {
        return number;
    }

}
