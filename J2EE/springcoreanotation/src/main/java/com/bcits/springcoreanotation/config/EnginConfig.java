package com.bcits.springcoreanotation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bcits.springcoreanotation.beans.Engin;

@Configuration
public class EnginConfig {
	@Bean
	public Engin getEngin() {
		Engin engin = new Engin();
		engin.setCc(5600);
		engin.setType("Petrol");
		return engin;
	}
}
