package com.edev.trade.customer.entity;

import lombok.Data;

@Data
public class Address {
	private Long id;
	private Long customerId;
	private String country;
	private String province;
	private String city;
	private String zone;
	private String address;
	private String phoneNumber;

	public Address() {}

	public Address(Long id, Long customerId, String country, String province, String city, String zone, String address, String phoneNumber) {
		this.id = id;
		this.customerId = customerId;
		this.country = country;
		this.province = province;
		this.city = city;
		this.zone = zone;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}
}
