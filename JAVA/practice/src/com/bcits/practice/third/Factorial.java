package com.bcits.practice.third;

/*
 * WAP to find the factorial of the given number
 **/

interface Factnum {
	public int fact(int num);
}

public class Factorial {
	public static void main(String[] args) {
		Factnum f1 = (num) -> {
			int res=1;
			for (int i = num; i > 0; i--) {
				res=res*i;
			}
			return res;	
		};
		System.out.println("The Factorial of the number is : "+f1.fact(4));
	}
	
}