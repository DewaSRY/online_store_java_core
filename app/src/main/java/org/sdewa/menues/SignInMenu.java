package org.sdewa.menues;

import org.sdewa.AppContext.Menu;
import org.sdewa.entities.User;

import org.sdewa.services.impl.AuthManagementServices;
import org.sdewa.services.impl.UserManagementServices;


public class SignInMenu implements Menu {

    private UserManagementServices userManagement;
    private AuthManagementServices authManagement;

    @Override
    public void printMenu() {
        System.out.println("User Sing in menu");
    }

    @Override
    public void run() {
        String userEmail = getUserInput("insert your email");
        User user = userManagement.getUserByEmail(userEmail);
        if (user == null) {
            System.out.printf("user with email %s is not register%n", userEmail);
        } else {
            authManagement.setCurrentUser(user);
            System.out.println("sign in success");
        }
    }

}
