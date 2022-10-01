package com.edev.trade.product.service;

import com.edev.trade.product.entity.Product;

import java.util.Collection;
import java.util.List;

public interface ProductService {
    Long saveProduct(Product product);
    void deleteProduct(Long id);
    Product getProduct(Long id);
}
