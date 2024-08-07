package org.sdewa.entities.impl;

import org.sdewa.entities.User;

public class UserDto implements User {
    private static int userCounter = 0;

    private int id;
    private String firstName;
    private String lastName;
    private String password;
    private String email;

    {
        id = ++userCounter;
    }

    @Override
    public String getFirstName() {
        return "";
    }

    @Override
    public String getLastName() {
        return "";
    }

    @Override
    public String getPassword() {
        return "";
    }

    @Override
    public String getEmail() {
        return "";
    }

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public void setPassword(String newPassword) {

    }

    @Override
    public void setEmail(String newEmail) {

    }
}
