package com.innovect.CurrencyConversion.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class ExchangeRate {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long id;

	@Column(name = "base")
	private String base;

	@Column(name = "date")
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date date;

	@Column(name = "timeLastUpdated")
	private long timeLastUpdated;

	@Column(name = "toCureency")
	private String toCurrency;
	
	@Column(name = "exchangeRate")
	private Double exchangeRate;
	
	public ExchangeRate() {
	}

	public ExchangeRate(String base, Date date, long timeLastUpdated, String to, Double exchangeRate) {
		super();
		this.base = base;
		this.date = date;
		this.timeLastUpdated = timeLastUpdated;
		this.toCurrency = to;
		this.exchangeRate = exchangeRate;
	}

	public Long getId() {
		return id;
	}

	public String getBase() {
		return base;
	}

	public java.util.Date getDate() {
		return date;
	}

	public long getTimeLastUpdated() {
		return timeLastUpdated;
	}

	public String getToCurrency() {
		return toCurrency;
	}

	public Double getExchangeRate() {
		return exchangeRate;
	}
	
}
