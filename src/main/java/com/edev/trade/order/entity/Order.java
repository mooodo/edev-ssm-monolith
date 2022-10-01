/*
 * created by 2019年7月22日 下午3:20:12
 */
package com.edev.trade.order.entity;

import com.edev.trade.support.utils.DateUtils;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author fangang
 */
@Data
public class Order {
	private Long id;
	private Long customerId;
	private Long addressId;
	private Double amount;
	private Date orderTime;
	private Date modifyTime;
	private String flag;
	private List<OrderItem> orderItems;

	public Order() {}

	public Order(Long id, Long customerId, Long addressId, Double amount, Date orderTime, String flag) {
		this.id = id;
		this.customerId = customerId;
		this.addressId = addressId;
		this.amount = amount;
		this.orderTime = (orderTime==null) ? DateUtils.getNow() : orderTime;
		this.flag = (flag==null) ? "create" : flag;
	}

	public Order(Long id, Long customerId, Long addressId) {
		this.id = id;
		this.customerId = customerId;
		this.addressId = addressId;
		this.amount = 0D;
		this.orderTime = DateUtils.getNow();
		this.flag = "create";
	}

	public void addOrderItem(OrderItem orderItem) {
		if(this.orderItems==null) this.orderItems = new ArrayList<>();
		this.orderItems.add(orderItem);
	}
}
