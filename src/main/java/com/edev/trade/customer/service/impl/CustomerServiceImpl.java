package com.edev.trade.customer.service.impl;

import com.edev.trade.customer.dao.CustomerDao;
import com.edev.trade.customer.entity.Customer;
import com.edev.trade.customer.service.CustomerService;
import com.edev.trade.support.exception.ValidException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerDao dao;

    private void validCustomer(Customer customer) {
        if(customer.getId()==null) throw new ValidException("The id is null");
        if(customer.getName()==null) throw new ValidException("The name is null");
    }

    @Override
    public Long register(Customer customer) {
        validCustomer(customer);
        dao.insert(customer);
        return customer.getId();
    }

    @Override
    public void modify(Customer customer) {
        validCustomer(customer);
        dao.update(customer);
    }

    @Override
    public void delete(Long customerId) {
        dao.delete(customerId);
    }

    @Override
    public Customer load(Long customerId) {
        return dao.load(customerId);
    }
}
