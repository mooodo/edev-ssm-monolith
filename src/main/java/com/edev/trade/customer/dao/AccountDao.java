package com.edev.trade.customer.dao;

import com.edev.trade.customer.entity.Account;

public interface AccountDao {
    void insert(Account account);
    void update(Account account);
    void delete(Long accountId);
    Account load(Long accountId);
}
