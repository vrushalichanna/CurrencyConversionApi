package com.innovect.CurrencyConversion.service;

import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innovect.CurrencyConversion.Entity.CurrencyDetails;
import com.innovect.CurrencyConversion.Entity.ExchangeRate;
import com.innovect.CurrencyConversion.dao.CurrencyConversionDAO;
import com.innovect.CurrencyConversion.repo.CurrencyConversionRepo;


@Service
public class CurrencyConversionService {

	CurrencyDetails rate = null;
	@Autowired
	private CurrencyConversionDAO currencyConversionDAO;
	@Autowired
	private CurrencyConversionRepo currencyConversionRepo;
	String base = "USD";
	
	@PostConstruct
	public void init() {
		rate = currencyConversionDAO.getExchangeRate();
		for (Map.Entry<String, Double> currency : rate.getRates().entrySet()) {
			ExchangeRate rateObject = new ExchangeRate(rate.getBase(), rate.getDate(), rate.getTimeLastUpdated(),
					currency.getKey(), currency.getValue());
			currencyConversionRepo.save(rateObject);
		}

	}


	public Double currencyConversion(String from, String to) {
		
		if (from.equals(base)) {
			ExchangeRate currency = currencyConversionRepo.findByToCurrency(to);
			return (currency.getExchangeRate());

		} else if (to.equals(base)) {
			ExchangeRate currency = currencyConversionRepo.findByToCurrency(from);
			return (1 / currency.getExchangeRate());

		} else {
			ExchangeRate fromCurrency = currencyConversionRepo.findByToCurrency(from);
			ExchangeRate toCurrency = currencyConversionRepo.findByToCurrency(to);
			double factor = 1 / fromCurrency.getExchangeRate();
			double exchangeFactor = factor * toCurrency.getExchangeRate();
			return (exchangeFactor);
		}

	}

}
