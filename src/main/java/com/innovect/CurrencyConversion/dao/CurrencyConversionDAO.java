package com.innovect.CurrencyConversion.dao;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.innovect.CurrencyConversion.Entity.CurrencyDetails;
import com.innovect.CurrencyConversion.config.CurrencyConversionConfig;

@Component
public class CurrencyConversionDAO {

	 private CurrencyConversionConfig currencyConversionConfig;

	    @Autowired
	    public void currencyConversionConfig( CurrencyConversionConfig currencyConversionConfig) {
	        this.currencyConversionConfig = currencyConversionConfig;
	    }
	    
	    public CurrencyDetails getExchangeRate() {
	        RestTemplate restTemplate=new RestTemplate();
	        URI forecastUri = UriComponentsBuilder.fromUriString(currencyConversionConfig.getCurrencyExchangeApi()).build().toUri();
	        ResponseEntity<CurrencyDetails> entity = restTemplate.getForEntity(forecastUri, CurrencyDetails.class);
	        return entity == null ? null : entity.getBody();
	    }
}
