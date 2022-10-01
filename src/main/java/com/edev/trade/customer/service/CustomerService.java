package com.edev.trade.customer.service;

import com.edev.trade.customer.entity.Customer;

public interface CustomerService {
    Long register(Customer customer);
    void modify(Customer customer);
    void delete(Long customerId);
    Customer load(Long customerId);
}
