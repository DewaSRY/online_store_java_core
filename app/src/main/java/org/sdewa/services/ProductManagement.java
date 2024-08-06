package org.sdewa.services;


import java.util.List;

import org.sdewa.entities.Product;

import javax.swing.*;

public interface ProductManagement {


    List<Product> getProducts();

    Product getProductById(int ProductId);

}
