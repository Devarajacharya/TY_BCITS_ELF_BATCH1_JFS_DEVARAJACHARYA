/*WAP to add two numbers using Lambda Function*/
package com.bcits.practice.second;

interface addable {
	public int add(int a,int b);
}

public class Add {
	
	public static void main(String[] args) {
		addable r1 = (a,b)->{
			return a+b;
		};
		System.out.println("The sum is : " +r1.add(12, 46));
	}

}

