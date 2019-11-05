package com.innovect.CurrencyConversion.Entity;

import java.util.Date;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CurrencyDetails {

    @JsonProperty("base")
    private String base;


   @JsonProperty("date")
    private Date date;


   @JsonProperty("time_last_updated")
  
   private long timeLastUpdated;
   
   
   @JsonProperty("rates") 
    private Map<String, Double> rates;


public String getBase() {
	return base;
}


public Date getDate() {
	return date;
}


public long getTimeLastUpdated() {
	return timeLastUpdated;
}


public Map<String, Double> getRates() {
	return rates;
}
   
   
}
