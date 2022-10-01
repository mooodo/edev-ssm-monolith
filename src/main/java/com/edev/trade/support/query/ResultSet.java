package com.edev.trade.support.query;

import lombok.Data;

import java.util.Collection;
import java.util.Map;

@Data
public class ResultSet {
	private Collection<?> data;
	private Integer page;
	private Integer size;
	private Long count;
	private Map<String, Object> aggregation;
}
