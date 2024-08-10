package org.sdewa.menues;

import org.sdewa.AppContext.Context;
import org.sdewa.AppContext.Menu;
import org.sdewa.services.AuthManagement;
import org.sdewa.services.OrderManagement;
import org.sdewa.services.impl.AuthManagementServices;
import org.sdewa.services.impl.OrderManagementService;

public class CheckoutMenu implements Menu {

    private OrderManagement orderManagement;
    private AuthManagement authManagement;

    public CheckoutMenu(Context context) {
        this.orderManagement = context.getService(OrderManagementService.class);
        this.orderManagement = context.getService(AuthManagementServices.class);
    }

    @Override
    public String printMenu() {
        return printMenu("List product on your chart");
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
