package com.edev.trade.order.dao;

import com.edev.trade.order.entity.Order;
import com.edev.trade.support.query.QueryDao;

import java.util.Collection;
import java.util.Map;

public interface OrderQryDao extends QueryDao {
    Collection<Order> query(Map<String, Object> params);
    long count(Map<String, Object> params);
    Map<String, Object> aggregate(Map<String, Object> params);
}
