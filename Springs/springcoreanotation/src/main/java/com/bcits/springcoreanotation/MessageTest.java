package com.bcits.springcoreanotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bcits.springcoreanotation.beans.MessageBean;
import com.bcits.springcoreanotation.config.MessageConfig;

public class MessageTest {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(MessageConfig.class);
		MessageBean messageBean = context.getBean(MessageBean.class);
		((ConfigurableApplicationContext)context).registerShutdownHook();

		System.out.println(messageBean.getMessage());
	}
}
