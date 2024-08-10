package org.sdewa.menues;


import java.util.List;
import java.util.ArrayList;

import org.sdewa.AppContext.Context;
import org.sdewa.AppContext.Menu;
import org.sdewa.entities.Product;
import org.sdewa.entities.impl.OrderDto;
import org.sdewa.services.impl.AuthManagementServices;
import org.sdewa.services.impl.OrderManagementService;
import org.sdewa.services.impl.ProductManagementService;


public class ProductCatalogMenu implements Menu {
    private final ProductManagementService productManagement;
    private final OrderManagementService orderManagement;
    private final AuthManagementServices authManagement;


    public ProductCatalogMenu(Context context) {
        this.productManagement = context.getService(ProductManagementService.class);
        this.orderManagement = context.getService(OrderManagementService.class);
        this.authManagement = context.getService(AuthManagementServices.class);
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
