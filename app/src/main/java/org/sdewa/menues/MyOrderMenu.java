package org.sdewa.menues;

import org.sdewa.AppContext.Menu;
import org.sdewa.entities.Product;
import org.sdewa.entities.User;
import org.sdewa.services.impl.AuthManagementServices;
import org.sdewa.services.impl.OrderManagementService;

import java.util.List;

public class MyOrderMenu implements Menu {
    
    private AuthManagementServices authManagement;
    private OrderManagementService orderManagement;

    @Override
    public void printMenu() {
        System.out.println("This is your order");
    }

    @Override
    public void run() {

        var currentUser = getUser();
        if (currentUser == null) return;
        var orderList = orderManagement.getOrderByUserId(currentUser.getId());

        for (int idx = 0; idx < orderList.size(); idx++) {
            System.out.printf("order with id (%d)%n", idx);
            printOrderList(orderList.get(idx).getProductList());
        }
    }

    private User getUser() {
        var currentUser = authManagement.getCurrentLoginUser();
        if (currentUser == null) {
            System.out.println("please auth first");
        }
        return currentUser;
    }

    private void printOrderList(List<Product> products) {
        for (int idx = 0; idx < products.size(); idx++) {
            System.out.printf("(%d) %s", idx, products.get(idx));
        }
    }
}
