package com.bcits.springcoreanotation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.bcits.springcoreanotation.beans.Pet;

@Import(AnimalConfig.class)
@Configuration
public class PetConfig {
	@Bean
	public Pet getPet() {
		return new Pet();
	}
}
