package com.edev.trade.customer.entity;

import com.edev.trade.support.utils.DateUtils;
import lombok.Data;

import java.util.Date;

@Data
public class Customer {
	private Long id;
	private String name;
	private String gender;
	private Date birthdate;
	private String identification;
	private String phoneNumber;
	public Customer() { }

	public Customer(Long id, String name, String gender,
					String identification, String phoneNumber) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.identification = identification;
		setBirthdateByIdentification();
		this.phoneNumber = phoneNumber;
	}

	protected void setBirthdateByIdentification() {
		if(identification==null) return;
		String birthdateStr = identification.substring(6,14);
		this.birthdate = DateUtils.getDate(birthdateStr, "yyyyMMdd");
	}
}
