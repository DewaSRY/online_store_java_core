package org.sdewa.menues;

import org.sdewa.AppContext.Context;
import org.sdewa.AppContext.Menu;
import org.sdewa.entities.User;
import org.sdewa.services.UserManagement;
import org.sdewa.services.impl.UserManagementServices;

public class CustomerListMenu implements Menu {

    private UserManagementServices userManagement;


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
