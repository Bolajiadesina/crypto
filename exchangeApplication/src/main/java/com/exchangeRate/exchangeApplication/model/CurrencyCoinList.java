package com.exchangeRate.exchangeApplication.model;

import java.util.ArrayList;

import lombok.Data;

@Data

public class CurrencyCoinList {
	
	
	    public ArrayList<Datum> data;
	
	public static class Chg24h{
	    public ArrayList<String> steps;
	}

	public static class Chg7d{
	    public ArrayList<String> steps;
	}

	public static class CryptoDatum{
	    public String id;
	    public String name;
	    public String country_id;
	    public int pair_id;
	    public String currency_symbol;
	    public String inst_price_usd;
	    public String pair_change_arrow;
	    public String change_percent_1d;
	    public String pair_change_percent_numeric;
	    public String change_percent_1d_color;
	    public String change_percent_7d;
	    public String percent_change_7d_plain;
	    public String change_percent_7d_color;
	    public String cross_rates_name;
	    public String inst_price_btc;
	    public String inst_market_cap;
	    public String inst_market_cap_plain;
	    public String volume_24h_usd;
	    public String volume_24h_usd_plain;
	    public String total_volume_plain;
	    public String total_volume;
	    public String flag_url;
	    public String logo_url;
	    public String circulating_supply;
	    public String circulating_supply_plain;
	}

	public static class CryptoHeaderInfo{
	    public String market_cap;
	    public String vol_24H;
	    public String dominance;
	}

	public static class Datum{
	    public String screen_ID;
	    public ScreenData screen_data;
	}

	public static class MajorCurrency{
	    public int currency_ID;
	    public String currency_short_name;
	    public String major;
	    public String currency_symbol;
	    public String is_crypto;
	    public String fullname;
	    public String country_id;
	}

	public static class MarketCap{
	    public ArrayList<String> steps;
	}

	public static class RangeFilters{
	    public MarketCap market_cap;
	    public Volume24h volume_24h;
	    public TotalVolume total_volume;
	    public Chg24h chg_24h;
	    public Chg7d chg_7d;
	}



	public static class ScreenData{
	    public int next_page;
	    public ArrayList<CryptoDatum> crypto_data;
	    public ArrayList<Object> convertionRates;
	    public ArrayList<MajorCurrency> majorCurrencies;
	    public RangeFilters rangeFilters;
	    public CryptoHeaderInfo crypto_header_info;
	}

	public static class TotalVolume{
	    public ArrayList<String> steps;
	}

	public static class Volume24h{
	    public ArrayList<String> steps;
	}



}
