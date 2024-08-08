package org.sdewa.menues;

import org.sdewa.AppContext.Menu;
import org.sdewa.entities.User;
import org.sdewa.entities.impl.UserDto;
import org.sdewa.services.impl.UserManagementServices;

public class SignUpMenu implements Menu {
    private UserManagementServices userManagement;


    @Override
    public void printMenu() {
        System.out.println("register menu");
    }

    @Override
    public void run() {
        var user = createUser();
        String registerResponse = userManagement.registerUser(user);
        if (!registerResponse.isEmpty()) {
            System.out.println(registerResponse);
        }


    }

    private User createUser() {
        var emailInput = getUserInput("insert your email");
        var firstNameInput = getUserInput("insert your first name");
        var lastNameInput = getUserInput("insert your last name");
        var passwordInput = getUserInput("insert your password");
        var user = new UserDto(
                firstNameInput, lastNameInput, passwordInput, emailInput
        );

        return user;
    }
}
