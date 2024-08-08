package org.sdewa.menues;

import org.sdewa.AppContext.Menu;
import org.sdewa.services.impl.AuthManagementServices;

public class SignOutMenu implements Menu {

    private AuthManagementServices authManagement;


    @Override
    public void printMenu() {
        System.out.println("sign out menu");
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
