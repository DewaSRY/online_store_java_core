package org.sdewa.menues;


import org.sdewa.AppContext.Context;
import org.sdewa.AppContext.Menu;
import org.sdewa.AppContext.MenuInteractive;
import org.sdewa.services.AuthManagement;
import org.sdewa.services.impl.AuthManagementServices;

public class ChangeEmailMenu implements Menu, MenuInteractive {

    private final AuthManagement authManagement;

    public ChangeEmailMenu(Context context) {
        this.authManagement = context.<AuthManagementServices>getService(AuthManagementServices.class);
    }


    @Override
    public String printMenu() {
        return printMenu("Change Email");
    }

    @Override
    public boolean runSelectedMenu(String newEmail) {
        var currentUserLogin = authManagement.getCurrentLoginUser();
        if (currentUserLogin != null) {
            currentUserLogin.setEmail(newEmail);
        } else {
            System.out.println("you are not login");
        }
        return false;
    }

    @Override
    public boolean runSelectedMenu() {
        String newEmail = getUserInput("Insert new Email");
        return runSelectedMenu(newEmail);
    }
    
}
