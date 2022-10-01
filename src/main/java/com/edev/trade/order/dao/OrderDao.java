package com.edev.trade.order.dao;

import com.edev.trade.order.entity.Order;

public interface OrderDao {
    void insert(Order order);
    void update(Order order);
    void delete(Long id);
    Order load(Long id);
}
