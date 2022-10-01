package com.edev.trade.customer.dao;

import com.edev.trade.customer.entity.Customer;

public interface CustomerDao {
    void insert(Customer customer);
    void update(Customer customer);
    void delete(Long customerId);
    Customer load(Long customerId);
}
