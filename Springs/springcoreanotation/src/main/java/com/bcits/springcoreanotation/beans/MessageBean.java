package com.bcits.springcoreanotation.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import lombok.Data;

@Data
public class MessageBean implements InitializingBean,DisposableBean{

	private String message;
	public MessageBean() {
		System.out.println("Its Instantiation Phase..");
	}

	public void destroy() throws Exception {
		System.out.println("Its Destroy Phase..");		
	}

	public void afterPropertiesSet() throws Exception {
System.out.println("Its Initialization Phase..");		
	}
	
	
	
}
