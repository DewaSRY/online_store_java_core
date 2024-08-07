package org.sdewa.menues;

import org.sdewa.AppContext.Menu;
import org.sdewa.entities.Product;
import org.sdewa.entities.User;
import org.sdewa.services.AuthManagement;
import org.sdewa.services.OrderManagement;

import java.util.List;

public class MyOrderMenu implements Menu {


    private final AuthManagement authManagement;
    private final OrderManagement orderManagement;

    public MyOrderMenu(AuthManagement authManagement, OrderManagement orderManagement) {
        this.authManagement = authManagement;
        this.orderManagement = orderManagement;
    }

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
