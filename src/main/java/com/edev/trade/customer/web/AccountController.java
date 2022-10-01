package com.edev.trade.customer.web;

import com.edev.trade.customer.entity.Account;
import com.edev.trade.customer.service.AccountService;
import com.edev.trade.support.query.QueryService;
import com.edev.trade.support.query.ResultSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("account")
public class AccountController {
    @Autowired
    private AccountService service;
    @PostMapping("createAccount")
    public Long create(@RequestBody Account account) {
        return service.createAccount(account);
    }
    @PostMapping("modifyAccount")
    public void modify(@RequestBody Account account) {
        service.modifyAccount(account);
    }
    @GetMapping("removeAccount")
    public void remove(Long accountId) {
        service.removeAccount(accountId);
    }
    @GetMapping("getAccount")
    public Account get(Long accountId) {
        return service.getAccount(accountId);
    }
    @Autowired @Qualifier("accountQry")
    private QueryService queryService;
    @PostMapping("query")
    public ResultSet query(@RequestBody Map<String, Object> params) {
        return queryService.query(params);
    }
}
