package com.edev.trade.customer.web;

import com.edev.trade.customer.entity.Customer;
import com.edev.trade.customer.service.CustomerService;
import com.edev.trade.support.query.QueryService;
import com.edev.trade.support.query.ResultSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("customer")
public class CustomerController {
    @Autowired
    private CustomerService service;
    @PostMapping("register")
    public Long register(@RequestBody Customer customer) {
        return service.register(customer);
    }
    @PostMapping("modify")
    public void modify(@RequestBody Customer customer) {
        service.modify(customer);
    }
    @GetMapping("delete")
    public void delete(Long customerId) {
        service.delete(customerId);
    }
    @GetMapping("load")
    public Customer load(Long customerId) {
        return service.load(customerId);
    }
    @Autowired @Qualifier("customerQry")
    private QueryService queryService;
    @PostMapping("query")
    public ResultSet query(@RequestBody Map<String, Object> params) {
        return queryService.query(params);
    }
}
