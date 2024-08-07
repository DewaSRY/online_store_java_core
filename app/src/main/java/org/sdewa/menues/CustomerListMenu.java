package org.sdewa.menues;

import org.sdewa.AppContext.Menu;
import org.sdewa.entities.User;
import org.sdewa.services.UserManagement;

public class CustomerListMenu implements Menu {

    private final UserManagement userManagement;

    public CustomerListMenu(UserManagement userManagement) {
        this.userManagement = userManagement;
    }

    @Override
    public void printMenu() {
        System.out.println("This is list of user registered");
    }

    @Override
    public void run() {
        var userList = userManagement.getUsers();
        for (int idx = 0; idx < userList.size(); idx++) {
            System.out.printf("(%d) %s%n", idx, userList.get(idx).getFirstName());
        }
    }
}
