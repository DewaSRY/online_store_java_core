package org.sdewa.menues;


import java.util.List;
import java.util.ArrayList;

import org.sdewa.AppContext.Context;
import org.sdewa.AppContext.Menu;
import org.sdewa.entities.Product;
import org.sdewa.entities.impl.OrderDto;
import org.sdewa.services.AuthManagement;
import org.sdewa.services.OrderManagement;
import org.sdewa.services.ProductManagement;
import org.sdewa.services.impl.AuthManagementServices;
import org.sdewa.services.impl.OrderManagementService;
import org.sdewa.services.impl.ProductManagementService;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProductCatalogMenu implements Menu {
    private final ProductManagement productManagement;
    private final OrderManagement orderManagement;
    private final AuthManagement authManagement;

    public ProductCatalogMenu(Context context) {
        this(context.<ProductManagement>getService(ProductManagementService.class),
                context.<OrderManagement>getService(OrderManagementService.class),
                context.<AuthManagement>getService(AuthManagementServices.class));
    }

    public ProductCatalogMenu(ProductManagement productManagement,
                              OrderManagement orderManagement, AuthManagement authManagement) {
        this.productManagement = productManagement;
        this.orderManagement = orderManagement;
        this.authManagement = authManagement;
    }


    @Override
    public void printMenu() {
        var productList = productManagement.getProducts();
        System.out.println("This is lis of our product");
        for (int idx = 0; idx < productList.size(); idx++) {
            System.out.printf("(%d) %s%n", idx, productList.get(idx));
        }
    }

    @Override
    public void run() {
        while (true) {

            var currentuser = authManagement.getCurrentLoginUser();
            if (currentuser == null) {
                break;
            }

            var userInput = getUserInput("input your order (separate by coma)");
            var orderList = getInputIndexList(userInput);
            if (orderList.size() == 0) {
                System.out.println("please insert correct input");
                continue;
            }

            var ordes = new OrderDto();
            ordes.setProducts(getPorductList(orderList));
            ordes.setCustomerId(currentuser.getId());
            orderManagement.addOrder(ordes);
            break;
        }


    }


    private List<Product> getPorductList(List<Integer> oderIndexList) {
        List<Product> products = new ArrayList<>();
        for (var idx : oderIndexList) {
            products.add(productManagement.getProductById(idx));
        }
        return products;
    }


}
