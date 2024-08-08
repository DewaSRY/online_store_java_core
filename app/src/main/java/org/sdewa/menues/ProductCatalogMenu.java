package org.sdewa.menues;


import java.util.List;
import java.util.ArrayList;

import org.sdewa.AppContext.Menu;
import org.sdewa.entities.Product;
import org.sdewa.entities.impl.OrderDto;
import org.sdewa.services.impl.AuthManagementServices;
import org.sdewa.services.impl.OrderManagementService;
import org.sdewa.services.impl.ProductManagementService;


public class ProductCatalogMenu implements Menu {
    private ProductManagementService productManagement;
    private OrderManagementService orderManagement;
    private AuthManagementServices authManagement;


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
            if (orderList.isEmpty()) {
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
