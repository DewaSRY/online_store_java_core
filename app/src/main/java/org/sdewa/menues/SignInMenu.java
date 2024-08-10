package org.sdewa.menues;

import org.sdewa.AppContext.Context;
import org.sdewa.AppContext.Menu;
import org.sdewa.entities.User;

import org.sdewa.services.AuthManagement;
import org.sdewa.services.UserManagement;
import org.sdewa.services.impl.AuthManagementServices;
import org.sdewa.services.impl.UserManagementServices;


public class SignInMenu implements Menu {

    private final UserManagement userManagement;
    private final AuthManagement authManagement;

    public SignInMenu(Context context) {
        this.userManagement = context.getService(UserManagementServices.class);
        this.authManagement = context.getService(AuthManagementServices.class);
    }

    @Override
    public String printMenu() {
        return printMenu("User Sing in Menu");
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
