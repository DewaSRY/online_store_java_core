package org.sdewa.services.impl;

import org.sdewa.AppContext.Services;
import org.sdewa.entities.Order;
import org.sdewa.services.OrderManagement;

import java.util.Collections;
import java.util.List;


public class OrderManagementService implements OrderManagement, Services {
    private final List<Order> orders;

    public OrderManagementService(List<Order> order) {
        this.orders = order;
    }


    @Override
    public void addOrder(Order order) {
        orders.add(order);

    }

    @Override
    public List<Order> getOrderByUserId(int userId) {
        return orders.stream()
                .filter(o -> o.getCustomerId() == userId).toList();

    }

    @Override
    public List<Order> getOrders() {
        return Collections.unmodifiableList(orders);
    }
}
