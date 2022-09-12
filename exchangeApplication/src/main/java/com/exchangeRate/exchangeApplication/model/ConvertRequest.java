package com.exchangeRate.exchangeApplication.model;

import java.io.Serializable;

import lombok.Data;



@Data
public class ConvertRequest  {
	
	
	private String fromCurrency;
	private String toCurrency;

    
}