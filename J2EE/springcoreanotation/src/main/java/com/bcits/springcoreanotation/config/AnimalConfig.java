package com.bcits.springcoreanotation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.bcits.springcoreanotation.beans.Elephent;
import com.bcits.springcoreanotation.beans.Goat;

@Configuration
public class AnimalConfig {
	@Bean
	public Goat getAnimal() {
		return new Goat();
	}
	@Bean
	@Primary
	public Elephent getElephent() {
		return new Elephent();
	}
}
