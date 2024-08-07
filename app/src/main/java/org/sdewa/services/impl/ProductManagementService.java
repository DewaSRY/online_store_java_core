package org.sdewa.services.impl;

import org.sdewa.AppContext.Services;
import org.sdewa.entities.Product;
import org.sdewa.services.ProductManagement;

import java.util.Collections;
import java.util.List;

public class ProductManagementService implements ProductManagement, Services {
    private final List<Product> products;


    public ProductManagementService(List<Product> products) {
        this.products = products;
    }

    @Override
    public List<Product> getProducts() {
        return Collections.unmodifiableList(products);

    }

    @Override
    public Product getProductById(int ProductId) {
        return products.get(ProductId);
    }
}
