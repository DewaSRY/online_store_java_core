package org.sdewa.menues;

import org.sdewa.AppContext.Context;
import org.sdewa.AppContext.Menu;
import org.sdewa.AppContext.MenuInteractive;
import org.sdewa.entities.User;

import org.sdewa.services.AuthManagement;
import org.sdewa.services.UserManagement;
import org.sdewa.services.impl.AuthManagementServices;
import org.sdewa.services.impl.UserManagementServices;


public class SignInMenu implements Menu, MenuInteractive {

    private final UserManagement userManagement;
    private final AuthManagement authManagement;

    public SignInMenu(Context context) {
        this.userManagement = context.<UserManagementServices>getService(UserManagementServices.class);
        this.authManagement = context.<AuthManagementServices>getService(AuthManagementServices.class);
    }

    @Override
    public String printMenu() {
        return printMenu("User Sing in Menu");
    }

    @Override
    public boolean runSelectedMenu(String userEmail) {
        User user = userManagement.getUserByEmail(userEmail);
        if (user == null) {
            System.out.printf("user with email %s is not register%n", userEmail);
        } else {
            authManagement.setCurrentUser(user);
            System.out.println("sign in success");
        }
        return false;
    }

    @Override
    public boolean runSelectedMenu() {
        String userEmail = getUserInput("insert your email");
        return runSelectedMenu(userEmail);
    }


}
