package com.exchangeRate.exchangeApplication.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.exchangeRate.exchangeApplication.model.ResponseData;

@Service
public interface ExchangeService  {
		
		static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(ExchangeService.class);
		
		public ResponseData convertBitcoin(String fromCurrency,String toCurrency);
		public ResponseData getRateByDate(String pair, String startDate, String endDate,String offset);

		public ResponseData getList();
		
		
		
		
		

}
