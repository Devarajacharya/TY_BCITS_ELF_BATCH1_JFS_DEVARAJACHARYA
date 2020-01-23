package com.bcits.springcore.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class MessageBean implements InitializingBean, DisposableBean {

	private String message;

	MessageBean() {
		System.out.println("Its Instantiation Phase..");
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	/*
	 * public void init() { System.out.println("Its Initialization Phase.."); }
	 * 
	 * public void destroy() { System.out.println("Its Destroy Phase.."); }
	 */

	public void afterPropertiesSet() throws Exception {
		System.out.println("Inside init Phase..");
	}

	public void destroy() throws Exception {
		System.out.println("destroying...");
	}

}
