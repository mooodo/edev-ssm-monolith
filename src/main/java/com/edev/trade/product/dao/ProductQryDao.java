package com.edev.trade.product.dao;

import com.edev.trade.customer.entity.Customer;
import com.edev.trade.support.query.QueryDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.Collection;
import java.util.Map;

public interface ProductQryDao extends QueryDao {
    Collection<Customer> query(Map<String, Object> params);
    long count(Map<String, Object> params);
    Map<String, Object> aggregate(Map<String, Object> params);
}
