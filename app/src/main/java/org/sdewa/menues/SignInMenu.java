package org.sdewa.menues;

import org.sdewa.AppContext.Menu;
import org.sdewa.entities.User;
import org.sdewa.services.AuthManagement;
import org.sdewa.services.UserManagement;

public class SignInMenu implements Menu {

    private final UserManagement userManagement;
    private final AuthManagement authManagement;

    public SignInMenu(UserManagement userManagement, AuthManagement authManagement) {
        this.userManagement = userManagement;
        this.authManagement = authManagement;
    }

    @Override
    public void printMenu() {
        System.out.println("User Sing in menu");
    }

    @Override
    public void run() {
        String userEmail = getUserInput("insert your email");
        User user = userManagement.getUserByEmail(userEmail);
        if (user == null) {
            System.out.printf("user with email %s is not register%d", userEmail);
        } else {
            authManagement.setCurrentUser(user);
            System.out.println("sign in success");
        }
    }
    
}
