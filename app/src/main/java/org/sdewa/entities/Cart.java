package org.sdewa.entities;

import java.util.List;

public interface Cart {


    boolean isEmpty();

    void addProduct();

    List<Product> getProduct();

    void clear();

}
