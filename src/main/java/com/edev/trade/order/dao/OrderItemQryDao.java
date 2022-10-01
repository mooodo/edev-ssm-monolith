package com.edev.trade.order.dao;

import com.edev.trade.order.entity.OrderItem;
import com.edev.trade.support.query.QueryDao;

import java.util.Collection;
import java.util.Map;

public interface OrderItemQryDao extends QueryDao {
    Collection<OrderItem> query(Map<String, Object> params);
    long count(Map<String, Object> params);
    Map<String, Object> aggregate(Map<String, Object> params);
}
