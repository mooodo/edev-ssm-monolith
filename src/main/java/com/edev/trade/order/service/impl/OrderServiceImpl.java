package com.edev.trade.order.service.impl;

import com.edev.trade.order.dao.OrderDao;
import com.edev.trade.order.dao.OrderItemDao;
import com.edev.trade.order.entity.Order;
import com.edev.trade.order.entity.OrderItem;
import com.edev.trade.order.service.OrderService;
import com.edev.trade.support.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private OrderItemDao orderItemDao;
    @Override
    @Transactional
    public Long create(Order order) {
        orderDao.insert(order);
        createOrderItems(order);
        return order.getId();
    }

    private void createOrderItems(Order order) {
        order.getOrderItems().forEach(orderItem -> orderItemDao.insert(orderItem));
    }

    @Override
    @Transactional
    public void modify(Order order) {
        order.setModifyTime(DateUtils.getNow());
        orderDao.update(order);
        deleteOrderItems(order.getId());
        createOrderItems(order);
    }

    @Override
    @Transactional
    public void delete(Long orderId) {
        orderDao.delete(orderId);
        deleteOrderItems(orderId);
    }

    private void deleteOrderItems(Long orderId) {
        orderItemDao.deleteByOrderId(orderId);
    }

    @Override
    public Order load(Long orderId) {
        Order order = orderDao.load(orderId);
        if(order==null) return null;
        List<OrderItem> orderItems = orderItemDao.loadByOrderId(orderId);
        if(orderItems!=null&&!orderItems.isEmpty())
            order.setOrderItems(orderItems);
        return order;
    }
}
