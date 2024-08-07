package org.sdewa.menues;

import org.sdewa.AppContext.Menu;
import org.sdewa.services.AuthManagement;
import org.sdewa.services.OrderManagement;

public class CheckoutMenu implements Menu {

    private final OrderManagement orderManagement;
    private final AuthManagement authManagement;


    public CheckoutMenu(OrderManagement orderManagement, AuthManagement authManagement) {
        this.orderManagement = orderManagement;
        this.authManagement = authManagement;
    }

    @Override
    public void printMenu() {
        System.out.println("list of your order");
    }

    @Override
    public void run() {
        var currentAuthUser = authManagement.getCurrentLoginUser();
        var orderList = orderManagement.getOrderByUserId(currentAuthUser.getId());
        for (int i = 0; i < orderList.size(); i++) {
            System.out.printf("(%d) %s", i, orderList.get(i));
        }
    }
}
