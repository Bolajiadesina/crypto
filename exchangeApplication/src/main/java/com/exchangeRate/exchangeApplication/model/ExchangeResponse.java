package com.exchangeRate.exchangeApplication.model;

import lombok.Data;

@Data
public class ExchangeResponse {
	
//	{
//		  "data": [
//		    [
//		      {
//		        "currency_ID": 12,
//		        "basic": "54.652",
//		        "reverse": "0.0182976",
//		        "digits": 3
//		      }
//		    ]
//		  ]
//		}
	
	private int currency_ID;
	private String basic;
	private String reverse;
	private int digits;
	

}
