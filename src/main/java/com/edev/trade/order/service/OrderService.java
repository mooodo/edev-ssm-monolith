package com.edev.trade.order.service;

import com.edev.trade.order.entity.Order;

public interface OrderService {
    Long create(Order order);
    void modify(Order order);
    void delete(Long orderId);
    Order load(Long orderId);
}
