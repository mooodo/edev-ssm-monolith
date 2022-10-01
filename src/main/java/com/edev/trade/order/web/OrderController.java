package com.edev.trade.order.web;

import com.edev.trade.order.entity.Order;
import com.edev.trade.order.service.OrderService;
import com.edev.trade.support.query.QueryService;
import com.edev.trade.support.query.ResultSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("order")
public class OrderController {
    @Autowired
    private OrderService service;
    @PostMapping("create")
    public Long create(@RequestBody Order order) {
        return service.create(order);
    }
    @PostMapping("modify")
    public void modify(@RequestBody Order order) {
        service.modify(order);
    }
    @GetMapping("delete")
    public void delete(Long orderId) {
        service.delete(orderId);
    }
    @GetMapping("load")
    public Order load(Long orderId) {
        return service.load(orderId);
    }
    @Autowired @Qualifier("orderQry")
    private QueryService queryService;
    @PostMapping("queryOrder")
    public ResultSet query(@RequestBody Map<String, Object> params) {
        return queryService.query(params);
    }
    @Autowired @Qualifier("orderItemQry")
    private QueryService queryItemService;
    @PostMapping("queryItem")
    public ResultSet queryItem(@RequestBody Map<String, Object> params) {
        return queryItemService.query(params);
    }
}
