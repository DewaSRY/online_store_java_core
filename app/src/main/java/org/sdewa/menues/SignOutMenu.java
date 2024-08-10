package org.sdewa.menues;

import org.sdewa.AppContext.Context;
import org.sdewa.AppContext.Menu;
import org.sdewa.services.AuthManagement;
import org.sdewa.services.impl.AuthManagementServices;

public class SignOutMenu implements Menu {

    private final AuthManagement authManagement;

    public SignOutMenu(Context context) {
        this.authManagement = context.getService(AuthManagementServices.class);
    }

    @Override
    public String printMenu() {
        return printMenu("Sign out menu");
    }

    @Override
    public void run() {
        if (authManagement.getCurrentLoginUser() != null) {
            System.out.println("you are not log in");
        } else {
            authManagement.removeCurrentLoginUser();
            System.out.println("sing out success");
        }
    }
}
