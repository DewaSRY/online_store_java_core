package org.sdewa.menues;


import org.sdewa.AppContext.Context;
import org.sdewa.AppContext.Menu;
import org.sdewa.services.AuthManagement;
import org.sdewa.services.impl.AuthManagementServices;
import org.sdewa.services.impl.OrderManagementService;

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
