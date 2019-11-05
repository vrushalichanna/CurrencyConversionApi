package com.innovect.CurrencyConversion.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.innovect.CurrencyConversion.Entity.ExchangeRate;

@Repository
public interface CurrencyConversionRepo extends CrudRepository<ExchangeRate, String>{


	ExchangeRate findByToCurrency(String to);

}
