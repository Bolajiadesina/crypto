package com.exchangeRate.exchangeApplication.model;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data

public class ExchangeEntity {

	private String pair;
	private String startDate;
	private String endDate;
	private String offset;

}
