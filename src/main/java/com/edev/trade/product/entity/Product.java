/* 
 * Created by 2018年9月9日
 */
package com.edev.trade.product.entity;

import lombok.Data;

/**
 * The product entity
 * @author fangang
 */
@Data
public class Product {
	private Long id;
	private String name;
	private Double price;
	private String unit;
	private String classify;
	private String image;
	private Double originalPrice;
	private String tip;
	
	public Product() {}
	public Product(Long id, String name, Double price, String unit,
                   String classify) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.unit = unit;
		this.classify = classify;
	}

	public Product(Long id, String name, Double price, String unit, String classify, String image, Double originalPrice, String tip) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.unit = unit;
		this.classify = classify;
		this.image = image;
		this.originalPrice = originalPrice;
		this.tip = tip;
	}
}
