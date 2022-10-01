package com.edev.trade.customer.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Account {
    private Long id;
    private Double balance;
    private Date createTime;
    private Date updateTime;

    public Account() { }

    public Account(Long id, Double balance, Date createTime, Date updateTime) {
        this.id = id;
        this.balance = balance;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }
}
