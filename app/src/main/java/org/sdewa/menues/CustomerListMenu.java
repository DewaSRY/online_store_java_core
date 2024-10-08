package org.sdewa.menues;

import com.sun.source.tree.BreakTree;
import org.sdewa.AppContext.Context;
import org.sdewa.AppContext.Menu;
import org.sdewa.AppContext.MenuInteractive;
import org.sdewa.services.UserManagement;
import org.sdewa.services.impl.UserManagementServices;

public class CustomerListMenu implements Menu, MenuInteractive {

    private final UserManagement userManagement;

    public CustomerListMenu(Context context) {
        this.userManagement = context.<UserManagementServices>getService(UserManagementServices.class);
    }

    @Override
    public String printMenu() {
        return printMenu("Our customer list");
    }

    @Override
    public boolean runSelectedMenu(String userInput) {
        return false;
    }

    @Override
    public boolean runSelectedMenu() {
        var userList = userManagement.getUsers();
        for (int idx = 0; idx < userList.size(); idx++) {
            System.out.printf("(%d) %s%n", idx, userList.get(idx).getFirstName());
        }
        return false;
    }


}
