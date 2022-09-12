package com.exchangeRate.exchangeApplication.model;

import lombok.Data;


public enum ResponseEnum {
	
	REQUEST_SUCCESSFUL("000","Request Succesful"),
	REQUEST_FAILED("99","Request Failed: Sorry we could not process your Request at the moment");
	
	public String getResponseCode() {
		return responseCode;
	}



	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}



	public String getResponseMessage() {
		return responseMessage;
	}



	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}



	private String responseCode;
	private String responseMessage;
	
	
	
	private ResponseEnum(String responseCode, String responseMessage) {
		this.responseCode = responseCode;
		this.responseMessage = responseMessage;
	}
	

}
