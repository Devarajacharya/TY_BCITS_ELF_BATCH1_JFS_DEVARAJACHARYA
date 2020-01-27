package com.bcits.usecasemodule.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

@Configuration
public class EntityManagerFactoryConfig {
	@Bean
	public LocalEntityManagerFactoryBean getEntityManagerFactoryInstance() {
		LocalEntityManagerFactoryBean factoryBean = new LocalEntityManagerFactoryBean();
		factoryBean.setPersistenceUnitName("discomPersistenceUnit");
		return factoryBean;
	}
}
