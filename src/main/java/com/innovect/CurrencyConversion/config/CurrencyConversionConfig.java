package com.innovect.CurrencyConversion.config;

import org.springframework.stereotype.Component;

@Component
public class CurrencyConversionConfig {

	private String currencyExchangeApi = "https://api.exchangerate-api.com/v4/latest/USD";

	public String getCurrencyExchangeApi() {
		return currencyExchangeApi;
	}

}
