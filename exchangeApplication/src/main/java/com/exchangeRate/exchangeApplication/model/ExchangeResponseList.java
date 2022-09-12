package com.exchangeRate.exchangeApplication.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class ExchangeResponseList {
	ArrayList<ArrayList<ExchangeResponse>> data;

}
