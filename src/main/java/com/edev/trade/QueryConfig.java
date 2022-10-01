package com.edev.trade;

import com.edev.trade.customer.dao.AccountQryDao;
import com.edev.trade.customer.dao.CustomerQryDao;
import com.edev.trade.order.dao.OrderItemQryDao;
import com.edev.trade.order.dao.OrderQryDao;
import com.edev.trade.product.dao.ProductQryDao;
import com.edev.trade.support.query.QueryService;
import com.edev.trade.support.query.impl.QueryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueryConfig {
    @Autowired
    private CustomerQryDao customerQryDao;
    @Bean
    public QueryService customerQry() {
        return new QueryServiceImpl(customerQryDao);
    }
    @Autowired
    private AccountQryDao accountQryDao;
    @Bean
    public QueryService accountQry() {
        return new QueryServiceImpl(accountQryDao);
    }
    @Autowired
    private ProductQryDao productQryDao;
    @Bean
    public QueryService productQry() {
        return new QueryServiceImpl(productQryDao);
    }
    @Autowired
    private OrderQryDao orderQryDao;
    @Bean
    public QueryService orderQry() {
        return new QueryServiceImpl(orderQryDao);
    }
    @Autowired
    private OrderItemQryDao orderItemQryDao;
    @Bean
    public QueryService orderItemQry() {
        return new QueryServiceImpl(orderItemQryDao);
    }
}
