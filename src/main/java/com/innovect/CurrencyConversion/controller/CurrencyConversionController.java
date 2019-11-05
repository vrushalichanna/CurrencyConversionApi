package com.innovect.CurrencyConversion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.innovect.CurrencyConversion.service.CurrencyConversionService;

@RestController
public class CurrencyConversionController {

	@Autowired
	CurrencyConversionService currencyConversionService;
	
	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public Double currencyConverter(@PathVariable String from, @PathVariable String to, @PathVariable int quantity) {
		Double exchangeRate=currencyConversionService.currencyConversion(from,to);
		return exchangeRate*quantity;
	}
}
