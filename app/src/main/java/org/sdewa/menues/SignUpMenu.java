package org.sdewa.menues;

import org.sdewa.AppContext.Context;
import org.sdewa.AppContext.Menu;
import org.sdewa.entities.User;
import org.sdewa.entities.impl.UserDto;
import org.sdewa.services.UserManagement;
import org.sdewa.services.impl.UserManagementServices;

public class SignUpMenu implements Menu {
    private final UserManagement userManagement;

    public SignUpMenu(Context context) {
        this.userManagement = context.getService(UserManagementServices.class);
    }

    @Override
    public String printMenu() {
        return printMenu("Register menu");
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
        return new UserDto(firstNameInput, lastNameInput, passwordInput, emailInput);

    }
}
