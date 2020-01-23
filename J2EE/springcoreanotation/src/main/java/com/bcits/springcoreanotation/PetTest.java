package com.bcits.springcoreanotation;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bcits.springcoreanotation.beans.Pet;
import com.bcits.springcoreanotation.config.PetConfig;

public class PetTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ApplicationContext context = new AnnotationConfigApplicationContext(PetConfig.class);
		Pet myPet = context.getBean(Pet.class);
		
		System.out.print("Enter the Pet Name : ");
		myPet.setName(sc.nextLine());
		
		System.out.println("Pet Name  : "+myPet.getName());
		myPet.getAnimal().speak();
		myPet.getAnimal().eat();
	}
}
