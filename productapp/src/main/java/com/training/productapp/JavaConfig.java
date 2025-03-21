package com.training.productapp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("com.training.productapp")
//@PropertySource("classpath:data.properties")
public class JavaConfig {

	@Bean 
	public Product getProduct()
	{
		return new Product("Bike" , 120000 , "Vehicle");
	}
}
