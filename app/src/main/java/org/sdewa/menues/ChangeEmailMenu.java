package org.sdewa.menues;


import org.sdewa.AppContext.Menu;
import org.sdewa.services.impl.AuthManagementServices;

public class ChangeEmailMenu implements Menu {

    private AuthManagementServices authManagement;


    @Override
    public void printMenu() {
        System.out.println("***** CHANGE EMAIL *****");
    }

    @Override
    public void run() {
        System.out.println(authManagement);
        String newEmail = getUserInput("Insert new Email");

        var currentUserLogin = authManagement.getCurrentLoginUser();
        if (currentUserLogin != null) {
            currentUserLogin.setEmail(newEmail);
        } else {
            System.out.println("you are not login");
        }
    }
}
