package org.sdewa.menues;

import org.sdewa.AppContext.Context;
import org.sdewa.AppContext.Menu;
import org.sdewa.services.AuthManagement;
import org.sdewa.services.impl.AuthManagementServices;

public class ChangePasswordMenu implements Menu {
    private final AuthManagement authManagement;

    public ChangePasswordMenu(Context context) {
        this(context.<AuthManagement>getService(AuthManagementServices.class));
    }

    public ChangePasswordMenu(AuthManagement authManagement) {
        this.authManagement = authManagement;
    }

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
