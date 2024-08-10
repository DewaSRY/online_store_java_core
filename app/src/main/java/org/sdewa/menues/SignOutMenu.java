package org.sdewa.menues;

import org.sdewa.AppContext.Context;
import org.sdewa.AppContext.Menu;
import org.sdewa.AppContext.MenuInteractive;
import org.sdewa.services.AuthManagement;
import org.sdewa.services.impl.AuthManagementServices;

public class SignOutMenu implements Menu, MenuInteractive {

    private final AuthManagement authManagement;

    public SignOutMenu(Context context) {
        this.authManagement = context.<AuthManagementServices>getService(AuthManagementServices.class);
    }

    @Override
    public String printMenu() {
        return printMenu("Sign out menu");
    }

    @Override
    public boolean runSelectedMenu(String userInput) {
        return false;
    }

    @Override
    public boolean runSelectedMenu() {
        if (authManagement.getCurrentLoginUser() != null) {
            System.out.println("you are not log in");
        } else {
            authManagement.removeCurrentLoginUser();
            System.out.println("sing out success");
        }
        return false;
    }


}
