package com.edev.trade.product.web;

import com.edev.trade.product.entity.Product;
import com.edev.trade.product.service.ProductService;
import com.edev.trade.support.query.QueryService;
import com.edev.trade.support.query.ResultSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("product")
public class ProductController {
    @Autowired
    private ProductService service;
    @PostMapping("saveProduct")
    public Object save(@RequestBody Product product) {
        return service.saveProduct(product);
    }
    @GetMapping("deleteProduct")
    public void delete(Long id) {
        service.deleteProduct(id);
    }
    @GetMapping("getProduct")
    public Product get(Long id) {
        return service.getProduct(id);
    }
    @Autowired @Qualifier("productQry")
    private QueryService queryService;
    @PostMapping("query")
    public ResultSet query(@RequestBody Map<String, Object> json) {
        return queryService.query(json);
    }
}
