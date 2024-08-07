package org.sdewa.menues;

import org.sdewa.AppContext.Menu;
import org.sdewa.services.AuthManagement;

public class SignOutMenu implements Menu {

    private final AuthManagement authManagement;

    public SignOutMenu(AuthManagement authManagement) {
        this.authManagement = authManagement;
    }

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
