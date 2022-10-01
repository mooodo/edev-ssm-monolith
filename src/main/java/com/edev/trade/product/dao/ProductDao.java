package com.edev.trade.product.dao;

import com.edev.trade.product.entity.Product;

public interface ProductDao {
    void insert(Product product);
    void update(Product product);
    void delete(Long id);
    Product load(Long id);
}
