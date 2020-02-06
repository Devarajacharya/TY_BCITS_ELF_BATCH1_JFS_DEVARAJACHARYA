package com.bcits.springsecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@SuppressWarnings("deprecation")
	@Bean
	public InMemoryUserDetailsManager getInMemoryDetailManager() {
		InMemoryUserDetailsManager inDetailsManager = new InMemoryUserDetailsManager();
		
		inDetailsManager.createUser(
				User.withDefaultPasswordEncoder().username("user").password("pwd").roles("user").build());
		inDetailsManager.createUser(		
				User.withDefaultPasswordEncoder().username("admin").password("qwerty").roles("admin").build());
		return inDetailsManager;	
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeRequests()
		.antMatchers("/home").permitAll()
		.and()
		.authorizeRequests()
		.antMatchers("/userSecurePage").hasRole("user")
		.and()
		.authorizeRequests()
		.antMatchers("/adminSecureHome").hasRole("admin")
		.and()
		.formLogin().loginPage("/login")
		.and()
		.logout().logoutSuccessUrl("/home");
	}
}
