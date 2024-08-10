package org.sdewa.menues;

import org.sdewa.AppContext.Menu;
import org.sdewa.services.impl.AuthManagementServices;

public class ChangePasswordMenu implements Menu {
    private AuthManagementServices authManagement;

    @Override
    public void printMenu() {
        System.out.println("***** CHANGE EMAIL *****");

    }

    @Override
    public void run() {
        String newPassword = getUserInput("Insert new password");
        var currentUserLogin = authManagement.getCurrentLoginUser();
        if (currentUserLogin != null) {
            currentUserLogin.setPassword(newPassword);
        } else {
            System.out.println("you are not login");
        }
    }
}
