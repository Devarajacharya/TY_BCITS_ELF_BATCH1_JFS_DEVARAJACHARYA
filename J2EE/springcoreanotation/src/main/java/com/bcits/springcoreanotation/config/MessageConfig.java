package com.bcits.springcoreanotation.config;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bcits.springcoreanotation.beans.MessageBean;
import com.bcits.springcoreanotation.mypostprocessors.MyBeanFactoryPostProcessor;
import com.bcits.springcoreanotation.mypostprocessors.MyBeanPostProcessor;

@Configuration
public class MessageConfig {

	@Bean(name="messageBean")
	public MessageBean getMessageBean() {
		MessageBean messageBean = new MessageBean();
		messageBean.setMessage("Welcome back to java core..");
		return messageBean;
	}
	@Bean
	public MyBeanPostProcessor getpostProcessor() {
		return new MyBeanPostProcessor();
	}
	@Bean
	public BeanFactoryPostProcessor getFactoryPostProcessor() {
		return new MyBeanFactoryPostProcessor();
	}
}
