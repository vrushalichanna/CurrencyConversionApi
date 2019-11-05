package com.innovect.CurrencyConversion.logger;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CurrencyConversionAOP {
	
	 private Logger logger = LoggerFactory.getLogger(this.getClass());
	 
	 @Before("execution(* com.innovect.CurrencyConversion.service.CurrencyConversionService.*.get*())")
		public void getAllAdvice(){
			System.out.println("Service method  called");
			 logger.info("Service method  called ");
		}
	 
	 @Pointcut("execution(public String currencyConversion())")
		public void getNamePointcut(){}

}
