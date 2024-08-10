package org.sdewa.menues;

import org.sdewa.AppContext.Context;
import org.sdewa.AppContext.Menu;
import org.sdewa.AppContext.MenuInteractive;
import org.sdewa.services.AuthManagement;
import org.sdewa.services.OrderManagement;
import org.sdewa.services.impl.AuthManagementServices;
import org.sdewa.services.impl.OrderManagementService;

public class CheckoutMenu implements Menu, MenuInteractive {

    private final OrderManagement orderManagement;
    private final AuthManagement authManagement;

    public CheckoutMenu(Context context) {
        this.orderManagement = context.<OrderManagementService>getService(OrderManagementService.class);
        this.authManagement = context.<AuthManagementServices>getService(AuthManagementServices.class);
    }

    @Override
    public String printMenu() {
        return printMenu("List product on your chart");
    }

    @Override
    public boolean runSelectedMenu(String userInput) {
        return false;
    }

    @Override
    public boolean runSelectedMenu() {
        var currentAuthUser = authManagement.getCurrentLoginUser();
        if (currentAuthUser == null) {
            System.out.println("your are not login");
            return false;
        }
        var orderList = orderManagement.getOrderByUserId(currentAuthUser.getId());
        for (int i = 0; i < orderList.size(); i++) {
            System.out.printf("(%d) %s", i, orderList.get(i));
        }
        return false;
    }

}
