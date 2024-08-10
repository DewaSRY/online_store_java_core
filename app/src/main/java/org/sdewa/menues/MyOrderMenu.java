package org.sdewa.menues;

import org.sdewa.AppContext.Context;
import org.sdewa.AppContext.Menu;
import org.sdewa.AppContext.MenuInteractive;
import org.sdewa.entities.Product;
import org.sdewa.services.AuthManagement;
import org.sdewa.services.OrderManagement;
import org.sdewa.services.impl.AuthManagementServices;
import org.sdewa.services.impl.OrderManagementService;

import java.util.List;

public class MyOrderMenu implements Menu, MenuInteractive {

    private final AuthManagement authManagement;
    private final OrderManagement orderManagement;

    public MyOrderMenu(Context context) {
        this.authManagement = context.<AuthManagementServices>getService(AuthManagementServices.class);
        this.orderManagement = context.<OrderManagementService>getService(OrderManagementService.class);
    }

    @Override
    public String printMenu() {
        return printMenu("This is your order");
    }

    @Override
    public boolean runSelectedMenu(String userInput) {
        return false;
    }

    @Override
    public boolean runSelectedMenu() {
        var currentUser = authManagement.getCurrentLoginUser();
        if (currentUser == null) {
            System.out.println("please auth first");
            return false;
        }
        var orderList = orderManagement.getOrderByUserId(currentUser.getId());
        for (int idx = 0; idx < orderList.size(); idx++) {
            System.out.printf("order with id (%d)%n", idx);
            printOrderList(orderList.get(idx).getProductList());
        }
        return false;
    }


    private void printOrderList(List<Product> products) {
        for (int idx = 0; idx < products.size(); idx++) {
            System.out.printf("(%d) %s", idx, products.get(idx));
        }
    }
}
