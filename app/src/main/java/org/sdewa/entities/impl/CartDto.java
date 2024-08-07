package org.sdewa.entities.impl;


import java.util.List;
import java.util.ArrayList;
import java.util.Collections;


import org.sdewa.entities.Cart;
import org.sdewa.entities.Product;

public class CartDto implements Cart {


    private List<Product> products;

    {
        products = new ArrayList<>();
    }

    @Override
    public boolean isEmpty() {
        return products.isEmpty();
    }

    @Override
    public void addProduct(Product product) {
        if (product == null) {
            return;
        }
        products.add(product);
    }

    @Override
    public List<Product> getProducts() {
        return Collections.unmodifiableList(this.products);
    }

    @Override
    public void clear() {
        products.clear();
    }
}
