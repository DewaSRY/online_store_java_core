package org.sdewa.menues;

import org.sdewa.AppContext.Context;
import org.sdewa.AppContext.Menu;
import org.sdewa.AppContext.MenuInteractive;
import org.sdewa.services.AuthManagement;
import org.sdewa.services.impl.AuthManagementServices;

public class ChangePasswordMenu implements Menu, MenuInteractive {
    private final AuthManagement authManagement;

    public ChangePasswordMenu(Context context) {
        this.authManagement = context.<AuthManagementServices>getService(AuthManagementServices.class);
    }

    @Override
    public String printMenu() {
        return printMenu("Change Email");
    }

    @Override
    public boolean runSelectedMenu(String newPassword) {
        var currentUserLogin = authManagement.getCurrentLoginUser();
        if (currentUserLogin != null) {
            currentUserLogin.setPassword(newPassword);
        } else {
            System.out.println("you are not login");
        }
        return false;
    }

    @Override
    public boolean runSelectedMenu() {
        String newPassword = getUserInput("Insert new password");
        return runSelectedMenu(newPassword);
    }


}
