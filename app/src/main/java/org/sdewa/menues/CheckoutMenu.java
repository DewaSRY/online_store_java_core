package org.sdewa.menues;

import org.sdewa.AppContext.Context;
import org.sdewa.AppContext.Menu;
import org.sdewa.services.AuthManagement;
import org.sdewa.services.OrderManagement;
import org.sdewa.services.impl.AuthManagementServices;
import org.sdewa.services.impl.OrderManagementService;

public class CheckoutMenu implements Menu {

    private OrderManagementService orderManagement;
    private AuthManagementServices authManagement;


    @Override
    public void printMenu() {
        System.out.println("list of your order");
    }

    @Override
    public void run() {
        var currentAuthUser = authManagement.getCurrentLoginUser();
        if (currentAuthUser == null) {
            System.out.println("your are not login");
            return;
        }
        var orderList = orderManagement.getOrderByUserId(currentAuthUser.getId());
        for (int i = 0; i < orderList.size(); i++) {
            System.out.printf("(%d) %s", i, orderList.get(i));
        }
    }
}
