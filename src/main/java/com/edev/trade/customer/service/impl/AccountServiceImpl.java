package com.edev.trade.customer.service.impl;

import com.edev.trade.customer.dao.AccountDao;
import com.edev.trade.customer.entity.Account;
import com.edev.trade.customer.service.AccountService;
import com.edev.trade.support.exception.ValidException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao dao;

    private void validAccount(Account account) {
        if(account.getId()==null) throw new ValidException("The id is null");
    }

    @Override
    public Long createAccount(Account account) {
        validAccount(account);
        dao.insert(account);
        return account.getId();
    }

    @Override
    public void modifyAccount(Account account) {
        validAccount(account);
        dao.update(account);
    }

    @Override
    public void removeAccount(Long id) {
        if(id!=null)
            dao.delete(id);
    }

    @Override
    public Account getAccount(Long id) {
        if(id==null) return null;
        return dao.load(id);
    }

    @Override
    public Double topUp(Long id, Double amount) {
        Account account = getAccount(id);
        Double balance = account.getBalance() + amount;
        account.setBalance(balance);
        modifyAccount(account);
        return balance;
    }

    @Override
    public Double payoff(Long id, Double amount) {
        Account account = getAccount(id);
        Double balance = account.getBalance() - amount;
        account.setBalance(balance);
        modifyAccount(account);
        return balance;
    }
}
