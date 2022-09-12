package com.exchangeRate.exchangeApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.exchangeRate.exchangeApplication.model.ConvertRequest;
import com.exchangeRate.exchangeApplication.model.ExchangeEntity;
import com.exchangeRate.exchangeApplication.model.ResponseData;
import com.exchangeRate.exchangeApplication.service.ExchangeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/exchange")
@RequiredArgsConstructor
public class ExchangeController {

	private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(ExchangeController.class);

	@Autowired
	ExchangeService exchangeService;

	@GetMapping("/getList")
	public ResponseData getList() {
		return exchangeService.getList();
	}

	@RequestMapping(value = ("/convert"), method = { RequestMethod.POST }, produces = {
	"application/json" }, consumes = { "application/json" })
	public ResponseData getRate(@RequestBody ConvertRequest request) {
		logger.info("request{}",request);
		return exchangeService.convertBitcoin(request.getFromCurrency(), request.getToCurrency());
	}

	@RequestMapping(value =("/getRateByDate"), method = { RequestMethod.POST }, produces = {
	"application/json" }, consumes = { "application/json" })
	public ResponseData getRateByDate(@RequestBody ExchangeEntity xchangeEntity) {
		logger.info("xchangeEntity{}",xchangeEntity);
		return exchangeService.getRateByDate(xchangeEntity.getPair(), xchangeEntity.getStartDate(),
				xchangeEntity.getEndDate(), xchangeEntity.getOffset());
	}

}
