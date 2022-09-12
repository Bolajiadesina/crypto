package com.exchangeRate.exchangeApplication.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;


import org.springframework.beans.factory.annotation.Value;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.exchangeRate.exchangeApplication.model.CurrencyCoinList;
import com.exchangeRate.exchangeApplication.model.ExchangeResponse;
import com.exchangeRate.exchangeApplication.model.ExchangeResponseList;
import com.exchangeRate.exchangeApplication.model.ResponseData;
import com.exchangeRate.exchangeApplication.model.ResponseEnum;

import com.fasterxml.jackson.databind.ObjectMapper;




import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Service
public class ExchangeServiceImpl implements ExchangeService {

	@Value("${api_key}")
	private String apikey;

	@Value("${api_host}")
	private String apiHost;

	private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(ExchangeServiceImpl.class);
//	· Have configurable period to check exchange rates 
//
//	· Endpoint to get latest rate 
//
//	· Endpoint to get rates between two dates 
//	

	@Override
	public ResponseData getRateByDate(String pair, String startDate, String endDate,String offset) {
		OkHttpClient client = new OkHttpClient();
		ResponseData newData = new ResponseData();

		Request request = new Request.Builder().url(
				//"https://investing-cryptocurrency-markets.p.rapidapi.com/coins/get-historical-data?pair_ID=33&date_from=20012020&date_to=19022020&lang_ID=1&time_utc_offset=28800&interval=day")
				"https://investing-cryptocurrency-markets.p.rapidapi.com/coins/get-historical-data?pair_ID="+pair+"&date_from="+startDate+"&date_to="+endDate+"&lang_ID=1&time_utc_offset="+offset+"&interval=day")
				.get().addHeader("X-RapidAPI-Key", apikey).addHeader("X-RapidAPI-Host", apiHost).build();

		try {
			Response response = client.newCall(request).execute();
			newData.setData(response.body().string());
			newData.setResponseCode(ResponseEnum.REQUEST_SUCCESSFUL.getResponseCode());
			newData.setResponseMessage(ResponseEnum.REQUEST_SUCCESSFUL.getResponseMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			newData.setResponseCode(ResponseEnum.REQUEST_FAILED.getResponseCode());
			newData.setResponseMessage(ResponseEnum.REQUEST_FAILED.getResponseMessage());
			return newData;

		}
		return newData;
	}

	@Override
	// public ResponseEntity<ResponseData> getList() {
	public ResponseData getList() {
		OkHttpClient client = new OkHttpClient();
		ResponseData newData = new ResponseData();
		logger.info("apikey====={}", apikey);
		logger.info("apiHost======{}", apiHost);

		Request request = new Request.Builder().url(
				"https://investing-cryptocurrency-markets.p.rapidapi.com/currencies/list?lang_ID=1&time_utc_offset=28800")
				.get().addHeader("X-RapidAPI-Key", apikey).addHeader("X-RapidAPI-Host", apiHost).build();
		
		
		//CurrencyCoinList
		
			

		try {
			Response response = client.newCall(request).execute();
			
//			String xmap="";
//			 try {
//				 xmap = response.body().string();  
//				 logger.info("xmap====={}", xmap);
//				 
//					}catch(Exception ex){ 
//						ex.getMessage();
//					}
//
//				ObjectMapper objectMapper = new ObjectMapper();
//
//				CurrencyCoinList data = objectMapper.readValue(xmap, CurrencyCoinList.class );
//				
//
//				logger.info("response====={}", data);
			
			newData.setData(response.body().string());
			//logger.info("response====={}", response);
			newData.setResponseCode(ResponseEnum.REQUEST_SUCCESSFUL.getResponseCode());
			newData.setResponseMessage(ResponseEnum.REQUEST_SUCCESSFUL.getResponseMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			newData.setResponseCode(ResponseEnum.REQUEST_FAILED.getResponseCode());
			newData.setResponseMessage(ResponseEnum.REQUEST_FAILED.getResponseMessage());
			return newData;
		}
		// return ResponseEntity.ok(newData) ;
		return newData;
	}

	@Override
	public ResponseData convertBitcoin(String fromCurrency,String toCurrency) {
		OkHttpClient client = new OkHttpClient();
		ResponseData newData = new ResponseData();
		
		
		ExchangeResponse xchangeResponse= new ExchangeResponse();
		
		
		ExchangeResponseList xchangeList=  new ExchangeResponseList();
		
		
		
		
		logger.info("apikey====={}", apikey);
		logger.info("apiHost======{}", apiHost);

		
		try {
			Request request = new Request.Builder()
					//.url("https://investing-cryptocurrency-markets.p.rapidapi.com/currencies/get-rate?fromCurrency=190&toCurrency=12&lang_ID=1&time_utc_offset=28800")
					.url("https://investing-cryptocurrency-markets.p.rapidapi.com/currencies/get-rate?fromCurrency="+fromCurrency+"&toCurrency="+toCurrency+"&lang_ID=1&time_utc_offset=28800")
					.get()
					.addHeader("X-RapidAPI-Key", "20ed0af2femsh54ffd3cdabacfadp1e08bbjsn5188693ca951")
					.addHeader("X-RapidAPI-Host", "investing-cryptocurrency-markets.p.rapidapi.com")
					.build();

				Response response = client.newCall(request).execute();
				//logger.info("response====={}", response.body().string());
			
				String xmap ="";
				
		   try {
			 xmap = response.body().string();  
			 logger.info("xmap====={}", xmap);
			 
				}catch(Exception ex){ 
					ex.getMessage();
				}

			ObjectMapper objectMapper = new ObjectMapper();

			ExchangeResponseList data = objectMapper.readValue(xmap, ExchangeResponseList.class );
			

			logger.info("response====={}", data);
			

			
			
			newData.setData(data);
			
			
			newData.setResponseCode(ResponseEnum.REQUEST_SUCCESSFUL.getResponseCode());
			newData.setResponseMessage(ResponseEnum.REQUEST_SUCCESSFUL.getResponseMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			newData.setResponseCode(ResponseEnum.REQUEST_FAILED.getResponseCode());
			newData.setResponseMessage(ResponseEnum.REQUEST_FAILED.getResponseMessage());
			return newData;
		}
		return newData;
	}
	
	
//	public ByteArrayOutputStream writeTofileFeeReport(
//			String partnerName, String today) {
//
//		ByteArrayOutputStream arrayStream = new ByteArrayOutputStream();
//
//		Headers headers = new Headers();
//
//		String fileName = partnerName + "FeeReport".concat(today);
//
//		try {
//
//			// writing for NetSettlementReport
//			XSSFWorkbook workBook = new XSSFWorkbook();
//			Sheet sh = workBook.createSheet(fileName);
//
//			String[] columnHeading = headers.getFeeReportHeader();
//
//			Row headerRow = sh.createRow(0);
//
//			for (int i = 0; i < columnHeading.length; i++) {
//				Cell cell = headerRow.createCell(i);
//				cell.setCellValue(columnHeading[i]);
//			}
//			CreationHelper creationHelper = workBook.getCreationHelper();
//			CellStyle dateStyle = workBook.createCellStyle();
//			dateStyle.setDataFormat(creationHelper.createDataFormat().getFormat("MM/DD/YYY"));
//			int rowNum = 1;
//			for (FeeReportResponse i : feeRespo) {
//				Row row = sh.createRow(rowNum++);
//				row.createCell(0).setCellValue(i.getPartner());
//				row.createCell(1).setCellValue(i.getPartnerCode());
//				row.createCell(2).setCellValue(i.getAmount());
//				row.createCell(3).setCellValue(i.getTotalCharge());
//				row.createCell(4).setCellValue(i.getTotalNibssCommission());
//				row.createCell(5).setCellValue(i.getTotaleProcessCommision());
//				row.createCell(6).setCellValue(i.getTotalPartnerCommision());
//				row.createCell(7).setCellValue(i.getSettlementDate());
//
//			}
//
//			for (int i = 0; i < columnHeading.length; i++) {
//
//				sh.autoSizeColumn(i);
//			}
//
////			FileOutputStream fileOut = new FileOutputStream(
////					"/Users/bolajiadesina/Documents/Ecobank-Projects/nibss/" + partnerName + "Report.xlsx");
//
//			// workBook.write(arrayStream);
//			// fileOut.close();
//
//			// writing for NetSettlementReport
//
//			
//
////			FileOutputStream fileOut3 = new FileOutputStream(
////					"/Users/bolajiadesina/Documents/Ecobank-Projects/nibss/" + partnerName + "Report.xlsx");
//
//			workBook.write(arrayStream);
//			// fileOut3.close();
//
//		} catch (Exception e) {
//
//		}
//
//		return arrayStream;
//
//	}

}
