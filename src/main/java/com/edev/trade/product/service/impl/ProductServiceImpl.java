package com.edev.trade.product.service.impl;

import com.edev.trade.product.dao.ProductDao;
import com.edev.trade.product.entity.Product;
import com.edev.trade.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.sql.SQLIntegrityConstraintViolationException;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;
    @Override
    public Long saveProduct(Product product) {
        try {
            productDao.insert(product);
        } catch (DataAccessException e) {
            if(e.getCause() instanceof SQLIntegrityConstraintViolationException)
                productDao.update(product);
            else throw e;
        }
        return product.getId();
    }

    @Override
    public void deleteProduct(Long id) {
        productDao.delete(id);
    }

    @Override
    public Product getProduct(Long id) {
        return productDao.load(id);
    }
}
