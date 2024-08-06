package org.sdewa;

import java.util.ArrayList;
import java.util.List;


import org.sdewa.AppContext.Context;


import org.sdewa.entities.Product;
import org.sdewa.services.impl.OrderManagementService;
import org.sdewa.services.impl.UserManagementServices;
import org.sdewa.services.impl.ProductManagementService;

public class Main {


    public static void main(String[] args) {
        var context = Context.getInstance();
        context.putServices(new OrderManagementService(new ArrayList<>()));
        context.putServices(new UserManagementServices(new ArrayList<>()));
        context.putServices(new ProductManagementService(getInitProduct()));


    }


    private static List<Product> getInitProduct() {
        return new ArrayList<>();
    }
}