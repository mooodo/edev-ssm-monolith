package com.edev.trade.customer.dao;

import com.edev.trade.customer.entity.Account;
import com.edev.trade.support.query.QueryDao;

import java.util.Collection;
import java.util.Map;

public interface AccountQryDao extends QueryDao {
    Collection<Account> query(Map<String, Object> params);
    long count(Map<String, Object> params);
    Map<String, Object> aggregate(Map<String, Object> params);
}
