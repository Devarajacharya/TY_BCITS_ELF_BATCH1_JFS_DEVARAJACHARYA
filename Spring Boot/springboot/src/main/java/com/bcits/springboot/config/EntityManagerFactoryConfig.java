package com.bcits.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

@Configuration
public class EntityManagerFactoryConfig {
	
//	@Bean
//	public LocalContainerEntityManagerFactoryBean getEntityManager() {
//		LocalContainerEntityManagerFactoryBean factoryBean = new  LocalContainerEntityManagerFactoryBean();
//		factoryBean.setPersistenceUnitName("emsPersistenceUnit");
//		return factoryBean;
//	}
	
	@Bean
	public LocalEntityManagerFactoryBean getEntityManagerInstance() {
		LocalEntityManagerFactoryBean factoryBean = new LocalEntityManagerFactoryBean();
		factoryBean.setPersistenceUnitName("emsPersistenceUnit");
		return factoryBean;
	}
}
