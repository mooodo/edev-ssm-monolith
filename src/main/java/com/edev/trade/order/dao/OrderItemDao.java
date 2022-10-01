package com.edev.trade.order.dao;

import com.edev.trade.order.entity.OrderItem;

import java.util.List;

public interface OrderItemDao {
    void insert(OrderItem orderItem);
    void update(OrderItem orderItem);
    void delete(Long id);
    OrderItem load(Long id);
    void deleteByOrderId(Long orderId);
    List<OrderItem> loadByOrderId(Long orderId);
}
