package org.sdewa.menues;


import org.sdewa.AppContext.Context;
import org.sdewa.AppContext.Menu;
import org.sdewa.services.AuthManagement;
import org.sdewa.services.impl.AuthManagementServices;

public class ChangeEmailMenu implements Menu {

    private final AuthManagement authManagement;

    public ChangeEmailMenu(Context context) {
        this(context.<AuthManagement>getService(AuthManagementServices.class));
    }

    public ChangeEmailMenu(AuthManagement authManagement) {
        this.authManagement = authManagement;
    }

    @Override
    public void printMenu() {
        System.out.println("***** CHANGE EMAIL *****");
    }

    @Override
    public void run() {
        String newEmail = getUserInput("Insert new Email");
        var currentUserLogin = authManagement.getCurrentLoginUser();
        if (currentUserLogin != null) {
            currentUserLogin.setEmail(newEmail);
        } else {
            System.out.println("you are not login");
        }
    }
}
