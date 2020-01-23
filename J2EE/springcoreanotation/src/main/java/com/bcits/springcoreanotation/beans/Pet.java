package com.bcits.springcoreanotation.beans;

import org.springframework.beans.factory.annotation.Autowired;

import com.bcits.springcoreanotation.interfaces.Animal;

import lombok.Data;

@Data
public class Pet {

	private String name;
	@Autowired
	private Animal animal;
	
}
