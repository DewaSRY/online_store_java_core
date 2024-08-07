package org.sdewa.services.impl;

import org.sdewa.AppContext.Services;
import org.sdewa.entities.User;
import org.sdewa.services.UserManagement;

import java.util.Collections;
import java.util.List;

public class UserManagementServices implements UserManagement, Services {
    private static final String NOT_UNIQUE_EMAIL_ERROR_MESSAGE = "This email is already used by another user. Please, use another email";
    private static final String EMPTY_EMAIL_ERROR_MESSAGE = "You have to input email to register. Please, try one more time";
    private static final String NO_ERROR_MESSAGE = "";


    private final List<User> users;

    public UserManagementServices(List<User> users) {
        this.users = users;
    }

    @Override
    public String registerUser(User user) {
        if (!checkUniqueEmail(user.getEmail()).isEmpty()) {
            return NOT_UNIQUE_EMAIL_ERROR_MESSAGE;
        }
        users.add(user);
        return NO_ERROR_MESSAGE;
    }

    @Override
    public List<User> getUsers() {
        return Collections.unmodifiableList(users);
    }

    @Override
    public User getUserByEmail(String userEmail) {
        return users.stream().filter(u -> u.getEmail().equalsIgnoreCase(userEmail))
                .findFirst().orElse(null);
    }


    private String checkUniqueEmail(String email) {
        if (email == null || email.isEmpty()) {
            return EMPTY_EMAIL_ERROR_MESSAGE;
        }
        for (User user : users) {
            if (user != null
                    && user.getEmail() != null
                    && user.getEmail().equalsIgnoreCase(email)) {
                return NOT_UNIQUE_EMAIL_ERROR_MESSAGE;
            }
        }
        return NO_ERROR_MESSAGE;
    }
}
