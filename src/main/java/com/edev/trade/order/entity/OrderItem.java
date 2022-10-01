/*
 * created by 2019年7月23日 下午3:46:50
 */
package com.edev.trade.order.entity;

import lombok.Data;

/**
 * @author fangang
 */
@Data
public class OrderItem {
	private Long id;
	private Long orderId;
	private Long productId;
	private Long quantity;
	private Double price;
	private Double amount;

	public OrderItem() {}

	public OrderItem(Long id, Long orderId, Long productId, Long quantity, Double price, Double amount) {
		this.id = id;
		this.orderId = orderId;
		this.productId = productId;
		this.quantity = quantity;
		this.price = price;
		this.amount = amount;
	}
}
