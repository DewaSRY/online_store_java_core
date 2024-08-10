package org.sdewa.menues;


import java.util.List;
import java.util.ArrayList;

import org.sdewa.AppContext.Context;
import org.sdewa.AppContext.Menu;
import org.sdewa.AppContext.MenuInteractive;
import org.sdewa.entities.Product;
import org.sdewa.entities.impl.OrderDto;
import org.sdewa.services.impl.AuthManagementServices;
import org.sdewa.services.impl.OrderManagementService;
import org.sdewa.services.impl.ProductManagementService;


public class ProductCatalogMenu implements Menu, MenuInteractive {
    private final ProductManagementService productManagement;
    private final OrderManagementService orderManagement;
    private final AuthManagementServices authManagement;


    public ProductCatalogMenu(Context context) {
        this.productManagement = context.<ProductManagementService>getService(ProductManagementService.class);
        this.orderManagement = context.<OrderManagementService>getService(OrderManagementService.class);
        this.authManagement = context.<AuthManagementServices>getService(AuthManagementServices.class);
    }

    @Override
    public String printMenu() {
        var productList = productManagement.getProducts();
        var productOption = new StringBuilder("This is lis of our product");
        for (int idx = 0; idx < productList.size(); idx++) {
            productOption.append("(%d) %s%n".formatted(idx, productList.get(idx)));
        }
        return productOption.toString();
    }

    @Override
    public boolean runSelectedMenu(String userInput) {
        var orderList = getInputIndexList(userInput);
        var currentuser = authManagement.getCurrentLoginUser();

        if (orderList.isEmpty()) {
            System.out.println("please insert correct input");
        }
        var ordes = new OrderDto();
        ordes.setProducts(getPorductList(orderList));
        ordes.setCustomerId(currentuser.getId());
        orderManagement.addOrder(ordes);
        return false;
    }

    @Override
    public boolean runSelectedMenu() {
        var currentuser = authManagement.getCurrentLoginUser();

        if (currentuser == null) {
            return false;
        }
        var userInput = getUserInput("input your order (separate by coma)");
        return runSelectedMenu(userInput);
    }


    private List<Product> getPorductList(List<Integer> oderIndexList) {
        List<Product> products = new ArrayList<>();
        for (var idx : oderIndexList) {
            products.add(productManagement.getProductById(idx));
        }
        return products;
    }


}
