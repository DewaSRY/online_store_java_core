package org.sdewa.services;


import java.util.List;

import org.sdewa.entities.Order;

public interface OrderManagement {


    void addOrder(Order order);

    List<Order> getOrderByUserId(int userId);

    List<Order> getOrders();

}
